package com.masterbranchacademy.tests.day_11;

import com.masterbranchacademy.utilities.BaseTest;
import com.masterbranchacademy.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() throws InterruptedException {

        WebElement userName = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));

        userName.sendKeys(ConfigReader.getProperties("username"));
        password.sendKeys(ConfigReader.getProperties("password"), Keys.ENTER);
        Thread.sleep(3000);
    }
}
