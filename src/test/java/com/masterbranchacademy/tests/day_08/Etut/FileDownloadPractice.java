package com.masterbranchacademy.tests.day_08.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class FileDownloadPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/download/download.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void downloadTest() {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTest = "Download File Via JavaScript";
        Assert.assertEquals(actualTitle,expectedTest, "Page not load");

        //    4. 'Direct Link Download' tusuna tiklayin
        WebElement directLinkBtn = driver.findElement(By.id("direct-download"));
        directLinkBtn.click();


        //    5. 'textfile.txt' dosyasini indigini dogrulayin
       // String downloadPath = "C:\\Users\\TANER\\Downloads"; // İndirme klasörünüzün yolunu buraya ekleyin.
       // Path filePath = Paths.get(downloadPath, "textfile.txt");

        String rootPath = System.getProperty("user.home");
        System.out.println("rootPath = " + rootPath);
        String relativePath = "\\Downloads\\textfile.txt";
        String fullPath = rootPath + relativePath;
        boolean isExist = Files.exists(Paths.get(fullPath));

       // Assert.assertTrue(Files.exists(filePath), "textfile.txt indirilmedi");
        Assert.assertTrue(isExist, "textfile.txt indirilmedi");
    }

}
