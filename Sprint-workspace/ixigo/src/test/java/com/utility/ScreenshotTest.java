package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTest {

	//below for ExtentReport
	public static String takesScreen(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot screen1=(TakesScreenshot)driver;  //TakeScreenshot is an interface
		File src1= screen1.getScreenshotAs(OutputType.FILE);
		String screens="C:\\Users\\manvsriv\\Practo\\PractoAutomation\\ExtentReportScreenshot"
		+filename+".png";
		File dest=new File(screens);
	   FileUtils.copyFile(src1, dest);
		return screens;
		
		
	}
 
}
