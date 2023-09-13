package com.masterbranchacademy.tests.day_11.Etut;

import com.masterbranchacademy.utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertiesPractice extends BaseTest {
        //    Test Senaryosu 7: Test Senaryolarını Doğrulama Sayfası
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin


    @Test
    public void propertiesTest(){
        // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement contactUs = driver.findElement(By.linkText("Contact us"));
        Assert.assertTrue(contactUs.isDisplayed(), "Page not load");
        // 4. 'Contact us' düğmesine tıklayın
        contactUs.click();
        // 5. Kullanıcının Contact us sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement contactUsPage = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(contactUsPage.isDisplayed(), "Page not load");



/*        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Automation Exercise"), "Page not load");

        //4. 'Contact us' düğmesine tıklayın
        WebElement contactUs = driver.findElement(By.xpath("//li/a[text()=' Contact us']"));
        contactUs.click();
        //5. Kullanıcının Contact us sayfasına başarıyla yönlendirildiğini doğrulayın
       String expectedText = " CONTACT US";
        Assert.assertEquals(contactUsPage, expectedText, "Page not load");*/

    }

    //    1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin


    @Test
    public void productTest() throws InterruptedException {
        //  3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement contactUs = driver.findElement(By.linkText("Contact us"));
        Assert.assertTrue(contactUs.isDisplayed(), "Page not load");

        //4. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        WebElement firstProduct = driver.findElement(By.xpath("//li/a[@href='/product_details/1']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", firstProduct);
        firstProduct.click();



        //5. Kullanıcı ürün detay sayfasına yönlendirildi
        Thread.sleep(5000);
        WebElement productName = driver.findElement(By.xpath("(//h2)[3]"));
        WebElement category = driver.findElement(By.xpath("//div[@class='product-information']/p[1]"));
        WebElement availability = driver.findElement(By.xpath("//div[@class='product-information']/p[2]"));
        WebElement condition = driver.findElement(By.xpath("//div[@class='product-information']/p[3]"));
        WebElement brand = driver.findElement(By.xpath("//div[@class='product-information']/p[4]"));
        WebElement price = driver.findElement(By.xpath("//div[@class='product-information']/span/span"));
        String expectedProductName = "Blue Top";
        String expectedCategory = "Category: Women > Tops";
        String expectedAvailability = "Availability: In Stock";
        String expectedCondition = "Condition: New";
        String expectedBrand = "Brand: Polo";
        String expectedPrice = "Rs. 500";
        Assert.assertEquals(productName.getText(),expectedProductName,"Product Name esit degildir");
        Assert.assertEquals(category.getText(),expectedCategory,"Category esit degil");
        Assert.assertEquals(availability.getText(),expectedAvailability,"urun uygun degil");
        Assert.assertEquals(condition.getText(),expectedCondition,"Conditio uyusmuyor");
        Assert.assertEquals(brand.getText(),expectedBrand,"Brand esit degildir.");
        Assert.assertEquals(price.getText(),expectedPrice,"Price esit degil");


        //6. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.

    }















}
