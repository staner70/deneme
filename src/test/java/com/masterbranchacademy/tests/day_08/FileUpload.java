package com.masterbranchacademy.tests.day_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
/*        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void fileUpload() throws InterruptedException {
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        String rootPath = System.getProperty("user.dir");
        String relativePath = "\\src\\test\\resources\\data\\testFile.txt";
        String filePathDynamic = rootPath + relativePath;

        fileUpload.sendKeys(filePathDynamic);
        Thread.sleep(3000);
        //fileUpload.submit();
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        Thread.sleep(3000);

        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        String actualMessage = uploadedMessage.getText();
        String expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualMessage,expectedMessage, "File not loaded");

    }
}
