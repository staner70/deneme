package com.masterbranchacademy.tests.day_06.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AttributeTestPractice {
       // 1. Tarayıcıyı başlatın
       // 2. 'https://demoqa.com/dynamic-properties' URL'sine gidin
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }



    @Test
    public void attributeTest() throws InterruptedException {

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın

        WebElement title = driver.findElement(By.className("main-header"));
        String actualTitle = title.getText();
        String expectedTitle = "Dynamic Properties";
        Assert.assertEquals(actualTitle,expectedTitle, "Page not load");

        // 4. 'Color Change' dugmesinin class attribute de 'text-danger' olmadigini dogrulayin
        WebElement colorBtn = driver.findElement(By.id("colorChange"));

        //String danger = colorBtn.getAttribute("class");

        Assert.assertFalse(colorBtn.getAttribute("class").contains("text-danger"), "class attribute 'text-danger' iceriyor");

        //5. 5 saniye bekleme ekleyin
        Thread.sleep(5000);

        //6. 'Color Change' dugmesinin class attribute de 'text-danger' oldugunu dogrulayin
        Assert.assertTrue(colorBtn.getAttribute("class").contains("text-danger"), "class attribute 'text-danger' icermiyor");

    }






}
