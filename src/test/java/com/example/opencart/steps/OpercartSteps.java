package com.example.opencart.steps;

import io.cucumber.java.es.Dado;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.example.driver.*;
import com.example.driver.DriverManager.Browser;
import com.example.pages.opencart.CheckoutPage;
import com.example.pages.opencart.HomePage;
import com.example.pages.opencart.OrderConfirmationPage;
import com.example.pages.opencart.ShoppingCartPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class OpercartSteps {
    private HomePage homePage;
    private ShoppingCartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderConfirmationPage confirmationPage;

    @Before
    public void setUp() {
        DriverManager.initDriver(Browser.CHROME, false);
        homePage = new HomePage();
        cartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
        confirmationPage = new OrderConfirmationPage();
    }

    @Dado("que el usuario está en la página principal de OpenCart")
    public void usuarioEnPaginaPrincipal() {
        DriverManager.getDriver().get("http://opencart.abstracta.us/index.php?route=common/home");

    }

    @Cuando("el usuario agrega un MacBook al carrito")
    public void agregarMacBook() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,500)");
        homePage.addMacBookToCart();
    }

    @Cuando("el usuario agrega un iPhone al carrito")
    public void agregarIphone() {
        homePage.utilPause(2000);
        homePage.addIphoneToCart();
    }

    @Cuando("navega al carrito de compras")
    public void navegarAlCarrito() {
        homePage.utilPause(2000);
        homePage.goToShoppingCart();
    }

    @Cuando("selecciona la opción de checkout")
    public void seleccionarCheckout() {
        cartPage.clickCheckout();
    }

    @Cuando("elige checkout como invitado")
    public void elegirInvitado() {
        checkoutPage.selectGuestCheckout();
    }

    @Cuando("completa los datos de facturación con nombre {string}, apellido {string} y correo {string}")
    public void completarDatosFacturacion(String nombre, String apellido, String email) {
        checkoutPage.fillBillingDetails(
                nombre, apellido, email,
                "0987654321", "Av. Siempre Viva 123", "Guayaquil",
                "Ecuador", "Guayas", "090150");
    }

    @Cuando("confirma el envío y método de pago")
    public void confirmarEnvioYPago() {
        checkoutPage.confirmShippingAndPayment();
    }

    @Cuando("confirma la orden")
    public void confirmarOrden() {
        checkoutPage.clickConfirmOrder();
    }

    @Entonces("debe ver el mensaje de éxito que contiene {string}")
    public void verificarMensajeExito(String mensajeEsperado) {
        Assert.assertTrue(homePage.getSuccessMessageText().contains(mensajeEsperado));
    }

    @Entonces("el carrito debe mostrar {string}")
    public void verificarTotalCarrito(String totalEsperado) {
        String totalActual = homePage.getCartTotalText();
        Assert.assertTrue(totalActual.contains(totalEsperado), "Error: " + totalActual);
    }

    @Entonces("la URL debe contener {string} o {string}")
    public void verificarUrl(String path1, String path2) {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains(path1) || currentUrl.contains(path2),
                "URL inesperada: " + currentUrl);
    }

    @Entonces("debe visualizarse el mensaje {string}")
    public void visualizarMensajeConfirmacion(String mensaje) {
        confirmationPage.waitForConfirmationPage();
        Assert.assertTrue(confirmationPage.isConfirmationDisplayed());
    }

    @Entonces("debe estar en la página del carrito")
    public void verificarPaginaCarrito() {
        Assert.assertTrue(cartPage.isAtCartPage());
    }

    @Entonces("debe ver la lista de productos agregados")
    public void verificarListaProductos() {
        List<String> productos = cartPage.getAllProductNames();
        Assert.assertFalse(productos.isEmpty(), "La lista de productos está vacía");
        System.out.println("Productos en carrito: " + productos);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
