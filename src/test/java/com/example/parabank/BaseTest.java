package com.example.parabank;

import com.example.driver.DriverManager;
import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.HomePage;
import com.example.utils.DataGenerator;
import com.intuit.karate.driver.Driver;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected HomePage homePage;
    protected String username = DataGenerator.generateUsername();
    protected String password = DataGenerator.generatePassword();

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver(DriverManager.Browser.CHROME, false);
        DriverManager.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        homePage = new HomePage();
    }

    public AccountOverviewPage login(){
        return homePage.login(username, password);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
