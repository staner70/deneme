package com.masterbranchacademy.tests.day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), new ChromeOptions());

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.manage().window().maximize();

        // link textinin UI daki ayni ile kullanilir
        WebElement linkText = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));

        linkText.click();

        WebElement linkMessage = driver.findElement(By.tagName("h4"));
        System.out.println("linkMessage.getText() = " + linkMessage.getText());

        Thread.sleep(3000);

        driver.navigate().back();

        WebElement partialLinkText = driver.findElement(By.partialLinkText("Example 2"));

        Thread.sleep(3000);

        partialLinkText.click();

        Thread.sleep(3000);
        WebElement partialLinkMessage = driver.findElement(By.tagName("h4"));
        System.out.println("partialLinkMessage.getText() = " + partialLinkMessage.getText());
        driver.close();
    }
}
