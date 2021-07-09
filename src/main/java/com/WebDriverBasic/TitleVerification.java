package com.WebDriverBasic;

import com.Base.TestBase;

public class TitleVerification extends TestBase {

    public static void main(String[] args) {
        firefoxLaunch();
        testCase_001();
        testCase_002();
        testCase_003();
        testCase_004();
        closeBrowser();
    }
    private static void testCase_001(){
        //step 1
        openURL("https://apple.com");
        //Step 2
        String Exp_Title="APPLE";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Title Verified.Test PASSED!!");
        }
        else {
            System.out.println("Title not Verified.Test FAILED!!");
        }
    }

    private static void testCase_002(){
        //step 1
        openURL("https://apple.com");
        //Step 2
        String Exp_Title="apple";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Title Verified.Test PASSED!!");
        }
        else {
            System.out.println("Title Verified.Test FAILED!!");
        }
    }
    private static void testCase_003(){
        //step 1
        openURL("https://apple.com");
        //Step 2
        String Exp_Title="Apple";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Title Verified.Test PASSED!!");
        }
        else {
            System.out.println("Title not Verified.Test FAILED!!");
        }
    }

    private static void testCase_004(){
        //step 1
        openURL("https://apple.com");
        //Step 2
        String Exp_Title="";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Title Verified.Test PASSED!!");
        }
        else {
            System.out.println("Title not Verified.Test FAILED!!");
        }
    }
}
