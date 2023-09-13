package com.masterbranchacademy.tests.day_09.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void actionTest() throws InterruptedException {

        //    3. Ana sayfanın başarıyla göründüğünü doğrulayın


        //    4. 'Double click me' dufmesine cift tiklayin
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();

        Thread.sleep(3000);

        //    5. ve o tusun tiklandigini dogrulayin
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        //Assert.assertTrue(doubleClickMessage.isDisplayed(), "Double click message not clicked"); // isDisplayed burada yeterli degil
        String actualdoubleClickMessage = doubleClickMessage.getText();
        String expectedoubleClickMessage = "You have done a double click";
        Assert.assertEquals(actualdoubleClickMessage, expectedoubleClickMessage, "Double click message not displayed");


        //    6. 'Right click me' dufmesine cift tiklayin
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

        //    7. ve o tusun tiklandigini dogrulayin
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));

        String actualrightClickMessage = rightClickMessage.getText();
        String expectedrightClickMessage = "You have done a right click";
        Assert.assertEquals(actualrightClickMessage, expectedrightClickMessage, "Right click message not displayed");

        //    8. 'Click me' dufmesine cift tiklayin
       WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
       actions.click(clickMeBtn).perform();

        //    9. ve o tusun tiklandigini dogrulayin
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));

        String actualdynamicClickMessage = dynamicClickMessage.getText();
        String expecteddynamicClickMessage = "You have done a dynamic click";
        Assert.assertEquals(actualdynamicClickMessage, expecteddynamicClickMessage, "dynamic click message not displayed");

    }


}
