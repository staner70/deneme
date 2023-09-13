package com.masterbranchacademy.tests.day_05;

import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @Test
    public void test1(){
        System.out.println("Birinci Test");
    }

    @Test
    public void test2(){
        System.out.println("Ikinci Test");
    }

    @Test
    public void test3(){
        System.out.println("Ucuncu Test");
    }

    @Test @Ignore // 6752 nolu user story bug ticket olusturuldu
    public void test4(){
        System.out.println("Dorduncu test");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        System.out.println("Tarayici aciliyor");
    }

    @AfterMethod
    public void tarayiciyiKapat(){
        System.out.println("After Method");
        System.out.println("Tarayici kapatiliyor");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Befor class metodu");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class metodu");
    }
}
