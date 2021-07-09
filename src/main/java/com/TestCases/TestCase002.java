package com.TestCases;

import com.Base.TestBase;

public class TestCase002 extends TestBase {

    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://cnn.com");
        closeBrowser();
    }
}
