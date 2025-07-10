package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resource\\Features\\Train.feature",
glue= {"com.stepDefinition"},
tags="@swap",
plugin = {
        "pretty",
        "html:target/CucumberReport5.html",           // HTML report
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    })
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
