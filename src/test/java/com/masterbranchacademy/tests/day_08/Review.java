package com.masterbranchacademy.tests.day_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Review {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //        1. bolum
        // 1. Tarayıcıyı başlatın
        //    2. 'https://omayo.blogspot.com/' URL'sine gidin

        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void review(){
        //     3. Ana sayfanın başarıyla göründüğünü isDisplayed() metodu ile doğrulayın
        WebElement dismiss = driver.findElement(By.id("cookieChoiceDismiss"));
        dismiss.click();

        WebElement radio1Btn = driver.findElement(By.id("radio1"));
        Assert.assertTrue(radio1Btn.isDisplayed(), "Page Home not displayed");

        //    4. title ve urlin omayo icerdigini dogrulayin
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        Assert.assertTrue(title.contains("omayo"));
        Assert.assertTrue(url.contains("omayo"));

        //    5. Radio options dan Male secin ve isSelected() ile seili oldugunu dogrulayin
        Assert.assertFalse(radio1Btn.isSelected(), "Male selected");
        radio1Btn.click();
        Assert.assertTrue(radio1Btn.isSelected(), "Male not selected");

        //     2. bolum
        //    6. Checkbox blue a tiklayin ve isSelected() ile seili oldugunu dogrulayin
        driver.findElement(By.id("checkbox2")).click();
        Assert.assertTrue(driver.findElement(By.id("checkbox2")).isSelected(), "Blue checkbox is not selected");

        //    7. Button 1 inaktif (disabled) ve Button 2 aktif (enabled) oldugunu dogrulayin
        Assert.assertFalse(driver.findElement(By.id("but1")).isEnabled(), "Button 1  is enable");
        Assert.assertTrue(driver.findElement(By.id("but2")).isEnabled(), "Button 2  is not enable");



        //     3. bolum
        //    8. Acilir pencerenin secili olanin 'Older Newsletters' oldugunu dogrulayin
        WebElement combobox = driver.findElement(By.className("combobox"));
        Select select = new Select(combobox);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Older Newsletters", "Selected option is not 'Older Newsletters'");

        //    9. sonra 'doc 3' secin ve secilmis oldugunu dogrulayin
        select.selectByValue("jkl");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "doc 3", "doc 3 is not selected");

        //    10. iframe2 icindeki 'Error: Server Error' yazisini yazdirin
        //driver.switchTo().frame("iframe2");
        //System.out.println(driver.findElement(By.tagName("h1")).getText());


        //     4. bolum
        //    11. ClickToGetAlert button nina tiklayin alertin textini 'Hello' oldugunu dogrulayin
        driver.findElement(By.id("alert1")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello");
        driver.switchTo().alert().accept();

        //    12. Dorpdown button nina tiklayin ve facebook textini yazdirin
        driver.findElement(By.className("dropbtn")).click();

        WebElement facebookText = driver.findElement(By.xpath("//div[@id='myDropdown']/a[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(facebookText));
        System.out.println(facebookText.getText());
        //    Not: burada explicit wait kullanmalisiniz
    }


}
