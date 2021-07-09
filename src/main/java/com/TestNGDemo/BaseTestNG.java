package com.TestNGDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestNG {

    public static WebDriver driver;

   @BeforeSuite
    public static void setUpSuite(){


   }

    @AfterSuite
    public static void completeSuite(){

    }


}
