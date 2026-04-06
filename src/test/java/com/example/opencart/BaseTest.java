package com.example.opencart;

import com.example.driver.DriverManager;
import com.example.pages.opencart.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver(DriverManager.Browser.CHROME, false);
        DriverManager.getDriver().get("http://opencart.abstracta.us/index.php?route=common/home");
        homePage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
