package com.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingleFrame {
    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
    }

    @AfterClass
    public void tearDown(){
       // driver.quit();
    }

    @Test(description = "Single Frame Test")
    public void frameTest(){
        //Formula: protocol://username:password@url
        driver.get("https://the-internet.herokuapp.com/iframe");
        String Title=driver.getTitle();
        System.out.println(Title);

        //switch to iFrame
        driver.switchTo().frame("mce_0_ifr");

        WebElement iFrameBody=driver.findElement(By.id("tinymce"));
        iFrameBody.clear();
        iFrameBody.sendKeys("Test Automation Rocks!!!");
    }
}
