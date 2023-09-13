package com.masterbranchacademy.tests.day_01.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetSize {
    public static void main(String[] args) throws InterruptedException {


//        Testcase 4
//        1. chrome driver i olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        2. driver.get ile https://www.selenium.dev/ sitesini acin
        driver.get("https://www.selenium.dev/");

//        3. sayfayi maximize yapin
        driver.manage().window().maximize();

        Thread.sleep(3000);
//        4. sayfanin pixel olarak olculerini yazdirin
        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

//        5. sayfanin pixel olarak konumunu yazdirin
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

//        6. ve chrome driver i kapatin
        driver.close();
    }
}
