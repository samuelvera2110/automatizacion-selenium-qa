package com.example.pages.parabank;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class TransferFundsPage extends BasePage {
    private final By amountInput = By.id("amount");
    private final By fromAccountIdSelect = By.id("fromAccountId");
    private final By toAccountIdSelect = By.id("toAccountId");
    private final By transferButton = By.xpath("//input[@value='Transfer']");

    private final By successMessage = By.xpath("//h1[text()='Transfer Complete!']");

    public TransferFundsPage() { super(); }

    public void transfer(String amount, int fromAccountIndex, int toAccountIndex) {
        pause(1000);

        type(amountInput, amount);
        selectByIndex(fromAccountIdSelect, fromAccountIndex);
        selectByIndex(toAccountIdSelect, toAccountIndex);
        click(transferButton);
    }

    public String getResultTitle() {
        return getText(successMessage);
    }
}
