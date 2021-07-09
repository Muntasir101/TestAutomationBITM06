package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

public static WebDriver driver;


    public static void firefoxLaunch(){
        //set driver path: dynamic
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver(); // Constructor of FirefoxDriver Class
    }
    public static void chromeLaunch(){
        //set driver path: dynamic
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe");
        driver=new ChromeDriver(); // Constructor of ChromeDriver Class
        //Maximize browser size
        driver.manage().window().maximize();
    }
    public static void openURL(String Url){
        driver.get(Url);
    }

    public static void closeBrowser(){
        driver.close();
    }

}
