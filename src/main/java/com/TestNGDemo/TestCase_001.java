package com.TestNGDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase_001 extends BaseTestNG {

    @BeforeMethod
    public static void beforeTest1()
    {
        System.out.println("I am from Before Test 1");
    }
    @Test
    public static void test1(){
        System.out.println("I am from Testcase_001");
    }

    @Test
    public static void test11(){
        System.out.println("I am from Testcase_0011");
    }
    @AfterMethod
    public static void afterTest1()
    {
        System.out.println("I am from After Test 1");
    }
}
