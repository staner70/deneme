package com.masterbranchacademy.tests.day_02.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdLocator {
    public static void main(String[] args) throws InterruptedException {

//        Testcase 2
//  1. chrome driver i olusturun
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



//  2. driver.get ile https://amazon.com/ sitesini acin
        driver.get("https://amazon.com");

//  3. All elementine By.id metodu ile  web element olusturun
//   a. elementin textini bir stringe alin
//   b. ve o textin "All" oldugunu dogrulayin
        WebElement element = driver.findElement(By.className("hm-icon-label"));
        String actualText = element.getText();
        System.out.println("actualText = " + actualText);
        String expectedText = "All";


        if (expectedText.equals(actualText)) {
            System.out.println("TEST GECTI");
        } else {
            System.out.println("TEST GECMEDI");
        }

//  4. ve bu elemente tilayin
        element.click();

//  5. ve 3 saniye bekleme ekleyin
        Thread.sleep(3000);

//  6. ve chrome driver i kapatin
        driver.close();

    }
}
