package com.masterbranchacademy.tests.day_10.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TablesTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://editor.datatables.net");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void tableString(){
                /*  Testcase 1
          1. tarayiciyi acin
          2. https://editor.datatables.net/ siteye gidin
          3. butun tabloyu bir String e atin
          4. Brenden Wagner adli kisinin tabloda var olup olmadigini dogrulayin
        */
        WebElement table = driver.findElement(By.tagName("table"));
        String tableToString = table.getText();
        System.out.println("tableToString = " + tableToString);

        Assert.assertTrue(tableToString.contains("Brenden Wagner"));
    }
    @Test
    public void tableList() throws InterruptedException {
//   3. butun isimleri bir List e atin
        Thread.sleep(2000);
        int num = 1;
        List<WebElement> webElementList = driver.findElements(By.xpath("//table/tbody/tr"));
        List<WebElement> butunHucreler = driver.findElements(By.xpath("//table/tbody/tr/td"));
        List<WebElement> brunoNashHucreleri = driver.findElements(By.xpath("//table/tbody/tr[7]/td"));
        List<String> list = new ArrayList<>();
        list.add("appple");
        list.add("samsung");
        list.add("omio");
        // System.out.println("list.get(2) = " + list.get(2));

        String[] array ={"str","bcr"};
        // System.out.println("array[1] = " + array[1]);

        //  System.out.println("brunoNashHucreleri.get(1).getText() = " + brunoNashHucreleri.get(1).getText());
//        for (WebElement satir : webElementList) {
//            System.out.println(num + " satir = " + satir.getText());
//            num++;
//        }
//        for (WebElement hucre : butunHucreler) {
//            System.out.println("hucre.getText() = " + hucre.getText());
//        }
//        for (WebElement element : brunoNashHucreleri) {
//            System.out.println("element.getText() = " + element.getText());
//        }
        WebElement brendenWagler = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("brendenWagler.getText() = " + brendenWagler.getText());
        List<WebElement> isimler = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        List<String> isimlerText = new ArrayList<>();
        for (WebElement isim : isimler) {
            isimlerText.add(isim.getText());
        }
        System.out.println("isimlerText = " + isimlerText);
//   4. listi yazdirin
//   5. Brielle Williamson adli kisinin liste de var olup olmadigini dogrulayin
        Assert.assertTrue(isimlerText.contains("Brielle Williamson"));
    }


        /*  Testcase 3
   1. tarayiciyi acin
   2. https://editor.datatables.net/ siteye gidin
   3. a) baslik olamadan butun satirlarin uzunlugunu yazdirin
      b) bir sutunun uzunlugunu yazdirin
      c) butun satirlari basliksiz olarak liste atin
   4. listi yazdirin
   5. Brielle Williamson adli kisinin liste de var olup olmadigini dogrulayin
 */
/*  Testcase 4
   1. tarayiciyi acin
   2. https://editor.datatables.net/ siteye gidin
   2  b) Caesar Vance sutun uzunlugunu yazdirin
   3. a) butun satirlari basliksiz olarak liste atin
      b) Caesar Vance nin butun bilgilerini tek tek yazdirin
   5. Brielle Williamson adli kisinin liste de var olup olmadigini dogrulayin
 */
        @Test
        public void basliksizSatirlar(){
//   2  b) Caesar Vance sutun uzunlugunu yazdirin
            List<WebElement> vanceSutunUzunlugunu = driver.findElements(By.xpath("//table/tbody/tr[8]/td"));
            System.out.println("vanceSutunUzunlugunu.size() = " + vanceSutunUzunlugunu.size());
//   3. a) butun satirlari basliksiz olarak liste atin
            List<WebElement> butunSatirlar = driver.findElements(By.xpath("//table/tbody/tr"));
            List<String> listSatirlar = new ArrayList<>();
            for (WebElement satir : butunSatirlar) {
                listSatirlar.add(satir.getText());
            }
            System.out.println("listSatirlar.size()2 = " + listSatirlar.size());
            System.out.println("listSatirlar.get(5) = " +listSatirlar.get(5));
//      b) Caesar Vance nin butun bilgilerini tek tek yazdirin
            int num = 1;
            // 1. yol
            for (WebElement vance : vanceSutunUzunlugunu) {
                System.out.println(num + " vance.getText() = " + vance.getText());
                num++;
            }
//   5. Brielle Williamson Integration Specialist New York 2012-12-02 $372,000 adli kisinin liste de var olup olmadigini dogrulayin
            String brielle = listSatirlar.get(5);
            Assert.assertTrue(listSatirlar.contains(brielle));
        }

    @Test
    public void basliksizSatirlar2(){

//        2  b) Caesar Vance sutun uzunlugunu yazdirin
        List<WebElement> vanceSatir = driver.findElements(By.xpath("//table[@id='example']/tbody/tr[8]/td"));
        System.out.println("vanceSatir.size() = " + vanceSatir.size());
//        3. a) butun satirlari basliksiz olarak liste atin
        List<WebElement> butunSatirlar = driver.findElements(By.xpath("//table/tbody/tr"));
        List<String> listSatirlar = new ArrayList<>();
        for (WebElement satir : butunSatirlar) {
            listSatirlar.add(satir.getText());
        }
        System.out.println("listSatirlar.size() = " + listSatirlar.size());
//        b) Caesar Vance nin butun bilgilerini tek tek yazdirin
        // 1.yol
        for (WebElement vance : vanceSatir) {
            System.out.println("vance.getText() = " + vance.getText());
        }
        // 2. yol


//        5. Brielle Williamson adli kisinin liste de var olup olmadigini dogrulayin
    }

    @Test
    public void tableList2(){

        //        3. butun isimleri bir List e atin
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));

        //        4. listi yazdirin
        int lengthOfRow = rows.size();
        for (int i = 1; i <= lengthOfRow; i++) {
            WebElement onData = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i +"]/td[2]"));
            System.out.println(onData.getText());
        }



        //        5. Brielle Williamson adli kisinin liste de var olup olmadigini dogrulayi
        WebElement BrielleWilliamson = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[6]/td[2]"));
        Assert.assertTrue(BrielleWilliamson.getText().contains("Brielle Williamson"));
    }


    @Test
    public void dataInRow(){
        List<WebElement> dataInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        System.out.println("dataInRow.size() = " + dataInRow.size());
        for (WebElement element : dataInRow) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void oneDataInRow(){
        WebElement onData = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("onData.getText() = " + onData.getText());
    }
}
