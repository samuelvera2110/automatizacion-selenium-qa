package com.example.opencart.steps;

import com.example.driver.DriverManager;
import com.example.opencart.AddProductsTest;
import com.example.pages.opencart.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class CartSteps {

    private HomePage home;

    @Before
    public void setUp() {
        DriverManager.initDriver(DriverManager.Browser.CHROME, false);
        DriverManager.getDriver().get("http://opencart.abstracta.us/index.php?route=common/home");
        home = new HomePage();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Dado("que el usuario está en la página principal de OpenCart")
    public void usuarioEnPaginaPrincipal() {
        // @Before ya inicializa todo
    }

    @Cuando("el usuario agrega un MacBook al carrito")
    public void agregarMacBook() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,500)");
        home.addMacBookToCart();
    }

    @Entonces("debe ver el mensaje de éxito que contiene {string}")
    public void verificarMensajeExito(String mensaje) {
        Assert.assertTrue(home.getSuccessMessageText().contains(mensaje));
    }

    @Cuando("el usuario agrega un iPhone al carrito")
    public void agregarIphone() {
        home.addIphoneToCart();
        home.utilPause(2000);
    }

    @Entonces("el carrito debe mostrar {string}")
    public void verificarTotalCarrito(String items) {
        Assert.assertTrue(home.getCartTotalText().contains(items));
    }
}