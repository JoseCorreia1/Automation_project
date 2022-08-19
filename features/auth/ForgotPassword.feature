@testAll @retail
Feature: Login - Forgot Password
  As a user i want to be able to reset my password when i forget it

  Scenario Outline: Login - Forgot Password
    Given i am in the login page
    And i click on forgot password
    Then im redirected to forgot password screen
    Then i write my "<email>" address
    And i click on confirm e-mail address
    Then im redirected to the login screen with a success message

  @test
    Examples:
      | email |
      | jose.correia@bringglobal.com |