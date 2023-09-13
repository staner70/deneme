package com.masterbranchacademy.tests.day_09;

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

public class ActionsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        actions.pause(2000);
        actions.dragAndDrop(source, target).perform();
        actions.pause(3000);

        String expectedMessage = "You did great!";
        String actualMessage = target.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "kaynak hedefe ulasmadi");
    }

    @Test
    public void dragAndDropChain() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        actions.pause(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
        actions.pause(5000);

        String expectedMessage = "You did great!";
        String actualMessage = target.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "kaynak hedefe ulasmadi");
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement contextMenu = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        // contextClick() bize farenin sag tiklamamiza yardimci olur
        actions.contextClick(contextMenu).perform();
        Thread.sleep(5000);

        String actualMessage = driver.switchTo().alert().getText();
        String expectedMessage = "You selected a context menu";
        Assert.assertEquals(actualMessage, expectedMessage, "Message esit degildir");
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

    }
}
