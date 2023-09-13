package com.masterbranchacademy.tests.day_02.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName {
    public static void main(String[] args) {

//        Testcase 1
//  1. chrome driver i olusturun
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//  2. driver.get ile https://the-internet.herokuapp.com/windows sitesini acin
        driver.get("https://the-internet.herokuapp.com/windows");

//  3. Opening a new window elementine By.tagName metodu ile  web element olusturun
        WebElement tagName = driver.findElement(By.tagName("h3"));

//  4. ve bu elementin textini bir String`e alin
        String actualText = tagName.getText();
        System.out.println("actualText = " + actualText);
        String expectedText = "Opening a new window";

//  5. ve bu textin Opening a new window oldugunu dogrulayin
        if (expectedText.equals(actualText)) {
            System.out.println("TEST GECTI");
        } else {
            System.out.println("TEST GECMEDI");
        }

//  6. ve chrome driver i kapatin

        driver.close();

    }
}
