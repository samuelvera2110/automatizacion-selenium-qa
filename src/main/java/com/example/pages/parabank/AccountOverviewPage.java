package com.example.pages.parabank;

import com.example.pages.BasePage;
import org.openqa.selenium.By;

public class AccountOverviewPage extends BasePage {
    private final By title = By.className("title");
    private final By billPayLink = By.linkText("Bill Pay");
    private final By transferFundsLink = By.linkText("Transfer Funds");

    public AccountOverviewPage() {
        super();
    }

    public String getTitleText() {
        return getText(title);
    }

    public BillPayPage goToBillPay() {
        click(billPayLink);
        return new BillPayPage();
    }

    public TransferFundsPage goToTransferFunds() {
        click(transferFundsLink);
        return new TransferFundsPage();
    }

}
