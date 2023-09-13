package com.masterbranchacademy.tests.day_07.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
/*        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/

        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
       driver.quit();
    }

    @Test
    public void multipleWindowsTest1() throws InterruptedException {

        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Upload a File";
        Assert.assertEquals(actualTitle,expectedTitle, "Page not load");

        //    4. bir tane dosya yukleyin

        WebElement fileInput = driver.findElement(By.id("fileinput"));
        fileInput.sendKeys("C:\\Users\\TANER\\Pictures\\p_gs.png");

        Thread.sleep(3000);
        //    5. 'Upload button a tiklayin
        fileInput.submit();
        Thread.sleep(3000);

        //    6. dosyanin basarili bir sekilde yukledigine dair dogrulamayi yapin
        String actualFile = driver.findElement(By.id("uploadedfilename")).getText();
        String expectedFile = "p_gs.png";
        Assert.assertEquals(actualFile,expectedFile, "File not loaded");


    }


}
