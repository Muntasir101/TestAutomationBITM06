package com.properties;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginWithProperties extends TestBase {
    public static void main(String[] args) throws FileNotFoundException,IOException{
        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/login");
        TC_Login_Invalid_001();
        closeBrowser();
     //   TC_Login_Invalid_002();
      //  TC_Login_Invalid_003();

    }

    public static void TC_Login_Invalid_001() throws FileNotFoundException , IOException {
        //Read Properties file
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//OR.properties");
        Properties prop=new Properties();
        prop.load(fis);

         WebElement Email=driver.findElement(By.xpath(prop.getProperty("Email_Xpath")));
         WebElement Password=driver.findElement(By.xpath(prop.getProperty("Password_Xpath")));
         WebElement LoginBtn=driver.findElement(By.cssSelector(prop.getProperty("LoginBtn_CSS")));

        //Email
        Email.clear();
        Email.sendKeys(prop.getProperty("Email"));

        //Password
        Password.clear();
        Password.sendKeys(prop.getProperty("password"));

        //Login Button
        LoginBtn.click();

        //Write Test report to Property file
        FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//Report.properties");
        Properties pr=new Properties();
        pr.setProperty("Tester_name","Muntasir");


        // If Login--> Test failed
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
            pr.setProperty("Email",prop.getProperty("Email"));
            pr.setProperty("Password",prop.getProperty("password"));
            pr.setProperty("InValid_Test","Passed");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
            pr.setProperty("Email",prop.getProperty("Email"));
            pr.setProperty("Password",prop.getProperty("password"));
            pr.setProperty("InValid_Test","Failed");
        }
        pr.store(fos,null);
        System.out.println("Test Case 001 Executed");
    }

}
