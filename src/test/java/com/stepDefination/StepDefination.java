package com.stepDefination;

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
 
    @When("I click on the Search button")
    public void i_click_on_the_search_button() {
        busSearchPage.clickSearch();
    }
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


