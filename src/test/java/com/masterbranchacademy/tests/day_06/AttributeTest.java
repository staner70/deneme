package com.masterbranchacademy.tests.day_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttributeTest {
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
    public void getAttributeTest(){
        WebElement element = driver.findElement(By.tagName("input"));
        String attributeValue = element.getAttribute("type");

        System.out.println("type = " + element.getAttribute("type"));
        System.out.println("id = " + element.getAttribute("id"));
        System.out.println("name = " + element.getAttribute("name"));
        System.out.println("class = " + element.getAttribute("class"));
    }


}
