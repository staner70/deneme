package com.masterbranchacademy.tests.day_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListeElement {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }

    @Test
    public void elementListTest() throws InterruptedException {

        WebElement dropDown = driver.findElement(By.cssSelector("#navbarDropdown"));
        dropDown.click();

        List<WebElement> dropDownMenu = driver.findElements(By.cssSelector(".dropdown-menu.show a"));

        System.out.println("dropDownMenu.size() = " + dropDownMenu.size());

        for (WebElement downMenu : dropDownMenu) {
            System.out.println("dropMenu.getText() = " + downMenu.getText());
        }

        dropDownMenu.get(3).click();
        Thread.sleep(3000);

    }
}
