package com.masterbranchacademy.tests.day_03.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Name {
    public static void main(String[] args) throws InterruptedException {

//
//Testcase 1
// 1. chrome driver i olusturun
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

// 2. driver.get ile https://the-internet.herokuapp.com/upload sitesini acin
        driver.get("https://the-internet.herokuapp.com/upload");

// 3. Choose file elementine By.name metodu ile  web element olusturun
        WebElement nameElement = driver.findElement(By.name("file"));
        System.out.println("name.getText() = " + nameElement.getText());

// 4. ve bu elemente tilayin
        nameElement.click();

// 5. ve 3 saniye bekleme ekleyin
        Thread.sleep(3000);

// 6. ve chrome driver i kapatin
        driver.close();

    }
}
