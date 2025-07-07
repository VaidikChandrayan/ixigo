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
