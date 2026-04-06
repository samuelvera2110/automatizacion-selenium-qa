package com.example.parabank;

import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.BillPayPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WithdrawalTest extends BaseTest{

    @Test
    public void testWithdrawalSuccess() {

        AccountOverviewPage overviewPage = homePage.login("samuel_dev_705a548b", "Pass123");

        BillPayPage billPayPage = overviewPage.goToBillPay();

        billPayPage.fillBillPayForm(
                "Servicios Varios", "Av. Principal 123", "Guayaquil", "Guayas",
                "090101", "0987654321", "12345", "100.00"
        );

        billPayPage.submitPayment();

        String expected = "Bill Payment Complete";
        Assert.assertEquals(billPayPage.getSuccessTitle(), expected, "El retiro no se completó.");

        System.out.println("Retiro realizado con éxito.");
    }

}
