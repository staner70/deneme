package com.masterbranchacademy.tests.day_12;

import com.masterbranchacademy.pages.LoginPage;
import com.masterbranchacademy.utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
       LoginPage loginPage = new LoginPage();
       loginPage.login();
       Thread.sleep(3000);

       String expectedUserName = "qaengineer";
       Assert.assertEquals(loginPage.getUserNameText(), expectedUserName, "User name yanlis");

    }
}
