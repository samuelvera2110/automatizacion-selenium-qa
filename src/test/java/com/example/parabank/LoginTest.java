package com.example.parabank;

import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.RegisterPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testLoginSuccess() {
       
        RegisterPage registerPage = homePage.clickRegister();

        registerPage.fillRegisterForm("Samuel", "Vera", "Ecuador", "Guayaquil","Guayas", "090101", "099999", "123", username, password);

        registerPage.submitForm();

        homePage.logout();

        homePage.utilPause(1500);

        AccountOverviewPage overviewPage = login();

        String expectedTitle = "Accounts Overview";
        String actualTitle = overviewPage.getTitleText();

        Assert.assertEquals(actualTitle, expectedTitle, "El login falló.");

        System.out.println("Login exitoso con el usuario: " + username);
    }

}
