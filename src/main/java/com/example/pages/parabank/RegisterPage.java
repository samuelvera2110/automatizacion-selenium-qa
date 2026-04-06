package com.example.pages.parabank;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By firstNameInput = By.id("customer.firstName");
    private final By lastNameInput = By.id("customer.lastName");
    private final By addressInput = By.id("customer.address.street");
    private final By cityInput = By.id("customer.address.city");
    private final By stateInput = By.id("customer.address.state");
    private final By zipCodeInput = By.id("customer.address.zipCode");
    private final By phoneNumberInput = By.id("customer.phoneNumber");
    private final By ssnInput = By.id("customer.ssn");
    private final By usernameInput = By.id("customer.username");
    private final By passwordInput = By.id("customer.password");
    private final By confirmPasswordInput = By.id("repeatedPassword");
    private final By registerButton = By.xpath("//input[@value='Register']");
    private final By successMessage = By.xpath("//p[contains(text(), 'Your account was created successfully')]");

    public RegisterPage() {super();}

    public void fillRegisterForm(String fname, String lname, String address, String city,
                                 String state, String zip, String phone, String ssn,
                                 String user, String pass){
        type(firstNameInput, fname);
        type(lastNameInput, lname);
        type(addressInput, address);
        type(cityInput, city);
        type(stateInput, state);
        type(zipCodeInput, zip);
        type(phoneNumberInput, phone);
        type(ssnInput, ssn);
        type(usernameInput, user);
        type(passwordInput, pass);
        type(confirmPasswordInput, pass);
    }

    public void submitForm() {
        click(registerButton);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}
