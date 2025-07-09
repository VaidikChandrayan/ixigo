package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	
	public static WebDriver driver;
	public static ChromeOptions coptions;
	public static EdgeOptions eoptions;
	
 
	
	public static WebDriver chromedriver()
	{
		WebDriverManager.chromedriver().setup();
		coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");
		coptions.addArguments("Incognito");
		coptions.addArguments("disable-notifications");
		coptions.addArguments("disable-popup-blocking");
		
		driver  =new ChromeDriver(coptions);
		driver.get("https://www.ixigo.com/trains");
		return driver;
		
	}
	
	public static WebDriver edgedriver()
	{
		WebDriverManager.edgedriver().setup();
		eoptions = new EdgeOptions();
		eoptions.addArguments("--start-maximized");
		eoptions.addArguments("Incognito");
		eoptions.addArguments("disable-notifications");
		eoptions.addArguments("disable-popup-blocking");
		
		driver  =new EdgeDriver(eoptions);
		driver.get("https://www.ixigo.com/trains");
		return driver;
		
	}


}
