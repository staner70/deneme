package com.masterbranchacademy.tests.day_09;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void javascriptExecuter() throws InterruptedException {

        driver.get("https://amazon.fr/");
        //WebElement tinymce = driver.findElement(By.linkText("WYSIWYG Editor"));

        WebElement btnCookies = driver.findElement(By.id("sp-cc-accept"));
        btnCookies.click();
        Thread.sleep(3000);
        WebElement amazon = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
        //amazon.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", amazon);
        Thread.sleep(3000);
        //amazon.click();
        jse.executeScript("arguments[0].click();", amazon);
        Thread.sleep(3000);
    }

    @Test
    public void sendkeyTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("(//input)[2]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "jse test";

        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", input);
        Thread.sleep(3000);
    }
}
