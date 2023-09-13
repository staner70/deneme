package com.masterbranchacademy.tests.day_05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }

    @Test
    public void radioButton() throws InterruptedException {
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));

        System.out.println("yesRadio.isSelected() = " + yesRadio.isSelected());
        Assert.assertFalse(yesRadio.isSelected(), "yes button secili");


        WebElement yesRadio2 = driver.findElement(By.xpath("//*[@id='yesRadio']/.."));

        Thread.sleep(5000);
        yesRadio2.click();


        Thread.sleep(5000);

        System.out.println("yesRadio.isSelected() = " + yesRadio.isSelected());
        Assert.assertFalse(yesRadio.isSelected(), "yes button secili");


    }


}
