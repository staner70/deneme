package com.masterbranchacademy.tests.day_02.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkText {
    public static void main(String[] args) throws InterruptedException {

//        Testcase 4
//  1. chrome driver i olusturun
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//  2. driver.get ile https://demoqa.com/links sitesini acin
        driver.get("https://demoqa.com/links");

//  3. Bad Request linkini By.partialLinkText metodu ve "Bad" ile  web element olusturun
        WebElement linkElement = driver.findElement(By.partialLinkText("Bad"));

//  4. ve bu elemente tilayin
        linkElement.click();
        Thread.sleep(5000);

//  5. ve chrome driver i kapatin
        driver.quit();

    }
}
