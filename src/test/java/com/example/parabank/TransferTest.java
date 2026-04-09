package com.example.parabank;

import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.OpenNewAccountPage;
import com.example.pages.parabank.RegisterPage;
import com.example.pages.parabank.TransferFundsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTest extends BaseTest {
    @Test
    public void testTransferBetweenAccountsSuccess() {

        RegisterPage registerPage = homePage.clickRegister();

        registerPage.fillRegisterForm(
                "Samuel", "Vera", "Ecuador", "Guayaquil",
                "Guayas", "090101", "099999", "123",
                username, password);

        registerPage.submitForm();

        AccountOverviewPage overviewPage = new AccountOverviewPage();

        OpenNewAccountPage openAccountPage = overviewPage.goToOpenNewAccount();

        openAccountPage.openAccount("SAVINGS");

        String fromAccountId = openAccountPage.getFromAccountId();
        String toAccountId = openAccountPage.getNewAccountId();

        TransferFundsPage transferPage = overviewPage.goToTransferFunds();

        transferPage.transfer("500", fromAccountId, toAccountId);

        Assert.assertEquals(transferPage.getResultTitle(), "Transfer Complete!");

    }
}
