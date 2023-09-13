package com.masterbranchacademy.tests.day_06.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownListTest {
    //   dropdown list test

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //    1. Tarayıcıyı başlatın
        //System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //    2. 'https://demo.guru99.com/test/drag_drop.html' URL'sine gidin
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeDriver(){
        //    7. driver`i kapatin
        driver.quit();
    }

    @Test
    public void dropdownListTest() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement pageLoadText = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(pageLoadText.getText(), "Selenium Drag and Drop Example:", "Page not loaded");

        //    4. Selenium acilir penceredeki butun elementleri liste alin
        WebElement dropdownSelenium = driver.findElement(By.cssSelector("#navbar-brand-centered > ul > li:nth-child(1) > a"));
        Thread.sleep(3000);
        dropdownSelenium.click();

        Thread.sleep(5000);
        List<WebElement> dropdownList = driver.findElements(By.cssSelector("#navbar-brand-centered > ul > li.dropdown.open > ul a"));
        
        //    5. listin uzunlugunu 20 oldugunu dogrulayin
        System.out.println("dropdownList.size() = " + dropdownList.size());
        Assert.assertTrue(dropdownList.size() == 20, "list not equal to 20");


        //    6. 'listin 'Table Demo' iceerip icermedigini dogrulayin

        boolean containsTableDemo = false;
        for (WebElement element : dropdownList) {
            System.out.println("element.getText() = " + element.getText());
            if (element.getText().contains("Table Demo")) {
                containsTableDemo = true;
            }
        }
        Assert.assertTrue(containsTableDemo, "List not contain Table Demo");
    }




}
