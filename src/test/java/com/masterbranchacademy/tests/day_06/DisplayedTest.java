package com.masterbranchacademy.tests.day_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DisplayedTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        //driver.close();
    }

    @Test
    public void isDisplayedTest() throws InterruptedException {
        WebElement startButton = driver.findElement(By.tagName("button"));

        System.out.println(startButton.isDisplayed());

        Assert.assertTrue(startButton.isDisplayed(), "element orada mevcut degil");

       // Thread.sleep(3000);
        WebElement elementHidden = driver.findElement(By.id("finish"));
        System.out.println("elementHidden = " + elementHidden.isDisplayed());
        Assert.assertFalse(elementHidden.isDisplayed(), "element orada mevcut");
    }
}
