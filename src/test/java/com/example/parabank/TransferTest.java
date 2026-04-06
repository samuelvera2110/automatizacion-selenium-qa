package com.example.parabank;

import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTest extends BaseTest{
    @Test
    public void testTransferBetweenAccountsSuccess() {
        AccountOverviewPage overviewPage = homePage.login("samuel_dev_705a548b", "Pass123");

        TransferFundsPage transferPage = overviewPage.goToTransferFunds();

        transferPage.transfer("500", 0, 0);

        String expected = "Transfer Complete!";
        Assert.assertEquals(transferPage.getResultTitle(), expected, "La transferencia no se completó correctamente.");

        System.out.println("Transferencia realizada con éxito.");
    }
}
