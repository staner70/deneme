package com.masterbranchacademy.tests.day_11;

import com.masterbranchacademy.utilities.BaseTest;
import com.masterbranchacademy.utilities.ConfigReader;
import com.masterbranchacademy.utilities.Driver;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PropertiesTest extends BaseTest {
    
    @Test
    public void test1(){
        String url = ConfigReader.getProperties("url");
        System.out.println("url = " + url);
        
        String brow = ConfigReader.getProperties("browser");
        System.out.println("brow = " + brow);
    }

    @Ignore
    @Test
    public void driverTest() throws InterruptedException {

        driver.get(ConfigReader.getProperties("url"));
        Thread.sleep(3000);

       // Driver.closeDriver();
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get(ConfigReader.getProperties("url"));
        Thread.sleep(3000);

        //Driver.closeDriver();
    }
}
