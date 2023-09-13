package com.masterbranchacademy.tests.day_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }


    @Test
    public void checkBoxTest(){
        WebElement checkBox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input)[2]"));

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        Assert.assertFalse(checkBox1.isSelected(), "Checkbox secili");
        Assert.assertTrue(checkBox2.isSelected(), "Checkbox secili degil");

        checkBox1.click();
        checkBox2.click();

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        Assert.assertTrue(checkBox1.isSelected(), "Checkbox secili");
        Assert.assertFalse(checkBox2.isSelected(), "Checkbox secili degil");

    }
}
