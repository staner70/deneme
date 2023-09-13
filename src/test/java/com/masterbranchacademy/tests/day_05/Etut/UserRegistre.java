package com.masterbranchacademy.tests.day_05.Etut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserRegistre {
            /*  Kullanıcıyı Kaydet
            Test Durumu 1: Kullanıcıyı Kaydet
        1. Tarayıcıyı başlatın
        2. 'http://automationexercise.com' URL'sine gidin
        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        6. Adı ve e-posta adresini girin
        7. 'Kaydol' düğmesini tıklayın
        8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        13. 'Hesap Oluştur düğmesini' tıklayın
        14. 'HESAP OLUŞTURULDU!' görünür
        15. 'Devam Et' düğmesini tıklayın
        16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        17. 'Hesabı Sil' düğmesini tıklayın
        18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
             */

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDrivers\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        driver.close();
    }

    @Test
    public void userRegistre() throws InterruptedException {
       // WebElement title = driver.findElement(By.xpath("//*[@id='slider-carousel']/div/div[1]/div[1]/h1/span"));
        //String actualTitle = title.getText();
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle,expectedTitle, "Test Basarisiz");

        Thread.sleep(3000);

        WebElement btnLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        btnLogin.click();

        Thread.sleep(3000);

        WebElement textNewUser = driver.findElement(By.xpath("(//h2)[3]"));
        String actualNewUserText = textNewUser.getText();
        String expectedNewUserText = "New User Signup!";

        Assert.assertEquals(actualNewUserText, expectedNewUserText, "TEST NEW USER TEXT FAIL");

        // 6. Adı ve e-posta adresini girin

        WebElement userName = driver.findElement(By.xpath("//input[@name='name']"));

        userName.sendKeys("qa automation engineer");

        WebElement userEmail = driver.findElement(By.xpath("//form[@action='/signup']/input[@type='email']"));

        userEmail.sendKeys("qaenginer@gmail.com");

        Thread.sleep(3000);

        //7. 'Kaydol' düğmesini tıklayın

        WebElement btnSignup = driver.findElement(By.xpath("//form[@action='/signup']/button"));

        btnSignup.click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın

        WebElement hesapBilgisi = driver.findElement(By.xpath("(//h2/b)[1]"));

        Assert.assertEquals(hesapBilgisi.getText(), "ENTER ACCOUNT INFORMATION", "Enter Account information  gelmedi");

        // 9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi

        WebElement title = driver.findElement(By.xpath("//input[@value='Mr']"));
        Thread.sleep(2000);
        title.click();

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("qkldjfmlkjd");

        WebElement newsletter = driver.findElement(By.id("newsletter"));
        newsletter.click();

        WebElement partners = driver.findElement(By.id("optin"));
        partners.click();

        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Tonny");

        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys("company it");

        WebElement state = driver.findElement(By.xpath("//input[@data-qa='state']"));
        state.sendKeys("Madrid");

        WebElement city = driver.findElement(By.xpath("//input[@data-qa='city']"));
        city.sendKeys("Madrid");

        WebElement zipcode = driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
        zipcode.sendKeys("41950");

        WebElement mobile_number = driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
        mobile_number.sendKeys("+3456828788");

        Thread.sleep(3000);
        // 13. 'Hesap Oluştur düğmesini' tıklayın

        WebElement create = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        Thread.sleep(3000);
        create.click();

        Thread.sleep(3000);

//       14. 'HESAP OLUŞTURULDU!' görünür

        WebElement createdSuccessfullyText = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertEquals(createdSuccessfullyText.getText(), "ACCOUNT CREATED!", "Account not created");

//        15. 'Devam Et' düğmesini tıklayın

        WebElement continueBtn = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        continueBtn.click();

/*        WebElement reklamBtnClose = driver.findElement(By.xpath("//*[@id='dismiss-button']/div/span"));
        reklamBtnClose.click();*/
        driver.switchTo().frame("aswift_1");
        driver.switchTo().frame("ad_iframe");
        driver.findElement(By.id("dismiss-button")).click();


//        16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın

        Thread.sleep(3000);
        WebElement loggedMessage = driver.findElement(By.xpath("//li[10]/a/i"));
        System.out.println("loggedMessage.getText() = " + loggedMessage.getText());

        //17. 'Hesabı Sil' düğmesini tıklayın

        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href=\"/delete_account\"]"));
        deleteAccount.click();

        //18. 'HESAP SİLİNDİ!' görünür

        Thread.sleep(3000);
        WebElement deletedSuccessfully = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertEquals(deletedSuccessfully.getText(),"ACCOUNT DELETED!");
    }



}
