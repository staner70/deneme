package com.masterbranchacademy.tests.day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Manage {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // get() metodu sitenin acilmasina yardimci olur
        driver.get("https://www.amazon.com");

        // Sayfayi maximize yapar
        driver.manage().window().maximize();

        Thread.sleep(3000);

        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        Thread.sleep(3000);
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());


        driver.manage().window().setPosition(new Point(255,15));
        driver.manage().window().setSize(new Dimension(900,600));

        Thread.sleep(3000);
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        driver.manage().window().minimize();

        Thread.sleep(3000);
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        driver.close();
    }
}
