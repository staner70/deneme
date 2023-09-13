package com.masterbranchacademy.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetMethods {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println("driver.getTitle() = " + driver.getTitle());


        String actualTitle = driver.getTitle();

        String expectedTitle = "Amazon.com. Spend less. Smile more";

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title testi Gecti");
        } else {
            System.out.println("Title testi gecemedi");
        }


        // getCurrentUrl() bize sayfanin url'ini getirir

        System.out.println("getCurrentUrl " + driver.getCurrentUrl());

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("URL testi Gecti");
        } else {
            System.out.println("Url testi gecemedi");
        }

        // getWindowHandle() tarayicinin ozel tanimlayicisini getirir (id)
        System.out.println(driver.getWindowHandle());



        System.out.println(driver.getPageSource());
        String pageSource = driver.getPageSource();

        if (pageSource.contains(expectedTitle)) {
            System.out.println("Page Source testi Gecti");
        } else {
            System.out.println("Page Source gecemedi");
        }

        driver.close();
        
    }
}
