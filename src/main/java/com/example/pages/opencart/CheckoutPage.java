package com.example.pages.opencart;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By guestCheckoutRadio  = By.xpath("//input[@value='guest']");
    private final By continueStep1Button = By.id("button-account");

    private final By firstNameInput  = By.id("input-payment-firstname");
    private final By lastNameInput   = By.id("input-payment-lastname");
    private final By emailInput      = By.id("input-payment-email");
    private final By telephoneInput  = By.id("input-payment-telephone");
    private final By addressInput    = By.id("input-payment-address-1");
    private final By cityInput       = By.id("input-payment-city");
    private final By postCodeInput   = By.id("input-payment-postcode");
    private final By countrySelect   = By.id("input-payment-country");
    private final By zoneSelect      = By.id("input-payment-zone");
    private final By continueStep2Button = By.id("button-guest");

    private final By continueStep4Button = By.id("button-shipping-method");
    private final By termsCheckbox       = By.xpath("//input[@name='agree']");
    private final By continueStep5Button = By.id("button-payment-method");
    private final By confirmOrderButton  = By.id("button-confirm");
    

    public CheckoutPage() {
        super();
    }

    public void selectGuestCheckout() {
        click(guestCheckoutRadio);
        click(continueStep1Button);
    }

    public void fillBillingDetails(String fname, String lname, String email,
                                   String phone, String address, String city,
                                   String country, String zone, String postCode) {
        waitForClickable(firstNameInput, 30);

        type(firstNameInput, fname);
        type(lastNameInput, lname);
        type(emailInput, email);
        type(telephoneInput, phone);
        type(addressInput, address);
        type(cityInput, city);
        type(postCodeInput, postCode);
        selectByVisibleText(countrySelect, country);
        waitForZoneToLoad(zoneSelect, zone);
        selectByVisibleText(zoneSelect, zone);

        scrollToElement(continueStep2Button);
        click(continueStep2Button);
    }

    public void confirmShippingAndPayment() {
        if (isButtonClickable(continueStep4Button, 5)) {
            scrollToElement(continueStep4Button);
            click(continueStep4Button);
        }
        waitForClickable(termsCheckbox, 30);
        scrollToElement(termsCheckbox);
        click(termsCheckbox);

        scrollToElement(continueStep5Button);
        click(continueStep5Button);
    }

    public void clickConfirmOrder() {
        waitForClickable(confirmOrderButton, 30);
        scrollToElement(confirmOrderButton);
        click(confirmOrderButton);
    }
}
