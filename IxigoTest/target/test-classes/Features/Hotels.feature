Feature: Ixigo Hotels Module
 
  @launchSite
 Scenario: User opens ixigo site and navigates to Hotels section
    Given user launches the ixigo hotels website
    When user handles the initial popup
    And user clicks on the Hotels tab
    Then user should be on the Hotels page
    
   
    
  @SerachHotels
Scenario Outline: User fills the hotel search form and clicks Search
  Given user is on the Hotels page
  When user enters the destination from Excel using row <row> and column <col>
  And user selects the destination
  And user selects the check-in and check-out dates
  And user selects rooms and guests
  And user clicks on the Search Hotels button
  Then user should see the hotel search results
 
Examples:
  | row | col |
  |  1  |  0  |
  
  
 
  
  @SortAndFilter
Scenario Outline: User sorts hotels, enters area from Excel, and applies multiple Most Popular filters
  Given user is on the hotel search results page
  When user opens the Popularity sort dropdown
  And user selects a random sort option
  And user enters area name from Excel using row <row> and column <col>
  And user selects the first area suggestion
  Then hotel results should update based on the selected sort and area
  When user scrolls to the Most Popular filter section
  And user selects a random filter option
  Then hotel results should update based on selected filter
  When user scrolls back to the Most Popular filter section
  And user selects another random filter option
  Then hotel results should update with both filters applied
 
Examples:
  | row | col |
  | 1   | 1   |
  
  
  
  @filterTest
Scenario: User applies filters from User Rating and Star Rating sections
  Given user has completed a hotel search and is viewing the results
  When user scrolls to the User Rating filter section
  And user selects a random option from User Rating
  And hotel results should update based on selected User Rating filter
  And user scrolls to the Star Rating filter section
  And user selects a random option from Star Rating
  Then hotel results should update based on both applied filters
  
  
  @bookNowRedirect
Scenario: Verify Book Now button redirects to the reservation page
  Given user has performed a hotel search and is viewing the search results
  When user clicks on the Book Now button of the first listed hotel
  Then user should be redirected to the reservation page



  #@DateValidation
#Scenario: User tries to select the same date for both check-in and check-out
  #Given user is on Hotels Page
  #When user selects today as the check-in date
  #And user selects the same date as the check-out date
  #Then check-out date should not be accepted
#







