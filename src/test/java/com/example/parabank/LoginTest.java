package com.example.parabank;

import com.example.pages.parabank.AccountOverviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testLoginSuccess() {
        String user = "samuel_dev_705a548b";
        String pass = "Pass123";

        homePage.utilPause(1500);

        AccountOverviewPage overviewPage = homePage.login(user, pass);

        String expectedTitle = "Accounts Overview";
        String actualTitle = overviewPage.getTitleText();

        Assert.assertEquals(actualTitle, expectedTitle, "El login falló.");

        System.out.println("Login exitoso con el usuario: " + user);
    }

}
