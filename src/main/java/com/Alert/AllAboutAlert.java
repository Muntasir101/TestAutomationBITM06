package com.Alert;

import com.Base.TestBase;
import com.Screenshots.PageScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AllAboutAlert extends TestBase {
    public static void main(String[] args)  {
        firefoxLaunch();
        openURL("https://the-internet.herokuapp.com/javascript_alerts");
        normalJSAlert();
        confirmJSAlert();
        promptJSAlert();
    }

    public static void normalJSAlert() {
        WebElement normalAlertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        normalAlertBtn.click();

        //Title
       String AlertTitle= driver.switchTo().alert().getText();
       System.out.println("Normal Alert Title: "+AlertTitle);

        //click ok
        driver.switchTo().alert().accept();
    }

    public static void confirmJSAlert(){
        WebElement confirmAlertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        confirmAlertBtn.click();

        //Title
        String AlertTitle= driver.switchTo().alert().getText();
        System.out.println("Confirm Alert Title: "+AlertTitle);

        //click ok
        //  driver.switchTo().alert().accept();

        //Click Cancel
        driver.switchTo().alert().dismiss();
    }
    public static void promptJSAlert(){
        WebElement promptAlertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        promptAlertBtn.click();

        //Title
        String AlertTitle= driver.switchTo().alert().getText();
        System.out.println("Prompt Alert Title: "+AlertTitle);

        //Write
        driver.switchTo().alert().sendKeys("Test Automation.");
        //click ok
        driver.switchTo().alert().accept();

        //Click Cancel
        //driver.switchTo().alert().dismiss();
    }

}
