package com.example.parabank;

import com.example.driver.DriverManager;
import com.example.pages.parabank.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver(DriverManager.Browser.CHROME, false);
        DriverManager.getDriver().get("https://parabank.parasoft.com/parabank/");
        homePage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
