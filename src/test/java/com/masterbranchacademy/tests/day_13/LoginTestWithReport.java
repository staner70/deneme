package com.masterbranchacademy.tests.day_13;

import com.masterbranchacademy.pages.LoginPage;
import com.masterbranchacademy.utilities.BaseTest;
import com.masterbranchacademy.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestWithReport extends BaseTest {

    @Test
    public void loginTestWithReport(){
        LoginPage loginPage = new LoginPage();
        extentLogger = reports.createTest("Login Test With Report");

        extentLogger.info("username yazilir");
        loginPage.username.sendKeys(ConfigReader.getProperties("username"));

        extentLogger.info("passwordu giriniz");
        loginPage.password.sendKeys(ConfigReader.getProperties("password"));

        extentLogger.info("login buttonina tiklanir");
        loginPage.loginButton.click();

        Assert.assertEquals(loginPage.getUserNameText(), "qaengineer", "kullanici ayni degil");
    }

}
