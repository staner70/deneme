package com.masterbranchacademy.tests.day_13;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportTest {

    // raporun baslamisini ve insa edilmesini saglar
    ExtentReports reports;

    // raporu html olarak olusturmaya yardimci olur
    ExtentSparkReporter sparkReporter;

    // her bir adim için info (message) yazmamiza yardimci olur
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUP(){
        reports = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        sparkReporter = new ExtentSparkReporter(path);

        reports.attachReporter(sparkReporter);

        sparkReporter.config().setReportName("Extent Report Test");
        //TODO ileride update gerekli
        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Browser", "chrome");
        reports.setSystemInfo("Tester", "Master Branch Academy");
    }

    @Test
    public void reportTest(){
        extentLogger = reports.createTest("report Test");

        // her bir adim için mesaj yazilir
        extentLogger.info("Chromu ac");

        extentLogger.info("siteye git");

        extentLogger.info("Kullanici adini ve passwordu girin");

        extentLogger.info("Giris yaptiginiza dair dogrulama yapin");

        extentLogger.info("Test geçti");
    }
    @Test
    public void reportTest2(){
        extentLogger = reports.createTest("report Test ikinci");

        // her bir adim için mesaj yazilir
        extentLogger.info("Chromu ac");

        extentLogger.info("siteye git");

        extentLogger.info("Kullanici adini ve passwordu girin");

        extentLogger.info("Giris yaptiginiza dair dogrulama yapin");

        extentLogger.info("Test geçti");
    }

    @AfterMethod
    public void kapat(){
        //rapor olusturduktan sonra kapatir
        reports.flush();
    }

}
