package com.masterbranchacademy.tests.day_09;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Review2 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //        1. bolum
        // 1. Tarayıcıyı başlatın
        //    2. 'https://omayo.blogspot.com/' URL'sine gidin

        //driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.quit();
    }

    @Test
    public void iframe() throws InterruptedException {
        // 1. test
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //2. “Our Products” butonuna basin
        WebElement frameElement = driver.findElement(By.id("frame"));
        driver.switchTo().frame(frameElement);
        WebElement btnOurProducts = driver.findElement(By.xpath("//li/a[@href='products.html']"));
        btnOurProducts.click();
        Thread.sleep(3000);

        //3. “Cameras product”i tiklayin
        WebElement camerasProduct = driver.findElement(By.xpath("//p[text()='Cameras']"));
        camerasProduct.click();
        //Thread.sleep(3000);

        //4. Popup mesajini yazdirin

        WebElement modal =  driver.findElement(By.className("modal-title"));

        wait.until(ExpectedConditions.visibilityOf(modal));
        System.out.println("modalText = " + modal.getText());

        //5. “close” butonuna basin
        WebElement closeBtn = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        closeBtn.click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)"));
        link.click();

        Thread.sleep(3000);

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        WebElement pageLoad = driver.findElement(By.xpath("//div[@id='udemy-promo-thumbnail']/h1"));
//        String actualPageText = pageLoad.getText();
//        String expectedPageText = "My Courses & Promo Codes";
//        Assert.assertEquals(actualPageText, expectedPageText, "Page not loaded");
        Assert.assertTrue(pageLoad.isDisplayed(), "Page not loaded");
    }
    @Test
    public void facebook() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[text()='Autoriser tous les cookies']")).click();

        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("(//div/a)[3]")).click();
        Thread.sleep(3000);

        //“firstName” giris kutusuna bir isim yazin
        WebElement firstname = driver.findElement(By.name("firstname"));

        actions.sendKeys(faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB)
                .sendKeys(email, Keys.TAB)
                .sendKeys(email, Keys.TAB)
                .sendKeys(faker.internet().password(), Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12", Keys.TAB)
                .sendKeys("Jan", Keys.TAB)
                .sendKeys("1976", Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT, Keys.TAB)
                .perform();
        Thread.sleep(3000);
        //Cinsiyeti secin
        WebElement maleBtn = driver.findElement(By.xpath("//input[@value='2']"));
        maleBtn.click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        Assert.assertTrue(maleBtn.isSelected(), "Man is not selected" );

        WebElement femaleBtn = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(femaleBtn.isSelected(), "Woman is selected");

        WebElement submitBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submitBtn.click();
        Thread.sleep(3000);
    }


    @Test
    public void createAccount() throws InterruptedException {
        // 2. test
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        driver.findElement(By.xpath("//button[text()='Autoriser tous les cookies']")).click();

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("(//div/a)[3]")).click();
        Thread.sleep(3000);

        Faker faker = new Faker();
        //“firstName” giris kutusuna bir isim yazin
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys(faker.name().firstName());
        Thread.sleep(3000);

        //“surname” giris kutusuna bir soyisim yazin
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys(faker.name().lastName());

        //“email” giris kutusuna bir email yazin
        WebElement email = driver.findElement(By.name("reg_email__"));
        String emailAdresse = faker.internet().emailAddress();
        email.sendKeys(emailAdresse);

        //“email” onay kutusuna emaili tekrar yazin
        WebElement emailConfirmation = driver.findElement(By.name("reg_email_confirmation__"));
        emailConfirmation.sendKeys(emailAdresse);

        //Bir sifre girin
        WebElement regPasswd = driver.findElement(By.name("reg_passwd__"));
        regPasswd.sendKeys(faker.internet().password());
        Thread.sleep(3000);

        //Tarih icin ay secin
        WebElement month = driver.findElement(By.id("month"));
        Select select = new Select(month);
        select.selectByValue("6");
        Thread.sleep(2000);

        //Tarih icin gun secin
        WebElement day = driver.findElement(By.id("day"));
        select = new Select(day);
        select.selectByValue("1");

        //Tarih icin yil secin
        WebElement year = driver.findElement(By.id("year"));
        select = new Select(year);
        select.selectByValue("1976");
        Thread.sleep(2000);


        //Cinsiyeti secin
        WebElement genreMan = driver.findElement(By.xpath("//input[@value='2']"));
        genreMan.click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        Assert.assertTrue(genreMan.isSelected(), "Man choose is not selected" );

        WebElement genreWoman = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(genreWoman.isSelected(), "Woman choose is selected");

    }

    @Test
    public void download() throws InterruptedException {
    //        1. Tarayıcıyı başlatın
        driver.get("https://testpages.herokuapp.com/styled/download/download.html");

    //        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement element = driver.findElement(By.id("download"));

        Thread.sleep(3000);
    //        4. 'Direct Link Download' tusuna tiklayin
    //        5. 'textfile.txt' dosyasini indigini dogrulayin
    //        6. driver`i kapatin



        String rootPath = System.getProperty("user.home");
        String relativePath = "\\Downloads\\Image.PNG";
        String fullPath = rootPath + relativePath;
        Assert.assertTrue(Files.exists(Paths.get(fullPath)), "File not downloaded" );
    }


}
