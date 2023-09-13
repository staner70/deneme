package com.masterbranchacademy.tests.day_07.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTask {


    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void iframeTest() throws InterruptedException {


        //        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Frames";
        Assert.assertEquals(actualTitle, expectedTitle, "Page not loaded");
        //Assert.assertTrue(actualTitle.contains(expectedTitle), "Page not loaded");
        WebElement pageload = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(pageload.isDisplayed(), "Page not load");

        //        4. 'IFrame Demo textini' bir String e alip yazdirin
        driver.switchTo().frame("singleframe");
        WebElement frameText = driver.findElement(By.xpath("//section/div[@class='container']/h5"));
        String frameTextString = frameText.getText();
        System.out.println("frameTextString = " + frameTextString);

        Thread.sleep(3000);
        //        5. input box a 'Master Branch Academy' yazdirin
        WebElement inputBox = driver.findElement(By.tagName("input"));
        inputBox.sendKeys("Master Branch Academy");

        //        6. 3 saniye bekleme ekleyin
        Thread.sleep(3000);


    }


}
