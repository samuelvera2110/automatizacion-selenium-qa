package com.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements IDriverFactory{

    private final IDriverOptions<ChromeOptions> driverOptions;

    public ChromeDriverFactory(IDriverOptions<ChromeOptions> driverOptions) {
        this.driverOptions = driverOptions;
    }

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(driverOptions.buildOptions());
    }
}
