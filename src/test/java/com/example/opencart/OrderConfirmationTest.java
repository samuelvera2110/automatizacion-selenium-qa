package com.example.opencart;

import com.example.pages.opencart.CheckoutPage;
import com.example.pages.opencart.HomePage;
import com.example.pages.opencart.OrderConfirmationPage;
import com.example.pages.opencart.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderConfirmationTest extends BaseTest{

    @Test
    public void testOrderConfirmationHeadingVisible() {
        HomePage home = new HomePage();
        home.addMacBookToCart();
        home.goToShoppingCart();

        ShoppingCartPage cart = new ShoppingCartPage();
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage();
        checkout.selectGuestCheckout();
        checkout.fillBillingDetails(
                "Samuel", "Vera",
                "samuel.vera@test.com",
                "0987654321",
                "Av. Siempre Viva 123",
                "Guayaquil",
                "Ecuador", "Guayas",
                "090150"
        );
        checkout.confirmShippingAndPayment();
        checkout.clickConfirmOrder();

        OrderConfirmationPage confirmation = new OrderConfirmationPage();
        confirmation.waitForConfirmationPage();

        Assert.assertTrue(
                confirmation.isConfirmationDisplayed(),
                "El heading 'Your order has been placed!' no es visible."
        );
    }
}
