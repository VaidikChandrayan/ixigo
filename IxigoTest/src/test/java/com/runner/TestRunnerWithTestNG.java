package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "C:\\Windows.old\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\My_Project\\IxigoTest\\src\\test\\resources\\Features\\Hotels.feature",
    glue = {"com.stepDefinition"},
   // tags = "@DateValidation",
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reportsprintfinal1.html",
    			    "json:target/cucumber.json",
    			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    			}
)
public class TestRunnerWithTestNG extends AbstractTestNGCucumberTests {
}




