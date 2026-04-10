package com.example.parabank.steps;

import com.example.pages.parabank.HomePage;

import org.testng.Assert;

import com.example.driver.DriverManager;
import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.BillPayPage;
import com.example.pages.parabank.OpenNewAccountPage;
import com.example.pages.parabank.RegisterPage;
import com.example.pages.parabank.TransferFundsPage;
import com.example.utils.DataGenerator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ParabankSteps {
    private HomePage homePage;
    private RegisterPage registerPage;
    private AccountOverviewPage overviewPage;
    private String username;
    private String password;

    @Before
    public void setUp() {
        DriverManager.initDriver(DriverManager.Browser.CHROME, false);
        DriverManager.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        homePage = new HomePage();
        username = DataGenerator.generateUsername();
        password = DataGenerator.generatePassword();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Dado("que el usuario está en la página principal de ParaBank")
    public void usuarioEnPaginaPrincipal() {
        
    }

    @Cuando("el usuario se registra con nombre {string} apellido {string}")
    public void registrarUsuario(String nombre, String apellido) {
        registerPage = homePage.clickRegister();
        registerPage.fillRegisterForm(
                nombre, apellido,
                "Ecuador", "Guayaquil", "Guayas",
                "090101", "099999", "123",
                username, password
        );
        registerPage.submitForm();
        overviewPage = new AccountOverviewPage();
    }

    @Cuando("el usuario cierra sesión")
    public void cerrarSesion() {
        homePage.logout();
        homePage.utilPause(1500);
    }

    @Cuando("el usuario inicia sesión")
    public void iniciarSesion() {
        overviewPage = homePage.login(username, password);
    }

    @Cuando("el usuario abre una nueva cuenta de tipo {string}")
    public void abrirNuevaCuenta(String tipoCuenta) {
        OpenNewAccountPage openAccountPage = overviewPage.goToOpenNewAccount();
        openAccountPage.openAccount(tipoCuenta);

        fromAccountId = openAccountPage.getFromAccountId();
        toAccountId   = openAccountPage.getNewAccountId();
    }

    @Cuando("el usuario transfiere {string} entre sus cuentas")
    public void transferirFondos(String monto) {
        TransferFundsPage transferPage = overviewPage.goToTransferFunds();
        transferPage.transfer(monto, fromAccountId, toAccountId);
        this.transferPage = transferPage;
    }

    @Cuando("el usuario paga una factura a {string} por {string}")
    public void pagarFactura(String payee, String monto) {
        billPayPage = new AccountOverviewPage().goToBillPay();
        billPayPage.fillBillPayForm(
                payee, "Av. Principal 123", "Guayaquil", "Guayas",
                "090101", "0987654321", "12345", monto
        );
        billPayPage.submitPayment();
    }

    @Entonces("debe ver la página {string}")
    public void verificarTituloPagina(String tituloEsperado) {
        Assert.assertEquals(
                overviewPage.getTitleText(),
                tituloEsperado,
                "El login falló."
        );
        System.out.println("Login exitoso con usuario: " + username);
    }

    @Entonces("debe ver el mensaje {string}")
    public void verificarMensajeRegistro(String mensajeEsperado) {
        Assert.assertEquals(
                registerPage.getSuccessMessage(),
                mensajeEsperado,
                "El registro falló para el usuario: " + username
        );
        System.out.println("Usuario registrado: " + username);
    }

    @Entonces("debe ver el título de transferencia {string}")
    public void verificarTituloTransferencia(String tituloEsperado) {
        Assert.assertEquals(
                transferPage.getResultTitle(),
                tituloEsperado
        );
    }

    @Entonces("debe ver el título de pago {string}")
    public void verificarTituloPago(String tituloEsperado) {
        Assert.assertEquals(
                billPayPage.getSuccessTitle(),
                tituloEsperado,
                "El pago no se completó."
        );
        System.out.println("Pago realizado con éxito.");
    }

    private String fromAccountId;
    private String toAccountId;
    private TransferFundsPage transferPage;
    private BillPayPage billPayPage;
}
