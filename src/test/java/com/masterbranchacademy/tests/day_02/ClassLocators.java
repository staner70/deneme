package com.masterbranchacademy.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassLocators {
    public static void main(String[] args) throws InterruptedException {


        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.manage().window().maximize();

        // driver.findElement() bize web elementin hangi locator cesidi ile bulmamiza yardimci olur
        // findElement(By.className) class ismiyle ulasmamizi saglar
        WebElement element = driver.findElement(By.className("radius"));

        element.click();

        Thread.sleep(3000);
        driver.close();
    }
}
