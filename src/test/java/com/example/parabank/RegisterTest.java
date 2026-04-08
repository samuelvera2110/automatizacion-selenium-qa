package com.example.parabank;

import com.example.pages.parabank.RegisterPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void testUserRegistrationSuccess() {

        RegisterPage registerPage = homePage.clickRegister();

        registerPage.fillRegisterForm(
                "Samuel", "Vera", "Ecuador", "Guayaquil",
                "Guayas", "090101", "099999", "123",
                username, password);

        registerPage.submitForm();

        String expectedMsg = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(registerPage.getSuccessMessage(), expectedMsg,
                "El registro falló. Es posible que el usuario '" + username + "' ya exista.");
        System.out.println("Usuario registrado: " + username);
    }

}
