<<<<<<< HEAD
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
=======
package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\VAIDCHAN\\OneDrive\\eclipse\\ixigo\\src\\test\\resource\\Feature\\Bus.feature",
    glue = "com.stepDefination",tags="@log1"
//    plugin = {"pretty","html:target/CucumberReport.html"},
//    monochrome = true
)
public class TestRunner {}
>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab
