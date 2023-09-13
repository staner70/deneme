package com.masterbranchacademy.tests.day_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void multipleWindowTest(){
        WebElement yeniPencere = driver.findElement(By.linkText("Click Here"));
        yeniPencere.click();
        
        String mevcutPencere = driver.getWindowHandle();
        System.out.println("mevcutPencere = " + mevcutPencere);
        Set<String> windowHandels = driver.getWindowHandles();

        for (String windowHandel : windowHandels) {
            if (!windowHandel.equals(mevcutPencere)) {
                driver.switchTo().window(windowHandel);
            }
        }
        
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "New Window";
        Assert.assertEquals(actualTitle, expectedTitle, "Page not open");
    }

    @Test
    public void ikidenFazlaPencer() throws InterruptedException {
        WebElement yeniPencere = driver.findElement(By.linkText("Click Here"));
        yeniPencere.click();
        driver.findElement(By.xpath("//div[@id='page-footer']//a")).click();

        
        Set<String> butunPencereler = driver.getWindowHandles();
        System.out.println("butunPencereler.size() = " + butunPencereler.size());

        for (String pencere : butunPencereler) {
            driver.switchTo().window(pencere);
            if (driver.getTitle().equals("Elemental Selenium | Elemental Selenium")) {
                break;
                }
        }
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Elemental Selenium | Elemental Selenium";
        Assert.assertEquals(actualTitle, expectedTitle, "Page not open");
        
    }
}
