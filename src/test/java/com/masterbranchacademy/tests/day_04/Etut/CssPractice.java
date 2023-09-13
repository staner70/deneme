package com.masterbranchacademy.tests.day_04.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssPractice {
    public static void main(String[] args) throws InterruptedException {

//    1. Bolum
//1. Tarayıcıyı başlatın
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//2. 'https://www.saucedemo.com/' URL'sine gidin
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        //WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

//3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement title = driver.findElement(By.cssSelector(".title"));
        String actualTitle = title.getText();
        String expectedTitle = "Products";
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test Basarili");
        }else {
            System.out.println("Test Basarisiz");
        }

        Thread.sleep(3000);

//        2. Bolum
//        4. a. Birinci urunun fiyatini string e alin
        WebElement elementPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        String price = elementPrice.getText();
        System.out.println("price = " + price);

//        b. Birinci urunun adini string e alin
        WebElement elementName = driver.findElement(By.cssSelector("a#item_4_title_link div"));

        String name = elementName.getText();
        System.out.println("name = " + name);

//        5. Birinci urunu sepete ekleyin
        WebElement addToCharButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addToCharButton.click();

//        3. Bolum
//        6. Urun sepet sayfasina gidin
        WebElement charButton = driver.findElement(By.cssSelector("#shopping_cart_container"));
        charButton.click();

//        7. Sepetteki urunun adini ve fiyatinin ayni oldugunu dogrulayin

        WebElement chartItemName = driver.findElement(By.cssSelector("#item_4_title_link > div"));
        String chartItemNameText = chartItemName.getText();
        System.out.println("chartItemNameText = " + chartItemNameText);

        WebElement charItemPrice = driver.findElement(By.cssSelector(".inventory_item_price"));
        String charItemPriceText = charItemPrice.getText();
        System.out.println("charItemPriceText = " + charItemPriceText);

        if (charItemPriceText.equals(price) && chartItemNameText.equals(name)) {
            System.out.println("Test basarili");
        } else {
            System.out.println("Test basarili degil");
        }

//        8. Checkout tusuna basin
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();

        Thread.sleep(3000);

//        4. Bolum
//        9. Adini, Soyadini ve Posta kodunu yazin
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("Volta");

        WebElement zipCode = driver.findElement(By.cssSelector("#postal-code"));
        zipCode.sendKeys("67000");

        Thread.sleep(3000);

//        10. Continue tusunua basin
        WebElement buttonContinue = driver.findElement(By.cssSelector("#continue"));
        buttonContinue.click();

//        11. Finish tusuna basara alisverisi tamamlayin
        WebElement btnFinish = driver.findElement(By.cssSelector("#finish"));
        btnFinish.click();

//        12. 'Thank you for your order!' mesajin gorundugunu dogrulayin
        Thread.sleep(3000);

        WebElement textMessage = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        String actualTextMessage = textMessage.getText();
        String expectedMessage = "Thank you for your order!";

        if (expectedMessage.equals(actualTextMessage)) {
            System.out.println("TEST PASS");
        } else {
            System.out.println("TEST FAIL");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
