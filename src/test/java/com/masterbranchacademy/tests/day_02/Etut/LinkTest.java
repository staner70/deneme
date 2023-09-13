package com.masterbranchacademy.tests.day_02.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTest {
    public static void main(String[] args) throws InterruptedException {


//        Testcase 3
//  1. chrome driver i olusturun
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//  2. driver.get ile https://demoqa.com/links sitesini acin
        driver.get("https://demoqa.com/links");

//  3. Home linkini By.linkText metodu ile web element olusturun
        WebElement homeElement = driver.findElement(By.linkText("Home"));

//  4. ve bu elemente tilayin
        homeElement.click();

        Thread.sleep(5000);

//  5. ve chrome driver i kapatin
        driver.quit();

    }
}
