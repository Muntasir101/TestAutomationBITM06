package com.Rough;

public class Calculator3 extends Calculator2 {

    public static void main(String[] args) {
        sum();
        sub();
       multiply();
       division();
    }
    public static void multiply(){
        int a=10;
        int b=5;
        int multy=a*b;
        System.out.println(multy);
    }
    public static void division(){
        int a=10;
        int b=5;
        int div=a/b;
        System.out.println(div);
    }

}

