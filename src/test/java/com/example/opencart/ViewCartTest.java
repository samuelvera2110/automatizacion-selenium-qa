package com.example.opencart;

import com.example.pages.opencart.HomePage;
import com.example.pages.opencart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ViewCartTest extends BaseTest{

    @Test
    public void verifyProductsInCart(){
        HomePage home = new HomePage();

        home.addMacBookToCart();

        home.utilPause(2000);

        home.addIphoneToCart();

        home.utilPause(2000);

        home.goToShoppingCart();

        ShoppingCartPage cart = new ShoppingCartPage();

        Assert.assertTrue(cart.isAtCartPage(), "¡No estamos en la página del carrito!");

        List<String> productosEnCarrito = cart.getAllProductNames();

        System.out.println("Productos: " + productosEnCarrito);

    }

}
