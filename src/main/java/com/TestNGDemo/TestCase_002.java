package com.TestNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase_002 extends BaseTestNG{

    @BeforeClass
    public static void beforeClassTestCase_002()
    {
        System.out.println("I am from before Class TestCase_002");
    }

    @AfterClass
    public static void afterClassTestCase_002()
    {
        System.out.println("I am from After Class TestCase_002");
    }
    @Test
    public static void test2(){
        System.out.println("I am from Testcase_002");
    }
    @Test
    public static void test22(){
        System.out.println("I am from Testcase_0022");
    }
}
