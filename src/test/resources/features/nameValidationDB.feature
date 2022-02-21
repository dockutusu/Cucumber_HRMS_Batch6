Feature: Name and Last Name validations against DB

  Scenario: Firstname validation against DB
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "14688"
    And click on search button
    Then verify table is displayed
    And get first name from table
    When get first name from db
    Then validate first name from ui against db

  Scenario: Firstname validation against DB
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "14688"
    And click on search button
    Then verify table is displayed
    And get last name from table
    When get last name from db
    Then validate last name from ui against db
    
      Scenario: Firstname validation against DB
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "14999"
    And click on search button
    Then verify table is displayed
    And get first name from table
    When get first name from db
    Then validate first name from ui against db
    
    
