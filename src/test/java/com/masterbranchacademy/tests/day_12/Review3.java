package com.masterbranchacademy.tests.day_12;

import com.github.javafaker.Faker;
import com.masterbranchacademy.pages.SauceDemoLoginPage;
import com.masterbranchacademy.pages.SaucedemoInventoryPage;
import com.masterbranchacademy.utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Review3 extends BaseTest {

    SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
    SaucedemoInventoryPage inventoryPage = new SaucedemoInventoryPage();
    @Test
    public void table(){
//        Testcase review
//        1. https://www.saucedemo.com/ url`e gidin
//        2. dogru kullanici adi ve sifre ile giris yapin
        loginPage.login();
//        3. siteye giris yaptiginizi dogrulayin
        String actualProductText = inventoryPage.getProductText();
        String expectedProductText = "Products";
        Assert.assertEquals(actualProductText, expectedProductText, "Page not load");
//        4. butun urunlerin textlerini 'List<String>' e atip yazdirin
        List<WebElement> allProduct = inventoryPage.getAllProductNameText();

        for (WebElement element : allProduct) {
            System.out.println("element.getText() = " + element.getText());
        }
        System.out.println("inventoryPage = " + inventoryPage.getAllProductText());

    }

    @Test
    public void facebook(){
        //"https://facebook.com"  Adresine gidin
        WebElement declineButton = driver.findElement(By.xpath("//button[text()='Decline optional cookies']"));
        declineButton.click();
        //“create new account”  butonuna basin
        WebElement createNewButton = driver.findElement(By.linkText("Create new account"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",createNewButton);
        // createNewButton.click();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        //“firstName” giris kutusuna bir isim yazin
        WebElement firstName = driver.findElement(By.name("firstname"));
        actions.click(firstName).sendKeys(faker.name().firstName(), Keys.TAB)
                //“surname” giris kutusuna bir soyisim yazin
                .sendKeys(faker.name().lastName(),Keys.TAB)
                //“email” giris kutusuna bir email yazin
                .sendKeys(email,Keys.TAB)
                //“email” onay kutusuna emaili tekrar yazin
                .sendKeys(email,Keys.TAB)
                //Bir sifre girin
                .sendKeys(faker.internet().password(),Keys.TAB)
                .sendKeys(Keys.TAB)
                //Tarih icin gun secin
                .sendKeys("12",Keys.TAB)
                //Tarih icin ay secin
                .sendKeys("Jan",Keys.TAB)
                //Tarih icin yil secin
                .sendKeys("1990",Keys.TAB)
                .sendKeys(Keys.TAB)
                //Cinsiyeti secin
                .sendKeys(Keys.ARROW_RIGHT,Keys.TAB).perform();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement femaleButton = driver.findElement(By.xpath("//*[text()='Female']/following-sibling::input"));
        WebElement maleButton = driver.findElement(By.xpath("//*[text()='Male']/following-sibling::input"));
        Assert.assertTrue(maleButton.isSelected(),"Male secilemedi");
        Assert.assertFalse(femaleButton.isSelected());
        WebElement submitButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submitButton.click();
    }

//    1. https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table url gidin
//            2. Medal table tablosuna gittiginizi dogrulayin
//      3. Germany nin gold 17 oldugunu dogrulayin
//      4. France in gold 10 oldugunu dogrulayin
}
