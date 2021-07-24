package com.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@CucumberOptions(features = "./src/main/java/com/Cucumber/LoginTest.feature",
                 glue = {"com.Cucumber"},
                 plugin = {
                         "pretty","html:CucumberTestReport/CucumberReport.html",
                         "pretty", "json:CucumberTestReport/CucumberReport.json",
                 },
                  monochrome = true
      )

@RunWith(Cucumber.class)

public class  Runner {
}
