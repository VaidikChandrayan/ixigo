package com.stepDefination;

<<<<<<< HEAD
import com.factory.BusFiltersFactory;
import com.factory.SeatSelectionFactory;
import com.factory.homeFactory;
import com.factory.newhomFactory;
import com.parameters.ExcelReader;

//import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefination {

    WebDriver driver;
    homeFactory busSearchPage;
    newhomFactory busMainPage;
   SeatSelectionFactory busNewPage;
   BusFiltersFactory busFilter;
   //busSearchPage.loadProperties();

    /* 
     *                   BACKGROUND STEPS
     * 
     */
//
   @Given("User is on the Bus search page")
   public void user_is_on_the_bus_search_page() {
        driver = new ChromeDriver();
        busSearchPage = new homeFactory(driver);
        busMainPage = new newhomFactory(driver);
        busNewPage=new SeatSelectionFactory(driver);
        busFilter=new BusFiltersFactory(driver);
        
        busSearchPage.openWebsite();
        busSearchPage.loadProperties();
        
    }

    /* 
     *                   COMMON ACTION STEPS
    * 
    */

   @When("I enter  as the source city")
   public void i_enter_as_the_source_city() {
	   busSearchPage.loadProperties();
	   busSearchPage.enterSourceCity();
   }
   @When("I enter   as the destination city")
   public void i_enter_as_the_destination_city() {
	   busSearchPage.loadProperties();
	   busSearchPage.enterDestinationCity();
   }
   
    @When("I select a travel date")
    public void i_select_a_travel_date() throws InterruptedException {
        busSearchPage.selectTravelDate();
    }

=======
import com.factory.homeFactory;
import com.factory.newhomFactory;

//import com.pageFa.IxigoBusSearchPage;
import com.pages.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class StepDefination {
 
    WebDriver driver;
    homeFactory busSearchPage;
    newhomFactory busMainPage;
//    BasePage busSearchPage2;
 
/*-------------------BackGround-------------------------*/
    @Given("User is on the Bus search page")
    public void user_is_on_the_bus_search_page() {
        driver = new ChromeDriver();
        busSearchPage = new homeFactory(driver);
        busMainPage=new newhomFactory(driver);
        busSearchPage.openWebsite();
    }
 
    /*----------------------Scenario 1 & 2 --------------------*/

    @When("I enter {string} as the source city")
    public void i_enter_as_the_source_city(String city) {
        busSearchPage.enterSourceCity(city);
    }
 
    @When("I enter {string} as the destination city")
    public void i_enter_as_the_destination_city(String city) {
        busSearchPage.enterDestinationCity(city);
    }
 
    @When("I select a travel date")
    public void i_select_a_travel_date() {
        busSearchPage.selectTravelDate(); // Add logic when implemented
    }
 
>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab
    @When("I click on the Search button")
    public void i_click_on_the_search_button() {
        busSearchPage.clickSearch();
    }
<<<<<<< HEAD

    /* 
     *              SCENARIO 1 - SUCCESSFUL SEARCH
     * 
     */
    
    

    @Then("I should see a list of available bus options")
    public void i_should_see_a_list_of_available_bus_options() {
        System.out.println("Bus options are displayed.");
        // TODO: Add assertions to verify search results
    }

    /* 
     *            SCENARIO 2 - ERROR MESSAGE ON SEARCH
     * 
     */

   
    
    @When("I enter the source city from excel with {string}")
    public void i_enter_the_source_city_from_excel_with(String rowIndexStr) {
//    	int rowIndex=Integer.parseInt(rowIndexStr);
//	    String city=ExcelReader.getCity("Sheet1", rowIndex, 0);
//	 //   busSearchPage.enterSourceCity(city);
//	    busMainPage.loadProperties();
    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        System.out.println("Error message displayed.");
        // TODO: Add assertions to verify error messages
    }

    /* 
     *      SCENARIO 3 - PARTIAL TEXT ON RESULTS PAGE
     * 
     */
    @When("I enter  as the destination cy")
    public void i_enter_as_the_destination_cy() {
    	busMainPage.loadProperties();
    	busMainPage.enterDestinationCity2();
    }
    @When("the user types a partial city name in the From Station field")
    public void user_types_partial_name_in_from_station() throws InterruptedException {
        busMainPage.fromStation();
    }

    @When("the user types a partial city name in the To Station field")
    public void user_types_partial_name_in_to_station() throws InterruptedException {
        busMainPage.toStation();
    }

    @Then("the system should display suggestions for cities in the From Station field")
    public void the_system_should_display_suggestions_for_cities_in_the_from_station_field() {
        System.out.println("Suggestions displayed for From Station.");
        // TODO: Add assertions for verifying suggestions
    }

    @Then("the system should display suggestions for cities in the To Station field")
    public void the_system_should_display_suggestions_for_cities_in_the_to_station_field() {
        System.out.println("Suggestions displayed for To Station.");
        // TODO: Add assertions for verifying suggestions
    }
    
   
   
    /* 
     *      SCENARIO 4 - SELECT SEATS ON RESULTS PAGE
     * 
     */

  
    @When("I enter  as the destin city")
    public void i_enter_as_the_destin_city() {
    	busNewPage.loadProperties();
        busNewPage.enterDestinationCity4();
    }
    
    @When("I select travel date")
    public void i_select_travel_date() throws InterruptedException {
     // busNewPage.selectTravelDate();
    	busSearchPage.selectTravelDate();
    }
    @When("I click on Show Seats for the first bus")
    public void i_click_on_show_seats_for_a_bus() {
//        seatFactory = newbusNewPage(driver);
       busNewPage.clickFirstShowSeatsButton();
    }

    @When("I select a seat")
    public void i_select_a_seat() {
       busNewPage.selectSeat();
    }

    @When("I select a boarding point")
    public void i_select_a_boarding_point() {
       busNewPage.selectBoardingPoint();
    }

    @When("I select a dropping point")
    public void i_select_a_dropping_point() {
       busNewPage.selectDroppingPoint();
    }

    @When("I click on Continue after seat selection")
    public void i_click_on_continue_after_seat_selection() {
       busNewPage.clickContinue();
    }
    @Then("I should proceed to booking page")
    public void i_should_proceed_to_booking_page() {
       
    }

   

    /* 
     *      SCENARIO 5 - APPLY FILTERS ON PAGE
     * 
     */
    @When("I enter  as the destination")
    public void i_enter_as_the_destination() {
    	 //BusFiltersFactory filterPage = new BusFiltersFactory(driver);
    	busFilter.loadProperties();
         busFilter.enterDestinationCity1();
    }
//    @When("I enter  as the destination")
//    public void i_enter_as_the_destination() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    
    @When("I apply the AC bus filter")
    public void i_apply_the_ac_bus_filter() throws InterruptedException {
        BusFiltersFactory filterPage = new BusFiltersFactory(driver);
        filterPage.applyACFilter();
    }

    @When("I apply the Sleeper bus filter")
    public void i_apply_the_sleeper_bus_filter() throws InterruptedException {
        BusFiltersFactory filterPage = new BusFiltersFactory(driver);
        filterPage.applySleeperFilter();
    }

    @When("I apply the LowestPrice bus filter")
    public void i_apply_the_lowest_price_bus_filter() throws InterruptedException {
    	 BusFiltersFactory filterPage = new BusFiltersFactory(driver);
         filterPage.sortByLowestPrice();
    }


   @When("I apply the seats bus filter")
    public void i_apply_the_seats_bus_filter() throws InterruptedException {
       BusFiltersFactory filterPage = new BusFiltersFactory(driver);
      filterPage.seats();
    }
    @When("I apply the ratings bus filter")
    public void i_apply_the_ratings_bus_filter() throws InterruptedException {
       BusFiltersFactory filterPage = new BusFiltersFactory(driver);
       filterPage.Ratings();
    }
    @When("I apply the Arrival Time bus filter")
    public void i_apply_the_arrival_time_bus_filter() throws InterruptedException {
       BusFiltersFactory filterPage = new BusFiltersFactory(driver);
       filterPage.Arrival();
    }
    @When("I apply the Departure Time bus filter")
    public void i_apply_the_departure_time_bus_filter() throws InterruptedException {
       BusFiltersFactory filterPage = new BusFiltersFactory(driver);
       filterPage.Departure();
    }
  
    @Then("I should see filtered and sorted results")
    public void i_should_see_filtered_and_sorted_results() {
       
    }
    
    
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
=======
// ----------------------Scenario 1 final condn--------------
    @Then("I should see a list of available bus options")
    public void i_should_see_a_list_of_available_bus_options() {
        // Add validations or assertions here
    }
    
    
    //---------------------Scenario 2 final condn----------------
    
    @Then("I should see an erorr message")
    public void i_should_see_an_erorr_message() {
       
    }
//------------------------Scenario 3------------------
//    
//
    
//    @When("I enter {string} as the source city")
//    public void i_enter_will_source_city1(String city) {
//        busSearchPage.enterSourceCity(city);
//    }
// 
//    @When("I enter {string} as the destination city")
//    public void i_enter_will_destination_city1(String city) {
//        busSearchPage.enterDestinationCity(city);
//    }
// 
//    @When("I select a travel date")
//    public void i_select_a_date() {
//        busSearchPage.selectTravelDate();
//    }
//
//    @When("I click on the Search button")
//    public void i_click_on_the_button() {
//        busSearchPage.clickSearch();
//    }
//
//    
//
//@When("the user types a partial city name in the From Station field")
//public void user_types_partial_name_in_from_station() throws InterruptedException {
//busMainPage.fromStation();
//}
//
//@When("the user types a partial city name in the To Station field")
//public void user_types_partial_name_in_to_station() throws InterruptedException {
//busMainPage.toStation();
//}
//
//    @Then("the system should display suggestions for cities in the From Station field")
//    public void the_system_should_display_suggestions_for_cities_in_the_from_station_field() {
//        
//    }
//    @Then("the system should display suggestions for cities in the To Station field")
//    public void the_system_should_display_suggestions_for_cities_in_the_to_station_field() {
//       
//    }
//


}


>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab
