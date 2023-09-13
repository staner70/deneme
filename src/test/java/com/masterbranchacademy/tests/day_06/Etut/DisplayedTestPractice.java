package com.masterbranchacademy.tests.day_06.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisplayedTestPractice {
      //  displayed test
        //    1. Tarayıcıyı başlatın
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //    2. 'https://demoqa.com/dynamic-properties' URL'sine gidin
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeDriver(){
        //    7. driver`i kapatin
        driver.quit();
    }

    @Test
    public void displayTest() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement title = driver.findElement(By.className("main-header"));
        String actualTitle = title.getText();
        String expectedTitle = "Dynamic Properties";
        Assert.assertEquals(actualTitle,expectedTitle, "Page not load");

        //    4. 'Visible After 5 seconds' dugmesinin gorunur olmadigini dogrulayin
        boolean visibleAfterButton;
        try{
            WebElement visibleAfter = driver.findElement(By.id("visibleAfter"));
            System.out.println("try catch");
            Assert.assertFalse(visibleAfter.isDisplayed(),"Visible After 5 seconds mevcud");
            visibleAfterButton = true;
        }catch (Exception e){
            visibleAfterButton = false;
            System.out.println("e = " + e);
        }
        System.out.println("visibleAfterButton : "+visibleAfterButton);
        Assert.assertFalse(visibleAfterButton,"Visible After 5 seconds mevcud");

        //    5. 6 saniye bekleme ekleyin
        Thread.sleep(6000);

        //    6. 'Visible After 5 seconds' dugmesinin gorunur oldugunu dogrulayin
        WebElement displayedBtnAfter5 = driver.findElement(By.id("visibleAfter"));
        Assert.assertTrue(displayedBtnAfter5.isDisplayed(), "Visible After 5 seconds button is displayed");
    }




}
