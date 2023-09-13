package com.masterbranchacademy.tests.day_07.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests {
        //  Alert test
        //    1. Tarayıcıyı başlatın
        //    2. 'https://demo.automationtesting.in/Alerts.html' URL'sine gidin

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void alertTest1() throws InterruptedException {
        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Alerts";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page not load");

        //    4. 'Alert with Ok' dugmesine tikyain
        WebElement okTabBtn = driver.findElement(By.xpath("//a[@href='#OKTab']"));
        okTabBtn.click();

        //    5. 1 saniye bekleme ekleyin
        Thread.sleep(1000);

        //    6. 'click the button to display an  alert box: ' dugmesine tikyain
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

        Thread.sleep(3000);

        //    7. alertin textinin 'I am an alert box!' oldugunu dogrulayin
        //System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am an alert box!";
        Assert.assertEquals(actualAlertText, expectedAlertText, "Message is not 'I am an alert box!' in the box");

        //    8. alert i ok ye tiklayin
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    }

    @Test
    public void alertTest2() throws InterruptedException {
        //        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Alerts";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page not load");

        //        4. 'Alert with OK & Cancel ' dugmesine tikyain
        WebElement cancelTabBtn = driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        cancelTabBtn.click();

        //        5. 1 saniye bekleme ekleyin
        Thread.sleep(1000);

        //        6. 'click the button to display a confirm box' dugmesine tikyain
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);

        //        7. alertin textinin 'Press a Button !' oldugunu dogrulayin
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedText = "Press a Button !";
        Assert.assertEquals(actualAlertText,expectedText, "The message of alert is not 'Press a Button !'");

        //        8. alert i cancel a basin
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

    }

    @Test
    public void alertTest3() throws InterruptedException {
        //        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Alerts";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page not load");

        //        4. 'Alert with Textbox ' dugmesine tikyain
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();

        //        5. 1 saniye bekleme ekleyin
        Thread.sleep(1000);

        //        6. 'click the button to demonstrate the prompt box ' dugmesine tikyain
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(2000);

        //        7. alert a 'Master Branch Academy' yazdirin
        driver.switchTo().alert().sendKeys("Master Branch Academy");
        Thread.sleep(2000);

        //        8. alertin Ok tusuna basin
        driver.switchTo().alert().accept();

        //        9. 'Hello Master Branch Academy How are you today' mesajinin belidigini dogrulayin
        String actualAlertMessage = driver.findElement(By.id("demo1")).getText();
        String expectedAlertMessage = "Hello Master Branch Academy How are you today";
        Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "The message 'Hello Master Branch Academy How are you today' not equals");
    }


}
