package com.runner;
 
import org.testng.annotations.DataProvider;
 
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features="C:\\Windows.old\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\My_Project\\IxigoTest\\src\\test\\resources\\Features\\Hotels.feature",
glue="com.stepDefinition")
public class TestRunnerParallelTest extends AbstractTestNGCucumberTests  {
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
}
}