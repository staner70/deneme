package com.masterbranchacademy.tests.day_01.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {
    public static void main(String[] args) {



        // Testcase 1
        // 1. chrome driver i olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 2. driver.get ile https://demoqa.com/ sitesini acin
        driver.get("https://demoqa.com/");

        // 3. a) sayfanin basligini (title) bir String e alin
        // b) title (basliginin) "DEMOQA" ise test gecti yazdirin
        // c) degilse test basarisiz yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        String expectedTitle = "DEMOQA";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title testi gecti");
        } else {
            System.out.println("Title testi gecemedi");
        }

        // 4. ve chrome driver i kapatin
        driver.close();
    }
}
