package com.masterbranchacademy.tests.day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("#username"));
        //WebElement password = driver.findElement(By.cssSelector("div > input[id='password']"));
        //WebElement password = driver.findElement(By.cssSelector("form input[name='password']"));
        //WebElement password = driver.findElement(By.cssSelector("[name='password']"));
        //WebElement password = driver.findElement(By.cssSelector("input#password"));
        //WebElement password = driver.findElement(By.cssSelector("input[name='password'][id='password']"));
        //WebElement password = driver.findElement(By.cssSelector("input[id*='word']"));
        //WebElement password = driver.findElement(By.cssSelector("input[id^='pass']"));
        WebElement password = driver.findElement(By.cssSelector("input[id$='word']"));

        username.sendKeys("Css Selector");
        password.sendKeys("Password");

        Thread.sleep(1000);

        //WebElement button = driver.findElement(By.cssSelector(".radius"));
        WebElement button = driver.findElement(By.cssSelector("button.radius"));
        button.click();

        Thread.sleep(1000);
        driver.close();
    }
}
