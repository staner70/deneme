package com.masterbranchacademy.tests.day_02.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassName {
    public static void main(String[] args) throws InterruptedException {

//        Testcase 5
//  1. chrome driver i olusturun
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//  2. driver.get ile https://demoqa.com/ sitesini acin
        driver.get("https://demoqa.com/");

//  3. Elements elementine By.className metodu ile  web element olusturun
        WebElement classNameElement = driver.findElement(By.className("card-body"));

//  4. ve bu elemente tilayin
        classNameElement.click();

//  5. ve 3 saniye bekleme ekleyin
        Thread.sleep(3000);

//  6. ve chrome driver i kapatin
        driver.quit();
    }
}
