package com.masterbranchacademy.tests.day_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlert {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }

    @Test
    public void acceptAlert() throws InterruptedException {

        WebElement birinciAlert = driver.findElement(By.xpath("(//button)[1]"));
        birinciAlert.click();

        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();
        System.out.println("birinciAlertText = " + actualAlertText);
        Assert.assertEquals(expectedAlertText, actualAlertText, "Alert texti esit degildir");

        driver.switchTo().alert().accept();

        Thread.sleep(3000);

        WebElement alertMessage = driver.findElement(By.id("result"));

        String actualMessage = alertMessage.getText();
        String expectedMessage = "You successfully clicked an alert";
        System.out.println("alertMessage.getText() = " + alertMessage.getText());
        Assert.assertEquals(actualMessage, expectedMessage, "Basarili bir sekilde alerti kapatamadiniz");


    }

    @Test
    public void dismissAlert() throws InterruptedException {
        WebElement ikinciAlert = driver.findElement(By.xpath("(//button)[2]"));
        ikinciAlert.click();

        String expectedIkinciAlertText = "I am a JS Confirm";
        String actualIkinciAlertText = driver.switchTo().alert().getText();
        System.out.println("actualIkinciAlertText = " + actualIkinciAlertText);
        Assert.assertEquals( actualIkinciAlertText, expectedIkinciAlertText,"Ikinci alert texti esit degildir");

        driver.switchTo().alert().dismiss();

        Thread.sleep(3000);

        WebElement alertMessage = driver.findElement(By.id("result"));

        String actualMessage = alertMessage.getText();
        String expectedMessage = "You clicked: Cancel";
        System.out.println("alertMessage.getText() = " + alertMessage.getText());
        Assert.assertEquals(actualMessage, expectedMessage, "Basarili bir sekilde alerti red edemediniz");
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        WebElement ucuncuAlert = driver.findElement(By.xpath("(//button)[3]"));
        ucuncuAlert.click();

        String expectedAlertText = "I am a JS prompt";
        String actualAlertText = driver.switchTo().alert().getText();
        System.out.println("actualIkinciAlertText = " + actualAlertText);
        Assert.assertEquals( actualAlertText, expectedAlertText,"Prompt alert texti esit degildir");

        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello World");

        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        WebElement alertMessage = driver.findElement(By.id("result"));

        String actualMessage = alertMessage.getText();
        String expectedMessage = "You entered: Hello World";
        System.out.println("alertMessage.getText() = " + alertMessage.getText());
        Assert.assertEquals(actualMessage, expectedMessage, "Basarili bir sekilde alerti red edemediniz");

    }
}
