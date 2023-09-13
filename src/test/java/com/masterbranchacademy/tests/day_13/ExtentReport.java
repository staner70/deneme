package com.masterbranchacademy.tests.day_13;

import com.masterbranchacademy.pages.ToDoListPage;
import com.masterbranchacademy.utilities.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class ExtentReport extends BaseTest {
    ToDoListPage toDoListPage = new ToDoListPage();

    @Test
    public void extentReport() throws InterruptedException {
    //        1. 'http://webdriveruniversity.com/index.html' url e gidiniz
    //        2. title nin 'WebDriverUniversity.com' oldugunu dogrulayin

        extentLogger = reports.createTest("extendReport");

        extentLogger.info("Title dogrulayin");
        String actualTitle = toDoListPage.getTitleText();
        String expectedTitle = "My Courses & Promo Codes";
        Assert.assertEquals(actualTitle, expectedTitle, "Page not load");


        extentLogger.info("Kullanici mevcut pencerenin tanimlayicisini alir");
        String actualWindowHandle = driver.getWindowHandle();
        //        3. TO DO LIST elementine tiklayin
        //                (eger locator hatasi alirsaniz javascriptexecuter in scroll into methodunu kullanin )

        extentLogger.info("Kullanici todo list sayfasina gider");
        //toDoListPage.getElementTodoList().click();
        toDoListPage.clickTodoList();
        Thread.sleep(3000);


    //        4. yeni bir browser acilaktir. bunuda getWindowHandles methodu ile 2. browser a click veya gecis yapin
        extentLogger.info("Kullanici butun pencerelerin idlerini alir");
        Set<String> windowhandels = driver.getWindowHandles();
        //String actualWindowHandle = driver.getWindowHandle();
        System.out.println("windowhandels = " + windowhandels);

        extentLogger.info("Kullanici ikinci pencereyi acar");
        for (String windowhandel : windowhandels) {
            if (!windowhandel.equals(actualWindowHandle)) {
                driver.switchTo().window(windowhandel);
            }
        }
        
    //        5. ikinci browserin da title nin 'WebDriver | To Do List' oldugunu dogrulayin
        extentLogger.info("Kullanici todo list sayfasinin title ni alir");
        String actualTitleText = driver.getTitle();
        String expectedTitleText = "WebDriver | To Do List";

        extentLogger.info("Kullanici todo list titleni karsilastirir");
        Assert.assertEquals(actualTitleText, expectedTitleText, "Todo list title esit degildir");


    //        6. yeni bir 'Test otomasyon yapilmali' yapilacak is olarak ekleyin
        //Actions actions = new Actions(driver);
        String textToInput = "Test otomasyon yapilmali";
        //actions.sendKeys(toDoListPage.addNewTodo, textToInput, Keys.ENTER).perform();
        toDoListPage.sendNewTodo(textToInput);
        Thread.sleep(3000);

    //        7. ve bu yapilacak isler listesini bir List<String> e alip enson eklediginiz gorevin listede
    //        oldugunu dogrulayin.
        List<String> list = toDoListPage.getListText();

        Assert.assertTrue(list.contains(textToInput));


    //        Not: a. bu adimlarin herbirine extend report ekleyin
    //        b. locator lari da pages de bir class acip ona ekleyin
    }
}
