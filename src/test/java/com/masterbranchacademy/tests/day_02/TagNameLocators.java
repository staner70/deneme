package com.masterbranchacademy.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagNameLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.manage().window().maximize();


        WebElement element = driver.findElement(By.tagName("h2"));

        String baslikYazisi = element.getText();
        System.out.println("baslikYazisi = " + baslikYazisi);

        WebElement button = driver.findElement(By.tagName("button"));

        Thread.sleep(2000);
        button.click();

        Thread.sleep(2000);
        driver.close();
    }
}
