package com.masterbranchacademy.tests.day_01.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSource {
    public static void main(String[] args) {

//        Testcase 4a
//      1. chrome driver i olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//      2. driver.get ile https://www.selenium.dev/ sitesini acin
        driver.get("https://www.selenium.dev/");

//      3. a) sayfayi kaynak kodunu Stringe yazdirin
//      b) kaynak kodun "Getting Started" iceriyor ise test gecti yazdirin
//      c) icermiyor ise test basarisiz yazdirin

        String actualSource = driver.getPageSource();
        String expectedPhrase = "Getting Started";

        if (actualSource.contains(expectedPhrase)) {
            System.out.println("Test gecti");
        } else {
            System.out.println("Test basarisiz");
        }

//      4 ve chrome driver i kapatin
        driver.quit();

    }
}
