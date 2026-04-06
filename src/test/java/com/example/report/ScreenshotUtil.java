package com.example.report;

import com.example.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Base64;

public final class ScreenshotUtil {

    private ScreenshotUtil() {}

    /**
     * Captures the current browser screen.
     *
     * @return Base64-encoded PNG string, or {@code null} if capture fails.
     */
    public static String captureBase64() {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver instanceof TakesScreenshot) {
                byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                return Base64.getEncoder().encodeToString(bytes);
            }
        } catch (Exception e) {
            System.err.println("[ScreenshotUtil] Could not capture screenshot: " + e.getMessage());
        }
        return null;
    }
}