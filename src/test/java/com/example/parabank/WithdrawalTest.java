package com.example.parabank;

import com.example.pages.parabank.AccountOverviewPage;
import com.example.pages.parabank.BillPayPage;
import com.example.pages.parabank.RegisterPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WithdrawalTest extends BaseTest {

    @Test
    public void testWithdrawalSuccess() {

        RegisterPage registerPage = homePage.clickRegister();

        registerPage.fillRegisterForm(
                "Samuel", "Vera", "Ecuador", "Guayaquil",
                "Guayas", "090101", "099999", "123",
                username, password);

        registerPage.submitForm();

        BillPayPage billPayPage = new AccountOverviewPage().goToBillPay();

        billPayPage.fillBillPayForm(
                "Servicios Varios", "Av. Principal 123", "Guayaquil", "Guayas",
                "090101", "0987654321", "12345", "100.00");

        billPayPage.submitPayment();

        String expected = "Bill Payment Complete";
        Assert.assertEquals(billPayPage.getSuccessTitle(), expected, "El retiro no se completó.");

        System.out.println("Retiro realizado con éxito.");
    }

}
