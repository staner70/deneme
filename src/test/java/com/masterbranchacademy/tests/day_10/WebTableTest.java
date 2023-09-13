package com.masterbranchacademy.tests.day_10;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void butunTabloyuYazdirma(){

        WebElement table = driver.findElement(By.id("table1"));

        String tableText = table.getText();
        System.out.println( table.getText());
        Assert.assertTrue(tableText.contains("jsmith@gmail.com"), "jsmith@gmail.com is not found in table");
    }

    @Test
    public void tableHeaders(){
        WebElement tableHeaders = driver.findElement(By.xpath("//table[@id='table1']/thead"));
        System.out.println("tableHeaders.getText() = " + tableHeaders.getText());

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());
        }
    }

    @Test
    public void tableLengths(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("rows.size() = " + rows.size());

        List<WebElement> rowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rowsWithoutHeaders.size() = " + rowsWithoutHeaders.size());
    }

    @Test
    public void printRows(){
        WebElement firstRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println("firstRow.getText() = " + firstRow.getText());

        List<WebElement> rowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("rowsWithoutHeaders.size() = " + rowsWithoutHeaders.size());
        for (WebElement rowsWithoutHeader : rowsWithoutHeaders) {
            System.out.println("rowsWithoutHeader.getText() = " + rowsWithoutHeader.getText());
        }

        for (int i = 1; i <= rowsWithoutHeaders.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println("row " + i + "  = " + row.getText());

        }
    }

    @Test
    public void dataInRow(){
        List<WebElement> dataInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        System.out.println("dataInRow.size() = " + dataInRow.size());
        for (WebElement element : dataInRow) {
            System.out.println(element.getText());
        }
    }
    
    @Test
    public void oneDataInRow(){
        WebElement onData = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("onData.getText() = " + onData.getText());
    }

    @Test
    public void allDataWithIndex(){
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        int lengthOfRow = rows.size();
        int lengthOfColumn = columns.size();

        for (int i = 1; i <= lengthOfRow; i++) {
            for (int j = 1; j <= lengthOfColumn; j++) {

                WebElement onData = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i +"]/td["+ j +"]"));
                System.out.println( "row " + i + " column " + j + " = " + onData.getText());

            }
            System.out.println("-------------------------------------------------");
        }
    }

    @Test
    public void getDataByName(){
        String name = "Frank";
        WebElement webSite = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+ name +"']/../td[5]"));
        System.out.println("webSite.getText() = " + webSite.getText());
    }

    @Test
    public void getAllDataByName(){
        String name = "Frank";
        List<WebElement> data = driver.findElements(By.xpath("//table[@id='table1']//td[.='"+ name +"']/../td"));

        //for (WebElement element : data) { System.out.println("element.getText() = " + element.getText()); }
        data.forEach(e -> System.out.println(e.getText()));
    }
}
