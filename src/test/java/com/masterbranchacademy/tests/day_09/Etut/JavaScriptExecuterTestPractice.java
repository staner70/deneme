package com.masterbranchacademy.tests.day_09.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterTestPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.guru99.com/live-testing-project.html?utm_source=410page&utm_medium=referral&utm_campaign=click");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void javascriptExecuterTest() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement agree = driver.findElement(By.xpath("//button[@mode='primary']"));
        agree.click();

        WebElement titre = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(titre.isDisplayed(), "Page not load");

        //    4. 'Privacy Policy' elemente kadar git
        WebElement privacyElement = driver.findElement(By.xpath("//div[@class='footer-html-inner']//a[1]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", privacyElement);

        //    5. 'Privacy Policy' elementine tikla
        jse.executeScript("arguments[0].click();", privacyElement);
        Thread.sleep(3000);
        //privacyElement.click();


        //    6. ve 'Privacy Policy' sayfasinin acildigini onayla
        WebElement h1 = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(h1.isDisplayed(), "Page not loaded");
        Thread.sleep(3000);

    }

    public void scrollAndClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",element);
        //element.click();
        jse.executeScript("arguments[0].click();", element);
    }

    public void scrollTo(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",element);
    }


}
