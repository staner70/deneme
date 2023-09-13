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

public class DragAndDrop {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void dragAndDrop(){

        //            3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement pageLoad = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(pageLoad.isDisplayed(), "Page not load");


        //            4. birinci ve ikinci Drag me elementlerini tasiyin


        WebElement source1 = driver.findElement(By.id("draggable1"));
        WebElement source2 = driver.findElement(By.id("draggable2"));

        WebElement target1 = driver.findElement(By.id("droppable1"));
        WebElement target2 = driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source1, target1).perform();
        actions.dragAndDrop(source2, target2).perform();

        System.out.println("target1.getText() = " + target1.getText());


        //            5. ve onlarin tasindigini dogrulayin
        String actualMessage1 = target1.getText();
        String actualMessage2 = target2.getText();
        String expectedMessage = "Dropped!";


        Assert.assertEquals(actualMessage1, expectedMessage, "Dropped olmadi");
        Assert.assertEquals(actualMessage2, expectedMessage, "Dropped olmadi");


    }

}
