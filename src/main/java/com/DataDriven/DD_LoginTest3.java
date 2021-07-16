package com.DataDriven;

import com.Base.TestBase;
import com.utils.Excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DD_LoginTest3 extends TestBase {

    @BeforeMethod
    public void browserConfig(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
    }
    @Test
    public void loginTest(){
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/main/resources/LoginData.xlsx");
        String sheetName="Sheet1";

        int rowCount= reader.getRowCount(sheetName);

        for(int rowNum=2; rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email",rowNum);
            String pswrd=reader.getCellData(sheetName,"Password",rowNum);
            String input=reader.getCellData(sheetName,"Input",rowNum);

            WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
            WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
            WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

            // Action
            //Email
            Email.clear();
            Email.sendKeys(email);

            //Password
            Password.clear();
            Password.sendKeys(pswrd);

            //Login Button
            LoginBtn.click();

            String Exp_Title="My Account";
            String Act_Title=driver.getTitle();

            if(input.equals("Valid")){
                if(Exp_Title.equals(Act_Title)){
                    WebElement myAccount=driver.findElement(By.linkText("My Account"));
                    WebElement logout=driver.findElement(By.linkText("Logout"));

                    myAccount.click();
                    logout.click();
                    driver.navigate().to("https://demo.opencart.com/index.php?route=account/login");
                    //Excel write
                    reader.setCellData(sheetName,"Result",rowNum,"Login");
                }
                else {
                    reader.setCellData(sheetName,"Result",rowNum,"Not Login");
                }
            }
            else if(input.equals("Invalid")){
                if(!Exp_Title.equals(Act_Title)){
                    //Excel write
                    reader.setCellData(sheetName,"Result",rowNum,"Not Login");
                }
                else {
                    WebElement myAccount=driver.findElement(By.linkText("My Account"));
                    WebElement logout=driver.findElement(By.linkText("Logout"));

                    myAccount.click();
                    logout.click();

                    driver.navigate().to("https://demo.opencart.com/index.php?route=account/login");
                    reader.setCellData(sheetName,"Result",rowNum,"Login");

                }
            }
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
