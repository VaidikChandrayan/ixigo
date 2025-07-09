package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainSwapPage extends BasePage{
	
	public TrainSwapPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(css ="div[data-testid=swapIcon]")
	WebElement swap;
	
	
	public void clickSwap()
	{
		swap.click();
	}
	public void verifySwapHappened()
	{
		String source = FromValid.getAttribute("value");
		String destination = ToValid.getAttribute("value");
		
		if(!prop.getProperty("swapSource").equals(source) || !prop.getProperty("swapDest").equals(destination))
		{
			throw new AssertionError("Swap did not happen as expected");
		}
	}

}
