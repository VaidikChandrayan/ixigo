package com.runner;                                                                                           
import io.cucumber.testng.AbstractTestNGCucumberTests;                                                        
import io.cucumber.testng.CucumberOptions;                                                                    



@CucumberOptions(
    features = {"C:\\Users\\VAIDCHAN\\OneDrive\\eclipse\\ixigo\\src\\test\\resource\\Feature\\Bus.feature"},
    tags = "@filters",
    glue = {"com.stepDefination"},
    plugin = {
        "pretty:target/pretty.txt",
        "json:target/jsonreport.json",
        "junit:target/junitReport.xml",
        "html:target/cucumberReport/HtmlReport.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
    
    )
    public class TestRunner extends AbstractTestNGCucumberTests {                                       
    }  