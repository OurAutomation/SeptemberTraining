Feature: I am adding two numbers
  Scenario: Add Two Numbers
#    Given, When, Then ,And
    Given I have two numbers 1,2
    When I add the numbers
    Then The result should be equal to 3

  Scenario: Add numbers
    Given I have two numbers 5,6
    When I add the numbers
    Then The result should be equal to 3

  Scenario: Add numbers equals
    Given I have two numbers 15,61
    When I add the numbers
    Then The result should be equal to 76