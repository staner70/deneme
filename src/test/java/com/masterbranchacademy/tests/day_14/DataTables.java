package com.masterbranchacademy.tests.day_14;

import com.github.javafaker.Faker;
import com.masterbranchacademy.utilities.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataTables extends BaseTest {
    Faker faker = new Faker();
    @Test
    public void tableInputDataTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement newBtn = driver.findElement(By.xpath("(//button)[1]"));
        newBtn.click();
        WebElement firstName = driver.findElement(By.id("DTE_Field_first_name"));
        WebElement create = driver.findElement(By.xpath("//button[@class='btn']"));
        actions.sendKeys(firstName,faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB)
                .sendKeys(faker.company().profession(), Keys.TAB)
                .sendKeys(faker.company().bs(), Keys.TAB)
                .sendKeys("123", Keys.TAB)
                .sendKeys("2010-09-12", Keys.TAB)
                .sendKeys("65000", Keys.TAB).click(create).perform();


        Thread.sleep(3000);


    }

    @Test
    public void tableInputDataFromExcelTest() throws IOException, InterruptedException {

        String root = System.getProperty("user.dir");
        String relativepath = "\\src\\test\\resources\\data\\exceldata.xlsx";

        String path = root + relativepath;

        // dosyayi acar
        FileInputStream fileInputStream = new FileInputStream(path);

        // excel dosyasini acar fileinputstream in yardimiyla
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // ilk sayfayi acar
        Sheet sheet = workbook.getSheetAt(0);

        // sayfa içindeki satirlari indexine gore almamiza yardimci olur


        // indexine gore hucredeki veriyi getirir

        String firstName = sheet.getRow(1).getCell(0).toString();
        String lastName = sheet.getRow(1).getCell(1).toString();
        String position = sheet.getRow(1).getCell(2).toString();
        String office = sheet.getRow(1).getCell(3).toString();
        String extension = sheet.getRow(1).getCell(4).toString();
        String startDate = sheet.getRow(1).getCell(5).toString();
        String salary = sheet.getRow(1).getCell(6).toString();
        System.out.println(startDate);

        Actions actions = new Actions(driver);
        WebElement newBtn = driver.findElement(By.xpath("(//button)[1]"));
        newBtn.click();
        WebElement firstNameElement = driver.findElement(By.id("DTE_Field_first_name"));
        WebElement create = driver.findElement(By.xpath("//button[@class='btn']"));
        actions.sendKeys(firstNameElement,firstName, Keys.TAB)
                .sendKeys(lastName, Keys.TAB)
                .sendKeys(position, Keys.TAB)
                .sendKeys(office, Keys.TAB).pause(2000)
                .sendKeys(extension, Keys.TAB)
                .sendKeys("2010-09-12", Keys.TAB)
                .sendKeys("65000", Keys.TAB).click(create).perform();


        Thread.sleep(3000);
        fileInputStream.close();
        workbook.close();
    }

    @Test
    public void inputTest() throws IOException, InterruptedException {
        String root = System.getProperty("user.dir");
        String relativepath = "\\src\\test\\resources\\data\\exceldata.xlsx";

        String path = root + relativepath;

        // dosyayi acar
        FileInputStream fileInputStream = new FileInputStream(path);

        // excel dosyasini acar fileinputstream in yardimiyla
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // ilk sayfayi acar
        Sheet sheet = workbook.getSheetAt(0);

        int satirAdedi = sheet.getLastRowNum();
        System.out.println("satirAdedi = " + satirAdedi);
        Map<String, String> officeTables = new HashMap<>();

        for (int i = 0; i <= satirAdedi; i++) {
            String titre = sheet.getRow(0).getCell(i).toString();
            //System.out.println("ulke = " + ulke);
            String value = sheet.getRow(1).getCell(i).toString();
            //System.out.println("capital = " + capital);
            officeTables.put(titre, value);

        }
        System.out.println("officeTables = " + officeTables);

        for (String value : officeTables.values()) {
            System.out.println("value = " + value);
        }

        Actions actions = new Actions(driver);
        WebElement newBtn = driver.findElement(By.xpath("(//button)[1]"));
        newBtn.click();
        WebElement firstNameElement = driver.findElement(By.id("DTE_Field_first_name"));
        WebElement create = driver.findElement(By.xpath("//button[@class='btn']"));



        actions.sendKeys(firstNameElement, officeTables.get("firstname"), Keys.TAB)
                .sendKeys(officeTables.get("lastname"), Keys.TAB)
                .sendKeys(officeTables.get("position"), Keys.TAB)
                .sendKeys(officeTables.get("office"), Keys.TAB)
                .sendKeys(officeTables.get("extension"), Keys.TAB,Keys.TAB)
                .sendKeys(officeTables.get("startdate"), Keys.TAB)
                .sendKeys(officeTables.get("salary"), Keys.TAB).perform();

        Thread.sleep(3000);
    }
}
