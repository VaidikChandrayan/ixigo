Feature: Ixigo Flight Search Module
 
Background:
     Given User is logged into Ixigo application
     And User is on the flight search page

@oneway
Scenario: Search one-way flight with valid details
When User selects one way trip
And User enters city in the From field
And User enters city in the To field
And User selects a future departure date
And User clicks on Search flights
Then User is redirected to result page with available flights  


@roundtrip
Scenario: Search round-trip flight with valid details
When User selects the round trip
And User enters city name in the From field
And User enters city name in the To field
And User selects a departure date
And User selects a future return date
And User clicks on the Search flights
Then User is redirected to result page with the available flights  