Feature: Create New Account


  Scenario: Opening main page
    Given I have obiletcom main page
    Then I accessed the main page successfully

  Scenario Outline: Register
    Given I have obiletcom main page
    And Click member login button
    And Click register button
    And Fill "<email>" email address input
    And Fill "<password>" password input
    And Check Clarification Text checkbox is selected
    When Click submit button
    Then I registered successfully
    Examples:
    |email|password|
    |mutlubiyemek@gmail.com| vildan12345|


  Scenario: Unsuccessful Register 1
    Given I have obiletcom main page
    And Click member login button
    And Click register button
    And Leave email input empty
    And Leave password input empty
    When Click submit button
    Then Email error message displayed
    Then Password error message displayed


  Scenario Outline: Unsuccessful Register 2
    Given I have obiletcom main page
    And Click member login button
    And Click register button
    And Fill "<email>" email address input
    And Fill "<password>" password input
    When Click submit button
    Then Error message displayed
    Examples:
      |email|password|
      |vildan343@hotmail.com|  abed1234|



