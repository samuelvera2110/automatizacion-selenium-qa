package com.example.pages.parabank;

import org.openqa.selenium.By;
import com.example.pages.BasePage;

public class OpenNewAccountPage extends BasePage{
    private final By accountTypeSelect = By.id("type");
    private final By openAccountButton = By.xpath("//input[@value='Open New Account']");
    private final By newAccountId = By.id("newAccountId");
    private final By fromAccountId = By.cssSelector("#fromAccountId");

    public OpenNewAccountPage() {
        super();
    }

    public void openAccount(String type) {
        selectByVisibleText(accountTypeSelect, type);
        pause(500);
        click(openAccountButton);
        waitForInvisibility(newAccountId);
    }

    public String getNewAccountId() {
        return getText(newAccountId);
    }

    public String getFromAccountId(){
        return getText(fromAccountId);
    }
}
