Feature: US-12345 Employee search

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    When user navigates to Employee list page


  @regression
  Scenario: Search Employee by ID
    When user enters valid employee Id
    And user clicks on search button
    Then user see employee information is displayed


  @regression
  Scenario: Search Employee by name

    When user enters valid employee name
    And user clicks on search button
    Then user see employee information is displayed



