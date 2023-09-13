package com.masterbranchacademy.tests.day_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/download");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void fileDownload() throws InterruptedException {
        WebElement file = driver.findElement(By.linkText("Image.PNG"));
        file.click();
        Thread.sleep(3000);

        String rootPath = System.getProperty("user.home");
        String relativePath = "\\Downloads\\Image.PNG";
        String fullPath = rootPath + relativePath;
        Assert.assertTrue(Files.exists(Paths.get(fullPath)), "File not downloaded" );
    }



}
