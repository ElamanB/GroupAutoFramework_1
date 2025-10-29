Feature: Basic functionality test scenarios

  @loginDemo
  Scenario: check log in is successful
    Given user is on the Login page
    When user provides a valid username
    And user provides a valid password
    And user clicks on loginbutton
    Then verify user successfuly logged in
