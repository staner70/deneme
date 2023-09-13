package com.masterbranchacademy.tests.day_12.Etut;

import com.masterbranchacademy.pages.SauceDemoLoginPage;
import com.masterbranchacademy.pages.SaucedemoInventoryPage;
import com.masterbranchacademy.utilities.BaseTest;
import com.masterbranchacademy.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMModel extends BaseTest {

    SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
    SaucedemoInventoryPage dashboardPage = new SaucedemoInventoryPage();

    @Test
    public void positiveTest() throws InterruptedException {
        //        Positive Testcase
        //        1. https://www.saucedemo.com/ url`e gidin
        //        2. giris sayfasinin acildigini dogrulayin
        Assert.assertTrue(loginPage.isLoginBtnDisplayed(), "Page not load");

        //        3. a.dogru kullanici adi ve sifre ile giris yapin
        //        b. istege bagli 'login' adinda bir metod olusturup onunla giris yapma
        loginPage.login();


        //        4. siteye giris yaptiginizi dogrulayin
        String actualProductText = dashboardPage.getProductText();
        String expectedProductText = "Products";
        Assert.assertEquals(actualProductText, expectedProductText, "Product not eqaul");

        //        not: a. kullanici bilgileri properties dosyasina kaydedilecek
        //        b. SaucedemoPage.java class i acilip butun locator lar
        //                oraya yazilip oradan cagrilacak

    }

    @Test
    public void wrongPassword() throws InterruptedException {
        String user = ConfigReader.getProperties("username");
        String password = "yanlisSifre";
        loginPage.loginManipulate(user, password);
    //        Negative Testcase
    //        1. https://www.saucedemo.com/ url`e gidin
    //        2. giris sayfasinin acildigini dogrulayin
    //        3. yanlis bilgilerle girin
    //        4. error messaj aldiginizi dogrulayin
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message esit degildir");
        System.out.println("actualErrorMessage = " + actualErrorMessage);

    }

    @Test
    public void wrongUsername() throws InterruptedException {
        String user = "yanlisUsername";
        String password = ConfigReader.getProperties("password");

        loginPage.loginManipulate(user, password);
        //        Negative Testcase
        //        1. https://www.saucedemo.com/ url`e gidin
        //        2. giris sayfasinin acildigini dogrulayin
        //        3. yanlis bilgilerle girin
        //        4. error messaj aldiginizi dogrulayin
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message esit degildir");
        System.out.println("actualErrorMessage = " + actualErrorMessage);

    }

    @Test
    public void emptyUsername() throws InterruptedException {
        String user = "";
        String password = ConfigReader.getProperties("password");

        loginPage.loginManipulate(user, password);
        //        Negative Testcase
        //        1. https://www.saucedemo.com/ url`e gidin
        //        2. giris sayfasinin acildigini dogrulayin
        //        3. yanlis bilgilerle girin
        //        4. error messaj aldiginizi dogrulayin
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message esit degildir");
        System.out.println("actualErrorMessage = " + actualErrorMessage);


    }

    @Test
    public void emptyPassword() throws InterruptedException {
        String user = ConfigReader.getProperties("username");
        String password = "";

        loginPage.loginManipulate(user, password);
        //        Negative Testcase
        //        1. https://www.saucedemo.com/ url`e gidin
        //        2. giris sayfasinin acildigini dogrulayin
        //        3. yanlis bilgilerle girin
        //        4. error messaj aldiginizi dogrulayin
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message esit degildir");
        System.out.println("actualErrorMessage = " + actualErrorMessage);

    }
}
