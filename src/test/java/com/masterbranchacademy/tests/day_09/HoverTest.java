package com.masterbranchacademy.tests.day_09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement user1 = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);

        actions.moveToElement(user1).perform();
        Thread.sleep(3000);

        WebElement nameUser1 = driver.findElement(By.xpath("(//h5)[1]"));
        String actualText = nameUser1.getText();
        String expectedText = "name: user1";

        Assert.assertEquals(actualText, expectedText, "test esit degildir");
    }

    @Test
    public void keysTest() throws InterruptedException {
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));

        WebElement btnCookies = driver.findElement(By.id("L2AGLb"));
        btnCookies.click();
        Thread.sleep(3000);

        //searchBox.sendKeys("IPHONE 14 PRO MAX vs samsung s23 ultra");
        Actions actions = new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT)
                .sendKeys("iphone 14 pro max")
                .keyUp(searchBox, Keys.SHIFT)
                .sendKeys(" vs samsung s23 ultra")
                .pause(5000).sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(3000);

    }
}
