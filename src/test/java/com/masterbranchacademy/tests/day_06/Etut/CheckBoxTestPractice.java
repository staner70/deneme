package com.masterbranchacademy.tests.day_06.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTestPractice {
        //    1. Tarayıcıyı başlatın
        //    2. 'https://demoqa.com/checkbox' URL'sine gidin

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();
    }

    //    9. driver`i kapatin
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        //    3.  Checkbox sayfanın başarıyla göründüğünü doğrulayın
        WebElement loadPage = driver.findElement(By.xpath("//div[text()='Check Box']"));
        Assert.assertEquals(loadPage.getText(), "Check Box", "Page not loaded");

        //    4. Checkbox secili olmadigini dogrulayin
        WebElement checkbox = driver.findElement(By.id("tree-node-home"));
        Assert.assertFalse(checkbox.isSelected(), "checkbox is selected");

        //    5. 3 saniye bekleme ekleyin
        Thread.sleep(3000);

        //    6. Checkbox tiklayin
        WebElement checkboxBtn = driver.findElement(By.cssSelector("#tree-node-home + span"));
        checkboxBtn.click();

        //    7. Checkbox secili oldugunu dogrulayin
        Assert.assertTrue(checkbox.isSelected(), "checkbox is not selected");

        //    8. 'You have selected' mesajinin ekranda gorundugunu (displyed) dogrulayin
        WebElement resultText = driver.findElement(By.xpath("//*[@id='result']/span"));
        Assert.assertEquals(resultText.getText(), "You have selected :", "message: 'You have selected' not displayed");
    }



}
