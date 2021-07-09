package com.WebDriverBasic;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;


public class CommonActions extends TestBase {


    public static void main(String[] args) {
        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/login");
        TC_Login_Invalid_001();
        TC_Login_Valid_002();
        closeBrowser();
    }
    public static void TC_Login_Invalid_001(){
        WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        // Action
        Email.clear();
        Email.sendKeys("email@mail.com");
        Password.clear();
        Password.sendKeys("123456");
        LoginBtn.click();
        System.out.println("Test Case 001 Executed");
    }

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
        System.out.println("Test Case 002 Executed");
    }
}
