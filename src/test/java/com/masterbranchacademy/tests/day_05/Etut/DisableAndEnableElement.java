package com.masterbranchacademy.tests.day_05.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisableAndEnableElement {
            /*
        1. Tarayıcıyı başlatın
        2. 'https://demoqa.com/dynamic-properties' URL'sine gidin
        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        4. 'Will enable 5 seconds' dugmesinin disable oldugunu dogrulayin
        5. 5 saniye bekleme ekleyin
        6. 'Will enable 5 seconds' dugmesinin enable oldugunu dogrulayin
        7. driver`i kapatin
        */
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
    public void pageLoadAndEnableTest() throws InterruptedException {
        WebElement title = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div"));
        String actualTitle = title.getText();
        String expectedTitle = "Dynamic Properties";
        Assert.assertEquals(actualTitle,expectedTitle, "Page not load");

        Thread.sleep(3000);

        WebElement willEnable = driver.findElement(By.id("enableAfter"));

        System.out.println(willEnable.isEnabled());
        Assert.assertFalse(willEnable.isEnabled(), "'Will enable 5 seconds' dugmesi enable ");

        Thread.sleep(5000);

        Assert.assertTrue(willEnable.isEnabled(), "'Will enable 5 seconds' dugmesi disable ");
    }


}
