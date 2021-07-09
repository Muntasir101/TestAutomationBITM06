package com.BrowserOption;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadLessTest {
    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe");
        ChromeOptions obj=new ChromeOptions();
        obj.setHeadless(true);
        driver=new ChromeDriver(obj);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(description = "Chrome HeadLess Test")
    public void headless(){
        //Formula: protocol://username:password@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String Title=driver.getTitle();
        System.out.println("Headless Test Done: "+Title);
    }
}
