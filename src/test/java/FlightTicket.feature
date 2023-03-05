Feature: Search Flight Ticket

  Scenario: Search flight ticket
    Given I have obiletcom main page
    And Click flight tab
    And Check the url
    And Fill the from, departDate, to, returnDate fields on the flight searching form
    And Click find a flight ticket button
    And Choose departure
    And Choose return
    Then Checkout page is opened
    And Check information on the checkout page




