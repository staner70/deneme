package com.masterbranchacademy.tests.day_07.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class AlertTest1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void alertTest1() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
/*        WebElement header = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div"));
        String actualTitle = header.getText();
        String expectedTitle = "Browser Windows";
        Assert.assertEquals(actualTitle,expectedTitle, "Page not load");*/
        WebElement loadPage = driver.findElement(By.className("main-header"));
        Assert.assertTrue(loadPage.isDisplayed(), "Page not load");

        //    4. mevcut windows`un tanimlayicisini alin
        String mainWindowHandle =  driver.getWindowHandle();
        System.out.println("mainWindowHandle = " + mainWindowHandle);

        //    5. 'New Tab' button a tiklayin
        WebElement newTabBtn = driver.findElement(By.id("tabButton"));

        newTabBtn.click();
        Thread.sleep(3000);
        
        //    6. butun windowslarin tanimlayicilarini alin
        Set<String> actualWindowHandles = driver.getWindowHandles();


        //    7. ikinci windows taki 'This is a sample page' yazisinin oldugunu dogrulayin

        for (String handle : actualWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }

        WebElement textSecondWindow = driver.findElement(By.id("sampleHeading"));
        String actualText = textSecondWindow.getText();
        String expectedText = "This is a sample page";

        Assert.assertEquals(actualText,expectedText, "The text 'This is a sample page' was not found in the new tab.");


    }




}
