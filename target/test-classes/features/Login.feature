Feature: Login

  Scenario: valid admin login
    Given user is navigated to HRMS
    When user enter valid admin username and password
    And user click on login button
    Then admin user is successfully logged in

  Scenario: valid ess login
    Given user is navigated to HRMS
    When user enter valid ess username and password
    And user click on login button
    Then ess user is successfully logged in

  Scenario: Login with valid username and invalid password
    Given user is navigated to HRMS
    When User enter valid username and invalid password
    And user click on login button
    Then User see Invalid Credentials text on login page