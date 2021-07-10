package com.ExtentReport;

import com.Base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utils.Excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginExtentReport extends TestBase {

    //Extent Report
    ExtentHtmlReporter htmlReporter;
    ExtentReports report;
    ExtentTest logger;

    @BeforeClass
    public void browserConfig(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
    }
    @Test
    public void loginTest(){
        htmlReporter =new ExtentHtmlReporter("./Extent-Report/LoginTestReport.html");
        report=new ExtentReports();
        report.attachReporter(htmlReporter);

        report.setSystemInfo("OS","Windows");
        report.setSystemInfo("Browser","Firefox");
        report.setSystemInfo("Tester","Muntasir");

        logger=report.createTest("Login Test");


        driver.get("https://demo.opencart.com/index.php?route=account/login");
        logger.log(Status.INFO,"Login page Open");
        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/main/resources/LoginData.xlsx");
        String sheetName="Sheet1";

        int rowCount= reader.getRowCount(sheetName);

        for(int rowNum=2; rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email",rowNum);
            String pswrd=reader.getCellData(sheetName,"Password",rowNum);
            String input=reader.getCellData(sheetName,"input",rowNum);

            WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
            WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
            WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

            // Action
            //Email
            Email.clear();
            Email.sendKeys(email);
            logger.log(Status.INFO,"Email Typing");

            //Password
            Password.clear();
            Password.sendKeys(pswrd);
            logger.log(Status.INFO,"Password Typing");

            //Login Button
            LoginBtn.click();
            logger.log(Status.INFO,"Login Button Clicking");

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
                    logger.log(Status.PASS,"Test Passed");
                }
                else {
                    reader.setCellData(sheetName,"Result",rowNum,"Not Login");
                    logger.log(Status.FAIL,"Test FAILED");
                }
            }
            else if(input.equals("Invalid")){
                if(!Exp_Title.equals(Act_Title)){
                    //Excel write
                    reader.setCellData(sheetName,"Result",rowNum,"Not Login");
                    logger.log(Status.PASS,"Test Passed");
                }
                else {
                    WebElement myAccount=driver.findElement(By.linkText("My Account"));
                    WebElement logout=driver.findElement(By.linkText("Logout"));

                    myAccount.click();
                    logout.click();

                    driver.navigate().to("https://demo.opencart.com/index.php?route=account/login");
                    reader.setCellData(sheetName,"Result",rowNum,"Login");
                    logger.log(Status.FAIL,"Test FAILED");

                }
            }
        }
        report.flush();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

