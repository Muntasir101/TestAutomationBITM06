package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTest extends TestBase {

 //    public static WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
 //    public static WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
//     public static WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

    public static void main(String[] args) {
        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/login");
        TC_Login_Invalid_001();
        TC_Login_Valid_002();
//        TC_Login_Invalid_003();
//        TC_Login_Invalid_004();
        closeBrowser();
    }
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
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }
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

        // If Login--> Test Passed
        // Else --> Test Failed
        // If Login--> Test failed
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for Valid test Data");
        }
        else {
            System.out.println("Test FAILED!! for Valid test Data");
        }
        System.out.println("Test Case 002 Executed");
    }

    public static void TC_Login_Invalid_003(){
         WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
         WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
         WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action

        Email.clear();
        Email.sendKeys("");

        Password.clear();
        Password.sendKeys("123456");

        LoginBtn.click();

        // If Login--> Test failed
        // Else --> Test Passed
// If Login--> Test failed
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }
        System.out.println("Test Case 003 Executed");
    }
    public static void TC_Login_Invalid_004(){
         WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
         WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action

        Email.clear();
        Email.sendKeys("");

        Password.clear();
        Password.sendKeys("");

        LoginBtn.click();

        // If Login--> Test failed
        // Else --> Test Passed
         // If Login--> Test failed
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }
        System.out.println("Test Case 004 Executed");
    }

}
