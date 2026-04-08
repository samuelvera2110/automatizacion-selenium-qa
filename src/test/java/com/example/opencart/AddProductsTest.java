package com.example.opencart;

import com.example.driver.DriverManager;
import com.example.pages.opencart.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductsTest extends BaseTest {

    @Test
    public void testAddProductsToCartSuccess() {

        HomePage store = new HomePage();

        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,500)");

        store.addMacBookToCart();

        Assert.assertTrue(store.getSuccessMessageText().contains("Success: You have added MacBook"));

        store.addIphoneToCart();

        store.utilPause(2000);

        String totalText = store.getCartTotalText();

        Assert.assertTrue(totalText.contains("2 item(s)"), "Error: " + totalText);

        System.out.println("Se agregaron dos productos al carrito correctamente.");
    }

}
