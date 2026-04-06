package com.example.pages.parabank;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By registerLink = By.linkText("Register");

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton   = By.xpath("//input[@value='Log In']");

    public HomePage() {
        super();
    }

    public RegisterPage clickRegister() {
        click(registerLink);
        return new RegisterPage();
    }

    public AccountOverviewPage login(String username, String password){
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new AccountOverviewPage();
    }

    public void utilPause(long ms){
        pause(ms);
    }

}
