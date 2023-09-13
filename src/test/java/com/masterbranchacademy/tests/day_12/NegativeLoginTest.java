package com.masterbranchacademy.tests.day_12;

import com.masterbranchacademy.pages.LoginPage;
import com.masterbranchacademy.utilities.BaseTest;
import com.masterbranchacademy.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {
    @Test
    public void wrongUserNameTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();

        loginPage.negativeLogin("demoqa", ConfigReader.getProperties("password"));

        String expectedMessage = "Invalid username or password!";
        Assert.assertEquals(loginPage.errorMessage(), expectedMessage, "Giris basarili");
        Thread.sleep(3000);
    }

    @Test
    public void wrongPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();

        loginPage.negativeLogin(ConfigReader.getProperties("username"), "password");

        String expectedMessage = "Invalid username or password!";
        Assert.assertEquals(loginPage.errorMessage(), expectedMessage, "Giris basarili");
        Thread.sleep(3000);
    }
}
