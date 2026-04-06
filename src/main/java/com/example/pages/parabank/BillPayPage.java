package com.example.pages.parabank;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class BillPayPage extends BasePage {
    private final By payeeNameInput = By.name("payee.name");
    private final By addressInput = By.name("payee.address.street");
    private final By cityInput = By.name("payee.address.city");
    private final By stateInput = By.name("payee.address.state");
    private final By zipCodeInput = By.name("payee.address.zipCode");
    private final By phoneInput = By.name("payee.phoneNumber");
    private final By accountInput = By.name("payee.accountNumber");
    private final By verifyAccountInput = By.name("verifyAccount");
    private final By amountInput = By.name("amount");
    private final By sendPaymentButton = By.xpath("//input[@value='Send Payment']");

    private final By successTitle = By.xpath("//h1[text()='Bill Payment Complete']");

    public BillPayPage() { super(); }

    public void fillBillPayForm(String name, String address, String city, String state,
                                String zip, String phone, String account, String amount) {
        type(payeeNameInput, name);
        type(addressInput, address);
        type(cityInput, city);
        type(stateInput, state);
        type(zipCodeInput, zip);
        type(phoneInput, phone);
        type(accountInput, account);
        type(verifyAccountInput, account);
        type(amountInput, amount);
    }

    public void submitPayment() {
        click(sendPaymentButton);
    }

    public String getSuccessTitle() {
        return getText(successTitle);
    }
}
