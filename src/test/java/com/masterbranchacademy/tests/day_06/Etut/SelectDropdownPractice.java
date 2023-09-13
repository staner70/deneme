package com.masterbranchacademy.tests.day_06.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropdownPractice {
        //  dropdown select test
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //    1. Tarayıcıyı başlatın
        //System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriverManager.firefoxdriver().setup();
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();

        //    2. 'https://www.saucedemo.com/' URL'sine gidin
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){

        driver.quit();
    }

    @Test
    public void SelectDropdownTest() throws InterruptedException {

        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homePage = driver.findElement(By.className("login_logo"));
        Assert.assertEquals(homePage.getText(), "Swag Labs", "Home login page not loaded");

        //    4. kullanici adi ve password girerek siteye giris yapin
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(5000);

        //    5. dropdown elementini Select classina alin
        //WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        WebElement dropdown = driver.findElement(By.tagName("select"));

        Select select = new Select(driver.findElement(By.className("product_sort_container")));

        //    6. secili olan 'Name (A to Z)' oldugunu dogrulayin

        String selectedItem = select.getFirstSelectedOption().getText();
        String expectedItem = "Name (A to Z)";

        //Assert.assertEquals(select.getFirstSelectedOption().getText(), "Name (A to Z)", "Fist selected option is not 'Name (A to Z)'");
        Assert.assertEquals(selectedItem, expectedItem, "Fist selected option is not 'Name (A to Z)'");

        //    7. ve 'Price (high to low)' option ni secin
        select.selectByValue("hilo");
        //select.selectByVisibleText("Price (high to low)");
        dropdown = driver.findElement(By.className("product_sort_container"));
        Select select1 = new Select(dropdown);

        Thread.sleep(5000);
        //    8. Price (high to low) secili oldugunu dogrulayin

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Price (high to low)", "L'option sélectionnée n'est pas 'Price (high to low)'.");

    }



}
