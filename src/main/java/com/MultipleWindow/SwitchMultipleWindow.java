package com.MultipleWindow;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Set;

public class SwitchMultipleWindow extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://the-internet.herokuapp.com/windows");
        switchWindow();
        closeBrowser();
    }
    public static void switchWindow(){
        //Assign parent GUID
        String parentGUID=driver.getWindowHandle();
        String parentTitle=driver.getTitle();
        System.out.println("parent First Title :"+parentTitle);

     WebElement childWindBtn= driver.findElement(By.cssSelector("#content > div > a"));
     childWindBtn.click();

     //Get All GUID
        Set<String> allGUID=driver.getWindowHandles();

        //Switch to Child
        for(String childGUID:allGUID){
            driver.switchTo().window(childGUID);
            driver.navigate().to("https://google.com");
            String childTitle=driver.getTitle();
            System.out.println(childTitle);
            break;
        }

        //Switch to parent
        for(String childGUID:allGUID){
            driver.switchTo().window(parentGUID);
            driver.navigate().to("https://bbc.com");
            String parentSecondTitle=driver.getTitle();
            System.out.println("parent Second Title :"+parentSecondTitle);
            break;
        }


    }
}
