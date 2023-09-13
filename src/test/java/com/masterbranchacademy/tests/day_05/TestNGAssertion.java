package com.masterbranchacademy.tests.day_05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {


    @Test
    public void ilkAssertion(){
        int a = 5;
        int b = 5;
/*        if (a == b) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }*/

        Assert.assertEquals(a,b,"a b ye esit degildir");
    }

    @Test
    public void assertTrue(){
        int a = 5;


        Assert.assertTrue(a > 0, "a 0'dan buyuk degil");
    }

    @Test
    public void assertFalse(){
        int a = 5;
        Assert.assertFalse(a < 0, "a 0'dan buyuk degil");
    }
    @Test
    public void assertNotEquals(){
        int a = 5;
        int b = 6;
        Assert.assertNotEquals(a, b, "a b'ye esit");
    }
}
