package com.masterbranchacademy.tests.day_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePathTest {
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
    public void filePath(){

        //String filePath = "C:\\Users\\TANER\\Pictures\\p_gs.png";
        String rootPath = System.getProperty("user.home");
        String relativePath = "\\Pictures\\p_gs.png";
        String filePathDynamic = rootPath + relativePath;
        System.out.println("filePathDynamic = " + filePathDynamic);
        boolean isExist = Files.exists(Paths.get(filePathDynamic));
        System.out.println("isExist = " + isExist);
        Assert.assertTrue(isExist, "File not found");

    }

    @Test
    public void filePathInProject(){

        String filePath = "C:\\Users\\TANER\\IdeaProjects\\SeleniumTestNG2023Project\\src\\test\\resources\\data\\testFile.txt";
        String rootPath = System.getProperty("user.dir");
        String relativePath = "\\src\\test\\resources\\data\\testFile.txt";
        String filePathDynamic = rootPath + relativePath;
        System.out.println("filePathDynamic = " + filePathDynamic);
        boolean isExist = Files.exists(Paths.get(filePathDynamic));
        System.out.println("isExist = " + isExist);
        Assert.assertTrue(isExist, "File not found");

    }
}
