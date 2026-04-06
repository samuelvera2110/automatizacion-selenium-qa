package com.example.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public enum Browser{
        CHROME, FIREFOX, EDGE
    }

    private static final ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();

    private DriverManager() {}

    public static void initDriver(Browser browser, boolean headless) {
        IDriverFactory factory = resolveFactory(browser, headless);
        driverHolder.set(factory.createDriver());
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverHolder.get();
        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver no inicializado."
            );
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = driverHolder.get();
        if (driver != null) {
            driver.quit();
            driverHolder.remove();
        }
    }

    private static IDriverFactory resolveFactory(Browser browser, boolean headless) {
        return switch (browser) {
            case CHROME  -> new ChromeDriverFactory(new ChromeOptionsBuilder(headless));
            //case FIREFOX -> new FirefoxDriverFactory(new FirefoxOptionsBuilder(headless));
            //case EDGE    -> new EdgeDriverFactory(new EdgeOptionsBuilderInline(headless));
            default -> throw new IllegalArgumentException("Browser no soportado: " + browser);
        };
    }

}
