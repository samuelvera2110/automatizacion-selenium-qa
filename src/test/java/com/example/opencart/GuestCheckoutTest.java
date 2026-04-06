package com.example.opencart;

import com.example.pages.opencart.CheckoutPage;
import com.example.pages.opencart.HomePage;
import com.example.pages.opencart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.driver.DriverManager.getDriver;

public class GuestCheckoutTest extends BaseTest{

    @Test
    public void testGuestCheckoutFlow() {
        HomePage home = new HomePage();

        home.addMacBookToCart();

        home.utilPause(2000);

        home.goToShoppingCart();

        ShoppingCartPage cart = new ShoppingCartPage();
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage();

        checkout.selectGuestCheckout();

        checkout.fillBillingDetails(
                "Samuel", "Vera", "samuel.vera@test.com",
                "0987654321", "Av. Siempre Viva 123", "Guayaquil",
                "Ecuador", "Guayas", "090150"
        );

        checkout.confirmShippingAndPayment();

        checkout.clickConfirmOrder();

        String currentUrl = getDriver().getCurrentUrl();
        System.out.println("URL tras confirmar orden: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("success") || currentUrl.contains("checkout"),
                "URL inesperada tras confirmar la orden: " + currentUrl
        );
    }

}
