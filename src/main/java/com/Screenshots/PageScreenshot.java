package com.Screenshots;
import java.io.File;
import java.io.IOException;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class PageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
       firefoxLaunch();
       openURL("https://google.com");
        screenshot("Page Image");
        closeBrowser();
    }

    public static void screenshot(String name) throws IOException {
        //Take Screenshot
      File srcFile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //Save image
        FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//main//Screenshots//"+name+".png"),true);
    }
}
