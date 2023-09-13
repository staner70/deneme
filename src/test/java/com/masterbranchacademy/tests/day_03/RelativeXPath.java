package com.masterbranchacademy.tests.day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RelativeXPath {
    public static void main(String[] args) throws InterruptedException {

/*        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");*/

        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        //WebElement userName = driver.findElement(By.xpath("//div/input"));
        //WebElement userName = driver.findElement(By.xpath("//*[@class='subheader']/following::input"));
        //WebElement userName = driver.findElement(By.xpath("//form[@name='login']//following-sibling::input"));
        WebElement userName = driver.findElement(By.xpath("(//div/input)[1]"));

        // (//div/input)[2] bazi durumlarda parantezsiz de locate edilebilir.

        userName.sendKeys("Xpath");

        Thread.sleep(3000);

        //WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        //WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@*='password']"));
        //WebElement password = driver.findElement(By.xpath("//*[@*='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@type='password'and@name='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@type='password'and@name='password']"));
        //WebElement password = driver.findElement(By.xpath("//input[@type='password'or@name='password']"));
        //WebElement password = driver.findElement(By.xpath("//*[contains(@id,'wo')]"));
        WebElement password = driver.findElement(By.xpath("//*[starts-with(@id, 'pass')]"));

        System.out.println(driver.findElement(By.xpath("//*[text()='Login Page']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'This is where you')]")).getText());



        password.sendKeys("testpassword");

        WebElement button = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']/.."));
        button.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
