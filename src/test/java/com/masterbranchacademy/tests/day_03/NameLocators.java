package com.masterbranchacademy.tests.day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.name("username"));

        userName.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("SuperSecretPassword!");

        WebElement loginBtn = driver.findElement(By.className("radius"));

        loginBtn.click();

        WebElement actualMessage = driver.findElement(By.tagName("h4"));
        String actualText = actualMessage.getText();
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below";

        if (expectedMessage.equals(actualText)) {
            System.out.println("TEST PASS");
        } else {
            System.out.println("TEST FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualText = " + actualText);
        }


        Thread.sleep(5000);
        driver.close();

    }
}
