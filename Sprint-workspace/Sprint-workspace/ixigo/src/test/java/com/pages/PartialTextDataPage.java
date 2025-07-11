package com.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class PartialTextDataPage extends BasePage {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	@FindBy(xpath = "//span[contains(@class, 'absolute') and contains(@class, 'top-20') and contains(text(), 'From')]")
	WebElement FromOneWay;

	@FindBy(xpath = "//span[contains(text(),'Pune')]")
	WebElement puneOption;

	@FindBy(xpath = "//span[contains(text(),'To')]/following::input[1]")
	WebElement ToOneWay;

	@FindBy(xpath = "//p[contains(text(),'Delhi Indira Gandhi International Airport')]")
	WebElement delhiOption;

	public PartialTextDataPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		loadProperties();
	}

	private void loadProperties() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Sprint-workspace\\ixigo\\src\\test\\resource\\PropertieFiles\\FlightSearch.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPartialText() {
		Actions actions = new Actions(driver);

		// From field
		FromOneWay.click();
		actions.sendKeys(prop.getProperty("Fromsugg")).pause(Duration.ofSeconds(1)).perform();
		WebElement sugg = wait.until(ExpectedConditions.elementToBeClickable(puneOption));
		sugg.click();

		// To field
		// ToOneWay.click();
		WebElement toInput = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'To')]/following::input[1]")));
		toInput.click();
		actions.sendKeys(prop.getProperty("Tosugg")).pause(Duration.ofSeconds(1)).perform();
		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(delhiOption));
		suggestion.click();
	}
}
