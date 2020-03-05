Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User is on Home Page
    And Dismiss Link is deleted First
    When User Navigate to LogIn Page
    And User enters Credentials to LogIn
      | test_userjd5 | B0gz0123! |
    Then Message displayed Login Successfully

  Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
