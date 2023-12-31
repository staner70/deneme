package com.masterbranchacademy.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private Driver() {
    }

    public static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver(String browser) {

        if (driverPool.get() == null) {

            browser = browser == null ? ConfigReader.getProperties("browser") : browser;
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
                case "remote_chrome":
                    ChromeOptions chromeOptions =new ChromeOptions();
                    chromeOptions.setCapability("platfrom", Platform.ANY);
                    try {
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
            }
        }
        return driverPool.get();
    }

    public static WebDriver getDriver(){
        return getDriver(null);
    }

    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}

    /*public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperties("browser");
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                    break;
                case "firefox":
                    //System.setProperty("webdriver.gecko.driver", "chemin/vers/geckodriver");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver((new FirefoxOptions().setHeadless(true)));
                    driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    // SafariDriver supporte seulement les tests sur le système local
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Type de navigateur non supporté: " + browser);
            }


        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }*/



