package com.TestNGDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestNG {
   public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver(); // Constructor of FirefoxDriver Class
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @Test
    public static void TC_Login_Invalid_001(){

        WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        //Email
        Email.clear();
        Email.sendKeys("email@mail.com");

        //Password
        Password.clear();
        Password.sendKeys("123456");

        //Login Button
        LoginBtn.click();


        // If Login--> Test failed
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
//        if(Exp_Title.equals(Act_Title)){
//            System.out.println("Test PASSED!! for InValid test Data");
//        }
//        else {
//            System.out.println("Test Failed!! for InValid test Data");
//        }

        Assert.assertEquals(Exp_Title,Act_Title);  // True ==> Pass || False==> Failed

    }

    @Test
    public static void TC_Login_Valid_002(){
        WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        Email.clear();
        Email.sendKeys("user101@gmail.com");
        Password.clear();
        Password.sendKeys("123456");
        LoginBtn.click();

        // If Login--> Test Passed
        // Else --> Test Failed
        // If Login--> Test failed
        String Exp_Title="My Account.";
        String Act_Title=driver.getTitle();

        //step 3: Compare
//        if(!Exp_Title.equals(Act_Title)){
//            System.out.println("Test PASSED!! for Valid test Data");
//        }
//        else {
//            System.out.println("Test FAILED!! for Valid test Data");
//        }
        Assert.assertEquals(Exp_Title,Act_Title);  // True ==> Pass || False==> Failed

    }
}
