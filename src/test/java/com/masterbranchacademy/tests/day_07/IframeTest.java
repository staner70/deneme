package com.masterbranchacademy.tests.day_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }
    
    @Test
    public void iframeTest() throws InterruptedException {
        WebElement baslikYazisi = driver.findElement(By.tagName("h3"));
        System.out.println("baslikYazisi.getText() = " + baslikYazisi.getText());


        //Iframe acma veya icine gitme
        // 3 cesit yolla yapilabilir
        // 1. metod index ile
        //driver.switchTo().frame(0);

        // 2. metod name veya id ile
        //driver.switchTo().frame("mce_0_ifr");

        // 3. metod ile
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        WebElement yazi = driver.findElement(By.id("tinymce"));
        System.out.println("yazi.getText() = " + yazi.getText());

        Thread.sleep(3000);
        // clear() metodu bir input box kutusunu temizler
        yazi.clear();
        yazi.sendKeys("bu bir iframe testidir");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        WebElement poweredText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println("poweredText.getText() = " + poweredText.getText());
    }
}
