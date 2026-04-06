package com.example.pages.opencart;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class OrderConfirmationPage extends BasePage {
    private final By confirmationHeading = By.xpath(
            "//h1[contains(text(),'Your order has been placed!')]"
    );
    private final By continueButton = By.xpath(
            "//a[contains(@class,'btn') and contains(text(),'Continue')]"
    );
    private final By orderDetailsTable = By.xpath(
            "//div[@id='content']//table"
    );

    public OrderConfirmationPage() {
        super();
    }

    public boolean isConfirmationDisplayed() {
        return isElementVisible(confirmationHeading);
    }

    public String getConfirmationText() {
        return getText(confirmationHeading);
    }

    public boolean isOrderDetailsVisible() {
        return isElementVisible(orderDetailsTable);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public void waitForConfirmationPage() {
        waitForUrlContains("checkout/success");
        findElement(confirmationHeading);
    }
}
