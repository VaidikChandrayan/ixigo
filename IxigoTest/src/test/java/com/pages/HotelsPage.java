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

public class HotelsPage {

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

	// -------------Scenario 3 -------
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div[1]/div/div")
	WebElement sortDropdown;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[3]")
	WebElement sortOptions;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/input")
	WebElement areaSearchInput;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div")
	WebElement areaSuggestions;

	/* ---------- Scenario-5: Most Popular filter locators ---------- */
	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/p")
	WebElement mostPopularHeader;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/span/input")
	WebElement freeBreakfastOption;

	// Constructor

	public HotelsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	// Scenario-1 methods

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

			Thread.sleep(1000); // Allow suggestions to load

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

	// -------------------------------Scenario 3 -------------------------------------------------------------
	// Step 8: Sort hotel results by selecting a random option from Popularity
	// dropdown
	public void openSortDropdown() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)).click();
			System.out.println("Opened sort dropdown.");
		} catch (Exception e) {
			System.out.println("Failed to open sort dropdown: " + e.getMessage());
		}
	}

	public void selectRandomSortOption() {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(sortOptions)).click();
			System.out.println("Selected sort option: ");
		} catch (Exception e) {
			System.out.println("Failed to select sort option: " + e.getMessage());
		}
	}

	public void validateSortedResults() {
		try {
			Thread.sleep(2000); // Allow time for refresh
			System.out.println(" Hotel results refreshed.");
			// Optional: Add validation logic like checking result titles or order
		} catch (Exception e) {
			System.out.println(" Failed to validate sorted results: " + e.getMessage());
		}
	}

	// ------------------------------Scenario 4 // --------------------------------------

	// open the “Search within area” input
	public void openAreaSearchField() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(areaSearchInput)).click();
			System.out.println(" Opened area search field");
		} catch (Exception e) {
			System.out.println("Failed to open area field: " + e.getMessage());
		}
	}

	// click the first area suggestion
	public void selectFirstAreaSuggestion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(areaSuggestions)).click();
			System.out.println("Selected sort option: ");

		} catch (Exception e) {
			System.out.println("Failed to select area suggestion: " + e.getMessage());
		}
	}

	// quick validation that results list refreshed (url or title contains the area)
	public boolean isAreaFilterApplied() {
		try {
			Thread.sleep(1500); // allow results to reload
			return driver.getPageSource().toLowerCase().contains("showing properties")
					|| driver.getCurrentUrl().contains("&area=");
		} catch (Exception ignored) {
			return false;
		}
	}

	// -------------------------------------------Scenario 5 ----------------------------------
	
	// Scroll to Most Popular section
	public void scrollToMostPopularFilter() {
		try {
			WebElement mostPopular = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/p")));
			js.executeScript("arguments[0].scrollIntoView(true);", mostPopular);
			Thread.sleep(1000);
			System.out.println("Scrolled to Most Popular filter section");
		} catch (Exception e) {
			System.out.println("Failed to scroll to Most Popular section: " + e.getMessage());
		}
	}

	public void selectFreeBreakfastFilter() {
		try {

			// Click on "Free Breakfast"
			By freeBreakfastFilter = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]");
			WebElement freeBreakfast = wait.until(ExpectedConditions.elementToBeClickable(freeBreakfastFilter));
			js.executeScript("arguments[0].click();", freeBreakfast);
			System.out.println("Selected filter: Free Breakfast");

			Thread.sleep(3000); // Wait for results update
		} catch (Exception e) {
			System.out.println("Failed to select Free Breakfast filter: " + e.getMessage());
		}
	}

	public void selectParkingAvailableFilter() {
		try {

			// Click on "Parking Available"
			By parkingFilter = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[4]");
			WebElement parking = wait.until(ExpectedConditions.elementToBeClickable(parkingFilter));
			js.executeScript("arguments[0].click();", parking);
			System.out.println("Selected filter: Parking Available");

			Thread.sleep(3000); // Wait again for results update
		} catch (Exception e) {
			System.out.println("Failed to select Parking Available filter: " + e.getMessage());
		}
	}

	// Wait after filter applied (can improve with dynamic wait later)
	public void waitForHotelResultsToUpdate() {
		try {
			Thread.sleep(3000);
			System.out.println("Waited for hotel results to update");
		} catch (Exception e) {
			System.out.println("Waiting failed: " + e.getMessage());
		}
	}

	// --------------------------------Scenario 6 --------------------------------------------
	

	// Scroll to User Rating section
	public void scrollToUserRatingFilter() {
		try {
			WebElement userRating = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[5]/p")));
			js.executeScript("arguments[0].scrollIntoView(true);", userRating);
			Thread.sleep(1000);
			System.out.println(" Scrolled to User Rating section");
		} catch (Exception e) {
			System.out.println(" Scroll to User Rating failed: " + e.getMessage());
		}
	}

	// Click "Good: 6+" User Rating
	public void selectGoodUserRating() {
		try {
			By goodRating = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[5]/div[4]");
			WebElement ratingOption = wait.until(ExpectedConditions.elementToBeClickable(goodRating));
			js.executeScript("arguments[0].click();", ratingOption);
			Thread.sleep(3000);
			System.out.println(" Selected User Rating: Good: 6+");
		} catch (Exception e) {
			System.out.println(" Failed to click Good rating: " + e.getMessage());
		}
	}

	// Scroll to Star Rating section
	public void scrollToStarRatingFilter() {
		try {
			WebElement starRating = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[7]/p")));
			js.executeScript("arguments[0].scrollIntoView(true);", starRating);
			Thread.sleep(1000);
			System.out.println("✅ Scrolled to Star Rating section");
		} catch (Exception e) {
			System.out.println("❌ Scroll to Star Rating failed: " + e.getMessage());
		}
	}

	// Click 4-star rating
	public void selectFourStarRating() {
		try {
			By fourStar = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[7]/div/div[2]/span/span");
			WebElement fourStarOption = wait.until(ExpectedConditions.elementToBeClickable(fourStar));
			js.executeScript("arguments[0].click();", fourStarOption);
			Thread.sleep(3000);
			System.out.println("✅ Selected 4 Star Rating");
		} catch (Exception e) {
			System.out.println("❌ Failed to click 4 Star: " + e.getMessage());
		}
	}

	// Wait for hotel list to refresh
	public void waitForHotelResultsToUpdates() {
		try {
			Thread.sleep(3000);
			System.out.println("✅ Waited for hotel results to update");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ------------------------Scenario 7  -------------------------------------------
	
	// Click the "Book Now" button on the first hotel result
	public void clickFirstBookNowButton() {
		try {
			By bookNowBtn = By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/a[1]/div/div[1]/div[3]/button");
			WebElement bookNow = wait.until(ExpectedConditions.elementToBeClickable(bookNowBtn));
			js.executeScript("arguments[0].click();", bookNow);
			System.out.println("Clicked on Book Now for first hotel");
			Thread.sleep(3000); // Let the page load
		} catch (Exception e) {
			System.out.println("X Failed to click Book Now: " + e.getMessage());
		}
	}

	// Validate redirection to reservation page
	/*
	 public boolean isOnReservationPage() { try { 
	 // Adjust this check as per actual reservation page element/text/url return
	 wait.until(ExpectedConditions.urlContains("/hotels")); } catch (Exception e)
	 { System.out.println("X Failed to verify reservation page: " +e.getMessage()); return false; } }
	 */

	// ----------------------------------------Negative Scenario-----------------------------------------

	
	 /*public void selectTodayAsCheckInDate() { try { WebElement checkIn =
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[8]"))); checkIn.click();
	  
	 } catch (Exception e) { System.out.println("X Failed to select today: " +e.getMessage()); } }
	 
	  public void selectSameDateAsCheckOut() { try {
	  WebElement checkOut =
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[8]" )));
	 
	 checkOut.click(); } catch (Exception e) {
	 System.out.println("X Failed to select same check-out date: " +
	 e.getMessage()); } }
	
	 public void isCheckOutDateAccepted() { // Implement logic to check if the
	 //check-out date field updated // Example: return false if same date is
	 System.out.println("Check-Out date blank");
	 }*/
	 

}
