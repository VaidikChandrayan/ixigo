package com.runner;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Windows.old\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\My_Project\\IxigoTest\\src\\test\\resources\\Features\\Hotels.feature",
    glue = "com.stepDefinition",
    plugin = {"pretty","html:target/CucumberReportSprintNegative1.html"},
    monochrome = true
   //tags= "@DateValidation"
)
public class TestRunner {}




