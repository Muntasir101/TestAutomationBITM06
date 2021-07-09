package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends TestBase {
    public static void main(String[] args) {
         chromeLaunch();
         openURL("https://demo.opencart.com/index.php?route=account/login");
         LoginTest.TC_Login_Valid_002();
         logOut();
         closeBrowser();
    }
    public static void logOut(){
        WebElement myAccount=driver.findElement(By.linkText("My Account"));
        WebElement logout=driver.findElement(By.linkText("Logout"));

        myAccount.click();
        logout.click();

       // System.out.println("Logout Success");
    }
}
