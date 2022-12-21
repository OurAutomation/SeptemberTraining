Feature: Validating the login functionality with invalid credentials

  @Sanity @Smoke
  Scenario: Validate login with invalid user
    Given user loads the application
    When user login with username "invalid" and password "invalid"
    Then user should not be logged in
    Then error message should be displayed as "Epic sadface: Username and password do not match any user in this service"

  @Regression @Smoke
  Scenario: Validate login with no password
    Given user loads the application
    When user login with username "performance_glitch_user" and password ""
    Then user should not be logged in
    Then error message should be displayed as "Epic sadface: Password is required"

  @Regression
  Scenario Outline: Validate login with different invalid testdata
    Given user loads the application
    When user login with username "<username>" and password "<password>"
    Then user should not be logged in
    Then error message should be displayed as "<errorMessage>"
    Examples:
      | username                | password     | errorMessage                                        |
      | performance_glitch_user | Test@123     | Epic sadface: Password is required                  |
      | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
      |                         | Test@123     | Epic sadface: Username is required                  |