package com.masterbranchacademy.tests.day_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledElement {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }

    @Test
    public void disabledElement() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//input[@type='text']"));

        System.out.println("element.isEnabled() = " + element.isEnabled());

        Assert.assertFalse(element.isEnabled(), "TEST fail, element active");

        WebElement button = driver.findElement(By.xpath("//input[@type='text']/following::button"));
        button.click();

        Thread.sleep(3000);

        System.out.println("element.isEnabled() = " + element.isEnabled());
        Assert.assertTrue(element.isEnabled(), "TEST fail, element inactive");

    }
}
