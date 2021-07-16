package com.Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginStep {

    WebDriver driver;

    @Given("Open Browser and Navigate to Login page")
    public void open_browser_and_navigate_to_login_page() {
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @When("Enter valid Email and password")
    public void enter_valid_email_and_password() {
        WebElement Email=driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        //Email
        Email.clear();
        Email.sendKeys("user101@gmail.com");
        //Password
        Password.clear();
        Password.sendKeys("123456");
        //Login Button
        LoginBtn.click();
    }

    @Then("Login Successful and close test")
    public void login_Successful_and_close_test() {
        // If Login--> Test failed
        String Exp_Title="My Account";
        String Act_Title=driver.getTitle();
        driver.close();
    }
}
