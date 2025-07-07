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

public class SearchPage {

	// Web-driver setup

	private final WebDriver driver;
	private final WebDriverWait wait;
	private final JavascriptExecutor js;

	// Page-Factory locators 

	// ─── Scenario-1 locators ───────────────────────────
	@FindBy(css = "button[aria-label='Close']") //pop-up close
	private WebElement popUpClose;

	@FindBy(xpath = "/html/body/main/div[4]/div[1]/ul/li[2]/a/div[1]/span")
	private WebElement hotelsTab;

	// ─── Scenario-2 locators ────────────────────────────
	@FindBy(xpath = "/html/body/main/div[4]/div[2]/div/div[1]/div[1]/div[1]/input")
	private WebElement destinationInput;

	// first suggestion after typing (Ixigo shows a result list)
	@FindBy(xpath = "/html/body/main/div[4]/div[2]/div/div[1]/div[2]/div/div/div[1]/div")
	private WebElement goaSuggestion;

	// calendar frame opener (any rd-date container)
	@FindBy(xpath = "//div[contains(@class,'rd-date')]")
	private WebElement dateBox;

	// guests section opener
//    @FindBy(xpath = "//div[contains(text(),'Guests')]")
//    private WebElement guestsSection;
// 
//    // plus button for Adults (+)
//    @FindBy(xpath = "(//div[contains(text(),'Adults')]/following-sibling::div//button[contains(text(),'+')])[1]")
//    private WebElement plusAdultBtn;
// 
//    // “Apply” / “Done” button inside guest panel
//    @FindBy(xpath = "//button[text()='Apply' or text()='Done']")
//    private WebElement applyGuestsBtn;

	// Search Hotels button
	@FindBy(xpath = "/html/body/main/div[4]/div[2]/div/button")
	private WebElement searchBtn;


	// Constructor

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void loadHomePage() {
		try {
			String url = ConfigReader.getProperty("base.url");
			driver.get(url);
			System.out.println("Loaded: " + url);
		} catch (Exception e) {
			System.out.println("Failed to load homepage: " + e.getMessage());
		}
	}

	// When – handle the promo pop-up (button → body → Robot)
	public void handleInitialPopUp() {
		try {
			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // shorter wait
			WebElement closeBtn = shortWait.until(ExpectedConditions
					.elementToBeClickable(By.cssSelector("button[aria-label='Close'], ixi-icons-close, .close")));
			closeBtn.click();
			System.out.println(" Pop-up closed using close button.");
		} catch (TimeoutException e) {
			System.out.println("Pop-up not shown in time, trying fallback...");

			// Fallback: Click somewhere on the page or use Robot
			try {
				WebElement body = driver.findElement(By.tagName("body"));
				body.click();
				Thread.sleep(400);
				System.out.println("✅ Pop-up closed using body click.");
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

	// And – click the “Hotels” tab in navbar
	public void clickHotelsTab() {
		wait.until(ExpectedConditions.elementToBeClickable(hotelsTab)).click();
		System.out.println("✔ Hotels tab clicked");
	}

	// Then – quick URL/title validation
	public boolean isOnHotelsPage() {
		return driver.getCurrentUrl().contains("/hotels") || driver.getTitle().toLowerCase().contains("hotel");
	}

	// Scenario-2 methods

	// Step: Enter destination
	public void enterDestination(String place) {
		try {
			// By destinationInput =
			// By.xpath("/html/body/main/div[4]/div[2]/div/div[1]/div[1]/div[1]/input");
			WebElement destInput = wait.until(ExpectedConditions.elementToBeClickable(destinationInput));

			destInput.click();
			destInput.sendKeys(Keys.CONTROL + "a"); // Select all
			destInput.sendKeys(Keys.DELETE); // Clear
			destInput.sendKeys(place); // Enter new destination

			//Thread.sleep(1000); // Allow suggestions to load

			System.out.println("Entered destination: " + place);
		} catch (Exception e) {
			System.out.println("X Failed to enter destination: " + e.getMessage());
		}
	}

	// Step 5: Select destination from suggestions
	public void selectDestinationSuggestion() {
		try {
			// By goaSuggestion =
			// By.xpath("/html/body/main/div[4]/div[2]/div/div[1]/div[2]/div/div/div[1]/div");
			WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(goaSuggestion));
			suggestion.click();
			System.out.println("Selected destination from suggestions");
		} catch (Exception e) {
			System.out.println("Failed to select destination suggestion: " + e.getMessage());
		}
	}

	// 3) open calendar & choose any two visible future dates
	public void selectCheckInCheckOutDates() {
		// wait.until(ExpectedConditions.elementToBeClickable(dateBox)).click();
		// pick 5th and 10th visible cells (adjust if needed)
		WebElement checkIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[9]")));
		WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[10]")));
		checkIn.click();
		checkOut.click();
	}

	// Step 6: Select rooms and guests
	public void selectRoomsAndGuests() {
		try {
			// Thread.sleep(1000); // Let the panel open after date selection

			// ✅ Click on the "+" button to increase number of adults
			By addAdultBtn = By.xpath(
					"/html/body/main/div[4]/div[2]/div/div[3]/div[2]/div/div/div/div[1]/div[2]/div/p[2]/svg/path");
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
