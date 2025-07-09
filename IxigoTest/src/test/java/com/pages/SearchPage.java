package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.ConfigReader;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {

	// Web-driver setup

	private final WebDriver driver;
	private final WebDriverWait wait;
	private final JavascriptExecutor js;

	// Page-Factory locators 

	@FindBy(css = "button[aria-label='Close']") //pop-up close
	private WebElement popUpClose;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/div[1]/div/div/a[3]/p")
	private WebElement hotelsTab;

	@FindBy(xpath = "/html/body/main/div[4]/div[2]/div/div[1]/div[1]/div[1]/input")
	private WebElement destinationInput;

	@FindBy(xpath = "/html/body/main/div[4]/div[2]/div/div[1]/div[2]/div/div/div[1]/div")
	private WebElement goaSuggestion;

	// calendar frame opener (any rd-date container)
	@FindBy(xpath = "//div[contains(@class,'rd-date')]")
	private WebElement dateBox;

	// Search Hotels button
	@FindBy(xpath = "/html/body/main/div[4]/div[2]/div/button")
	private WebElement searchBtn;


	// Constructor

	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
		//PageFactory.initElements(driver, this);
	}

	
	
	//===================================Scenario-1 Methods==========================================
	
	
	public void loadHomePage() {
		try {
			String url = ConfigReader.getProperty("base.url");
			driver.get(url);
			System.out.println("Loaded: " + url);
		} catch (Exception e) {
			System.out.println("Failed to load homepage: " + e.getMessage());
		}
	}

	// When – handle the promo pop-up 
	public void handleInitialPopUp() {
		try {
			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // shorter wait
			WebElement closeBtn = shortWait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("button[aria-label='Close'], ixi-icons-close, .close")));
			closeBtn.click();
			System.out.println("Pop-up closed using close button.");
		} catch (TimeoutException e) {
			System.out.println("Pop-up not shown in time, trying fallback...");

			//  Click somewhere on the page or use Robot
			try {
				WebElement body = driver.findElement(By.tagName("body"));
				body.click();
				Thread.sleep(400);
				System.out.println("Pop-up closed using body click.");
			} catch (Exception ex) {
				try {
					Robot robot = new Robot();
					robot.mouseMove(100, 100);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					System.out.println("Pop-up dismissed using Robot fallback.");
				} catch (Exception ignored) {
					System.out.println("Failed to dismiss pop-up.");
				}
			}
		}
	}

	// click the “Hotels” tab in navbar
	public void clickHotelsTab() {
		wait.until(ExpectedConditions.elementToBeClickable(hotelsTab)).click();
		System.out.println("Hotels tab clicked");
	}

	// Then – quick URL/title validation
	public boolean isOnHotelsPage() {
		return driver.getCurrentUrl().contains("/hotels") || driver.getTitle().toLowerCase().contains("hotel");
	}
	
	

	// ============================================Scenario-2 methods==================================================

	
	
	
	// Step: Enter destination
	public void enterDestination(String place) {
		try {
			
			destinationInput.click();
			destinationInput.click();
			destinationInput.sendKeys(Keys.CONTROL + "a"); // Select all
			destinationInput.sendKeys(Keys.DELETE); // Clear
			destinationInput.sendKeys(place); // Enter new destination

			Thread.sleep(1000); // Allow suggestions to load

			System.out.println("Entered destination: " + place);
		} catch (Exception e) {
			System.out.println("Failed to enter destination: " + e.getMessage());
		}
	}

	// Step 5: Select destination from suggestions
	public void selectDestinationSuggestion() {
		try {
			
			goaSuggestion.click();
			System.out.println("Selected destination from suggestions");
		} catch (Exception e) {
			System.out.println("Failed to select destination suggestion: " + e.getMessage());
		}
	}

	// 3) open calendar & choose any two visible future dates
	public void selectCheckInCheckOutDates() {
		
		WebElement checkIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[12]")));
		WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[13]")));
		checkIn.click();
		checkOut.click();
	}

	// Step 6: Select rooms and guests
	public void selectRoomsAndGuests() {
		try {
			 Thread.sleep(1000); // Let the panel open after date selection

			/*By addAdultBtn = By.xpath(
					"/html/body/main/div[4]/div[2]/div/div[3]/div[2]/div/div/div/div[1]/div[2]/div/p[2]/svg");*/
			 
			 By addAdultBtn =  By.cssSelector("body > main > div.home-container > div.rounded-20.bg-primary.p-20.shadow-500 > div > div:nth-child(3) > div.absolute.left-0.z-20 > div > div > div > div:nth-child(1) > div.ml-auto > div > p:nth-child(4) > svg");
			 
			WebElement plusBtn = wait.until(ExpectedConditions.elementToBeClickable(addAdultBtn));
			plusBtn.click();

			System.out.println(" Increased number of adults.");
			// Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println(" Failed to select Rooms & Guests: " + e.getMessage());
		}
	}

	// 5) click Search button
	public void clickSearchHotels() {
		js.executeScript("arguments[0].scrollIntoView({block:'center'})", searchBtn);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
	}
}
