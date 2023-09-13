package com.masterbranchacademy.tests.day_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }

    @Test
    public void getOptionsTest(){
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(element);
        List<WebElement> listOptions =  select.getOptions();
        System.out.println("listOptions.size() = " + listOptions.size());
        for (WebElement listOption : listOptions) {
            System.out.println("listOption.getText() = " + listOption.getText());
        }
    }

    @Test
    public void selectByIndex() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(element);

        select.selectByIndex(1);
        Thread.sleep(3000);
    }

    @Test
    public void getFirstSelectedOption() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(element);

        select.selectByIndex(1);
        Thread.sleep(3000);

        String expectedOption = "Option 1";
        String selectedOption = select.getFirstSelectedOption().getText();

        System.out.println("selectedOption = " + selectedOption);
        Assert.assertEquals(expectedOption, selectedOption, "option esit degil");
    }

    @Test
    public void selectByValueTest() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(element);

        select.selectByValue("1");
        Thread.sleep(3000);

        select.selectByValue("2");
        Thread.sleep(3000);
    }

    @Test
    public void selectByVisibleTextTest() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(element);

        select.selectByVisibleText("Option 1");
        Thread.sleep(3000);

        select.selectByVisibleText("Option 2");
        Thread.sleep(3000);
    }
}
