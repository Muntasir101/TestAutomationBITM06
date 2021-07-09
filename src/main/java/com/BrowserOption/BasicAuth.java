package com.BrowserOption;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuth {

    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void basicAuthentication(){
        //Formula: protocol://username:password@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String Title=driver.getTitle();
        System.out.println(Title);
    }
}
