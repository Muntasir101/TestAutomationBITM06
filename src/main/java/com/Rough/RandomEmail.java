package com.Rough;

import java.util.Random;

public class RandomEmail {
    protected static String randomName(){
        String SALTCHAR="abcdefghijABCDEFGH123";
        StringBuilder salt=new StringBuilder();
        Random rnd=new Random();
        while(salt.length()<10){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }
        String saltStr=salt.toString();
        return saltStr;
    }

    public static String email(){
        String testEmail=randomName().concat("@gmail.com");
        return testEmail;
    }
    public static void main(String[] args) {
        System.out.println(email());
    }
}
