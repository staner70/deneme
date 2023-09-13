package com.masterbranchacademy.tests.day_07.Etut;

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

public class DownloadTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
/*        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/

        driver.get("https://testpages.herokuapp.com/styled/download/download.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void downloadTest() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTest = "Download File Via JavaScript";
        Assert.assertEquals(actualTitle,expectedTest, "Page not load");

        //    4. 'Direct Link Download' tusuna tiklayin
        WebElement directLinkBtn = driver.findElement(By.id("direct-download"));
        directLinkBtn.click();
        Thread.sleep(3000);

        //    5. 'textfile.txt' dosyasini indigini dogrulayin
        String downloadPath = "C:\\Users\\TANER\\Downloads"; // İndirme klasörünüzün yolunu buraya ekleyin.
        Path filePath = Paths.get(downloadPath, "textfile.txt");
        Assert.assertTrue(Files.exists(filePath), "textfile.txt indirilmedi");
    }


}
