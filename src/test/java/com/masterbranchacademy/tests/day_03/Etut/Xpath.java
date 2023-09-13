package com.masterbranchacademy.tests.day_03.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {


/*//Testcase 2
//  1. chrome driver i olusturun
        //System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//  2. driver.get ile https://amazon.com/ sitesini acin
        driver.get("https://amazon.com/ ");

//  3. searchbox elementine By.xpath metodu ile  web element olusturun
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

//  4. ve bu elemente sendKey() metodu ile "Man Hats" yazdirin
        searchBox.sendKeys("Man Hats");

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

//  5. ve 3 saniye bekleme ekleyin
        Thread.sleep(3000);

//  6. cikan neticeyi bir string e alin
//     a. netice (result) de "Man Hats" kelimesinin gectigini dogrulayin
//     b. eger geciyor ise consola "Test Gecti" yazdirin
//     c. gecmiyor ise consola "Test Basarisiz" yazdirin

        String expectedText = "Man Hats";
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualText = result.getText();
        System.out.println("actualText = " + actualText);

        if (actualText.contains(expectedText)) {
            System.out.println("TEST gecti");
        } else {
            System.out.println("TEST gecmedi");
        }

//  7. ve chrome driver i kapatin
        driver.close();
//  ve bunu xpath in diger metodlari ile de yapin*/

        //Testcase 3
//  1. chrome driver i olusturun
        //System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//  2. driver.get ile https://amazon.com/ sitesini acin
        driver.get("https://amazon.com/ ");

//  3. searchbox elementine By.xpath metodu ile  web element olusturun
        //button[contains(@id, forgot_password)]

        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id,'box')]"));

//  4. ve bu elemente sendKey() metodu ile "Man Hats" yazdirin
        searchBox.sendKeys("Man Hats");

        WebElement searchButton = driver.findElement(By.xpath("//input[contains(@id,'nav-search')]"));
        searchButton.click();

//  5. ve 3 saniye bekleme ekleyin
        Thread.sleep(3000);

//  6. cikan neticeyi bir string e alin
//     a. netice (result) de "Man Hats" kelimesinin gectigini dogrulayin
//     b. eger geciyor ise consola "Test Gecti" yazdirin
//     c. gecmiyor ise consola "Test Basarisiz" yazdirin
        //a[text()='Elemental Selenium']
        String expectedText = "Man Hats";
        //WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        WebElement result = driver.findElement(By.xpath("//span[text()='\"Man Hats\"']"));

        String actualText = result.getText();
        System.out.println("actualText = " + actualText);

        if (actualText.contains(expectedText)) {
            System.out.println("TEST gecti");
        } else {
            System.out.println("TEST gecmedi");
        }

//  7. ve chrome driver i kapatin
        driver.close();
//  ve bunu xpath in diger metodlari ile de yapin
    }
}
