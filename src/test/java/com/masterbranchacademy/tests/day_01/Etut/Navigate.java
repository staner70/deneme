package com.masterbranchacademy.tests.day_01.Etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {
    public static void main(String[] args) throws InterruptedException {


        // Testcase 3
        //1. chrome driver i olusturun*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       // 2. driver.get ile https://www.etsy.com/ sitesini acin
        driver.get("https://www.etsy.com/");

        Thread.sleep(3000);
        // 3. sonra https://www.selenium.dev/ sitesine gidin
        driver.navigate().to("https://www.selenium.dev/");

        Thread.sleep(3000);
       // 4. https://www.etsy.com/ sitesine geri donun
        driver.navigate().back();

        Thread.sleep(3000);
       // 5. https://www.selenium.dev/ sitesine tekrar acin
        driver.navigate().forward();

        Thread.sleep(3000);
       // 6. sayfayi yenileyin (refresh)
        driver.navigate().refresh();

        Thread.sleep(3000);
       // 7. sayfanin basligini alin ve yazdirin
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // 8. ve chrome driver i kapatin

        driver.quit();
    }
}
