package com.Navigation;

import com.Base.TestBase;

public class NavigateTest extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://demo.opencart.com/");
        driver.navigate().to("https://google.com");
        navigateBack();
        navigateForward();
        pageRefresh();
        closeBrowser();
    }

    public static void navigateBack(){
        driver.navigate().back();
        String Exp_Title="Your Store";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! Navigate back");
        }
        else {
            System.out.println("Test FAILED!! Navigate back");
        }

    }
    public static void navigateForward(){
        driver.navigate().forward();
        String Exp_Title="Google";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! Navigate Forward");
        }
        else {
            System.out.println("Test FAILED!! Navigate Forward");
        }
    }

    public static void pageRefresh(){
        driver.navigate().refresh();
        System.out.println("Page Refresh DONE");

    }
}
