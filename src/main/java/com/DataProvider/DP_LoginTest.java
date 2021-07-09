package com.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DP_LoginTest {
    WebDriver driver;
    String BaseURL="https://demo.opencart.com/index.php?route=account/login";

    @DataProvider(name="Valid_LoginData")
    public Object [][] data(){
        Object [][] data=new Object[3][2]; //Rc, Row, Column
        //Set 1
        data[0][0]="mail@mail.com";
        data[0][1]="123456";
        //Set 2
        data[1][0]="mail2@mail.com";
        data[1][1]="";
        //Set 3
        data[2][0]="";
        data[2][1]="123456";

        return data;
    }

    @DataProvider(name="InValid_LoginData")
    public Object [][] data2(){
        Object [][] data2=new Object[3][2]; //Rc, Row, Column
        //Set 1
        data2[0][0]="mail11@mail.com";
        data2[0][1]="123456";
        //Set 2
        data2[1][0]="mail22@mail.com";
        data2[1][1]="asasddss";
        //Set 3
        data2[2][0]="mail33@mail.com";
        data2[2][1]="123456";

        return data2;
    }
    @BeforeClass
    public void browserConfig(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
    }

    @BeforeMethod
    public void launchBrowser(){
      driver=new FirefoxDriver();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    @AfterClass
    public void testDone(){
        System.out.println("Test Complete...!!!");
    }

    @Test(dataProvider ="InValid_LoginData")
    public void loginTest(String DP_Email, String DP_Pass){
        driver.get(BaseURL);
        WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        //Email
        Email.clear();
        Email.sendKeys(DP_Email);

        //Password
        Password.clear();
        Password.sendKeys(DP_Pass);

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

    }
}
