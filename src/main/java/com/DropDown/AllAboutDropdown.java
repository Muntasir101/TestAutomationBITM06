package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropdown extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openURL("https://the-internet.herokuapp.com/dropdown");
        selectIndex();
        selectValue();
        selectVisibleText();
        closeBrowser();
    }
    public static void selectIndex(){
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropDown);
        obj.selectByIndex(2); //Option 2
    }
    public static void selectValue(){
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropDown);
        obj.selectByValue("1"); //Option 1
    }
    public static void selectVisibleText(){
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropDown);
        obj.selectByVisibleText("Option 2"); //Option 2
    }

}
