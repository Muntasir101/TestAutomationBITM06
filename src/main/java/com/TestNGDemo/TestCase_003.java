package com.TestNGDemo;

import org.testng.annotations.Test;

public class TestCase_003 {

    @Test(priority = 3,description = "Login Valid Test")

    public static void loginTest_001(){
        System.out.println("I am from Testcase_001");
    }

    @Test(priority = -2,description = "Login InValid Test")
    public static void loginTest_002(){
        System.out.println("I am from Testcase_002");
    }

    @Test(priority = -1,description = "Login InValid Test")
    public static void loginTest_003(){
        System.out.println("I am from Testcase_003");
    }
}
