Feature: FlairsTECH Task
  Scenario: As a User I want to Submit Automation Task
    Given From Login Page, Enter username
    And Enter Password
    And Click on login button.
    Then Verify that user landed to Home Page
    When From Home Page, Click on Admin Button from left side menu
    And Get the number of records
    When From Admin page, Click on Add button
    And Fill all required fields
    And Click on Save button
    Then Verify that number of records increased by one
    When From User Management Page, Search for Created User
    Then Verify that the user is displayed
    When From User Management Page, Delete created user
    Then Verify that the delete pop is Displayed
    When From Delete pop up, Click on Yes Button
    Then Verify that the number of Users decreased by one

