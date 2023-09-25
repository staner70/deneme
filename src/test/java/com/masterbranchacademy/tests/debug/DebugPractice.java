package com.masterbranchacademy.tests.debug;

public class DebugPractice {
    public static void main(String[] args) {
        
/*        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            
        }
        System.out.println("sum = " + sum);*/

        String str = "a4d5g1y";
        toplama(str);
    }

    public static void toplama(String str){
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt("" +str.charAt(i)) ;
            }


        }
        System.out.println("sum = " + sum);
    }
}
