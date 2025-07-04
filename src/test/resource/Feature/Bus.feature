Feature: Ixigo Bus Search Module
 
Background:
     Given User is logged into Ixigo application
     And User is on the Bus search page


  Scenario: User enters source, destination, selects date, and searches for buses
    Given I open the Ixigo bus website
    When I enter "Pune" as the source city
    And I enter "Mumbai" as the destination city
    And I select a travel date
    And I click on the Search button
    Then I should see a list of available bus options

 #Feature: Validate bus search input on ixigo.com
#
#Background:
  #Given I open "https://bus.ixigo.com/"
#
#Scenario: Source is blank
  #When I leave source blank and enter "Mumbai" as destination
  #And I click on "Search Buses"
  #Then I should see error "Please enter source city"
#
#Scenario: Destination is blank
  #When I enter "Delhi" as source and leave destination blank
  #And I click on "Search Buses"
  #Then I should see error "Please enter destination city"
#
#Scenario: Invalid source city
  #When I enter "XyzCity" as source and "Mumbai" as destination
  #And I click on "Search Buses"
  #Then I should see error "City not found, please try again"
#
#Scenario: Invalid destination city
  #When I enter "Delhi" as source and "AbcTown" as destination
  #And I click on "Search Buses"
  #Then I should see error "City not found, please try again"