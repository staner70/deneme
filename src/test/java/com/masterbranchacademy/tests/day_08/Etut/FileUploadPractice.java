package com.masterbranchacademy.tests.day_08.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FileUploadPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void fileUpload(){
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
/*        WebElement titre = driver.findElement(By.tagName("h1"));
        String actualTitre = titre.getText();
        String expectedTitre = "Upload a File";
        Assert.assertEquals(actualTitre, expectedTitre,"Page not load");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleIs(expectedTitre));*/
        WebElement fileInput = driver.findElement(By.id("fileinput"));
        Assert.assertTrue(fileInput.isDisplayed(), "Page not loaded");


        //    4. bir tane dosya yukleyin
        //WebElement fileInput = driver.findElement(By.id("fileinput"));
        String rootPath = System.getProperty("user.dir");
        String relativePath = "\\src\\test\\resources\\data\\testFile.txt";
        String fullPath = rootPath + relativePath;
        System.out.println("fullPath = " + fullPath);
        fileInput.sendKeys(fullPath);

        //    5. 'Upload button a tiklayin
        fileInput.submit();

        //    6. dosyanin basarili bir sekilde yukledigine dair dogrulamayi yapin
        WebElement titreUploadedFile = driver.findElement(By.tagName("h1"));
        String actualUploadedTitre = titreUploadedFile.getText();
        String expectedUploadedTitre = "Uploaded File";
        Assert.assertEquals(actualUploadedTitre, expectedUploadedTitre, "File not loaded");

    }





}
