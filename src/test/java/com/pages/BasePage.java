package com.pages;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.event.InputEvent;

import java.time.Duration;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BasePage {
 
    WebDriver driver;

    WebDriverWait wait;
 
    @FindBy(xpath = "//input[@placeholder='From Station']")

    WebElement fromStation;
 
    @FindBy(xpath = "//input[@placeholder='To Station']")

    WebElement toStation;
 
    @FindBy(xpath = "//div[@class=' col' and text()='Pune']")

    WebElement puneOption;
 
    @FindBy(xpath = "//div[@class=' col' and text()='Mumbai']")

    WebElement mumbaiOption;
 
    @FindBy(xpath = "//button[text()='Search']")

    WebElement searchButton;
 
    public BasePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
 
    public void openWebsite()     {

        driver.get("https://bus.ixigo.com/");

        driver.manage().window().maximize();

        Robot robot;

		try {

			robot = new Robot();

			try {

				Thread.sleep(2000);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			robot.mouseMove(250, 350);

			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		} catch (AWTException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

    }
 
    public void enterSourceCity(String city) {

        wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();

        fromStation.sendKeys(city);

        wait.until(ExpectedConditions.elementToBeClickable(puneOption)).click();

    }
 
    public void enterDestinationCity(String city) {

        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();

        toStation.sendKeys(city);

        wait.until(ExpectedConditions.elementToBeClickable(mumbaiOption)).click();

    }
 
    public void selectTravelDate() {

        // To be implemented: Select a date from the calendar widget

    }
 
    public void clickSearch() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
     
    }

}
