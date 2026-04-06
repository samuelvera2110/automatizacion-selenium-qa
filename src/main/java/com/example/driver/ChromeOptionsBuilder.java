package com.example.driver;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeOptionsBuilder implements IDriverOptions<ChromeOptions> {

    private final boolean headless;

    public ChromeOptionsBuilder(boolean headless) {
        this.headless = headless;
    }

    @Override
    public ChromeOptions buildOptions() {
        ChromeOptions op = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        op.setExperimentalOption("prefs", prefs);
        if (headless) {
            op.addArguments("--headless=new");
        }
        op.addArguments("--start-maximized");
        op.addArguments("--disable-notifications");
        op.addArguments("--remote-allow-origins=*");
        op.addArguments("--ignore-certificate-errors");
        op.addArguments("--ignore-ssl-errors");
        op.addArguments("--allow-insecure-localhost");
        op.setAcceptInsecureCerts(true);

        return op;
    }
}
