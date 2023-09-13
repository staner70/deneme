package com.masterbranchacademy.tests.day_02;

import java.net.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.openqa.selenium.remote.*;

public class Test {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), new ChromeOptions());

        driver.get("http://www.amazon.com");

        Thread.sleep(5000);
        driver.quit();

    }

}

