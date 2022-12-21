Feature: Validating the login functionality with valid credentials

  @Sanity @Smoke
  Scenario: Validate login with standard user
    Given user loads the application
    When user login with username "standard_user" and password "secret_sauce"
    Then user should be logged in
    Then user should be able to see products logo
    Then user should be able to see checkout button

  @Regression
  Scenario: Validate login with performance user
    Given user loads the application
    When user login with username "performance_glitch_user" and password "secret_sauce"
    Then user should not be logged in
    Then user should be able to see products logo
    Then user should be able to see checkout button