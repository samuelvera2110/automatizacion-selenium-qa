package com.example.pages.opencart;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By macBookAddToCart = By.xpath("//button[contains(@onclick, '43') and contains(@onclick, 'cart.add')]");
    private final By iphoneAddToCart  = By.xpath("//button[contains(@onclick, '40') and contains(@onclick, 'cart.add')]");

    private final By cartTotalButton = By.id("cart-total");
    private final By successMessage = By.cssSelector(".alert-success");

    public HomePage() {
        super();
    }

    public void addMacBookToCart() {
        click(macBookAddToCart);
    }

    public void addIphoneToCart() {
        click(iphoneAddToCart);
    }

    public String getSuccessMessageText() {
        return getText(successMessage);
    }

    public String getCartTotalText() {
        return getText(cartTotalButton);
    }

    public void utilPause(long ms){
        pause(ms);
    }

    public void goToShoppingCart() {
        /*click(cartButtonContainer);
        click(viewCartLink);*/
        navigateTo("https://opencart.abstracta.us/index.php?route=checkout/cart");
    }
}
