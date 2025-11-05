
@Smoke
Feature: Login functionality on OpenMRS

    Scenario: Successful login with valid credentials
    Given the user is on the OpenMRS login page
    When the user enters valid username
    And the user enters valid password
    And clicks the login button
    Then the user should be redirected to the home page
        