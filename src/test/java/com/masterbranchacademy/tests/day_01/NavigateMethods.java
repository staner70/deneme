package com.masterbranchacademy.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // get() metodu sitenin acilmasina yardimci olur
        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        driver.navigate().to("https://www.youtube.com");

        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.close();
    }
}
