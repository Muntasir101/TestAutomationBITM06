package com.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "F:\\Training\\PeopleNTech\\BITM Online 6\\AutomationProject\\TestAutomationBITM06\\src\\main\\java\\com\\Cucumber",
                 glue = {"com.Cucumber.LoginStep"},
                 plugin = {
                       "pretty","html:target/CucumberReport.html"
                 }
)

public class Runner {
}
