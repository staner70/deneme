package com.masterbranchacademy.tests.day_01.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetUrl {
    public static void main(String[] args) {


        // Testcase 2
        // 1. chrome driver i olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 2. driver.get ile https://demoqa.com/ sitesini acin
        driver.get("https://demoqa.com/");

        // 3. a) sayfanin url`ini bir String e alin
        // b) url`in "demoqa" iceriyor ise test gecti yazdirin
        // c) icermiyor ise test basarisiz yazdirin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "demoqa";

        if (actualUrl.contains(expectedUrlWord)) {
            System.out.println("Testi geçti");
        } else {
            System.out.println("Test basarisiz");
        }

        // 4. ve chrome driver i kapatin

        driver.close();
    }
}
