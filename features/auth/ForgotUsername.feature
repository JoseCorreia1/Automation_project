@testAll @retail
Feature: Login - Forgot Username
  As a user i want to be able to reset my username when i forget it

  Scenario Outline: Login - Forgot Username
    Given i am in the login page
    And i click on forgot username
    Then im redirected to forgot username screen
    Then i write my "<email>" address on the field
    And i click on the confirm e-mail address
    Then im redirected to the login screen with a success message showing the email that was sent

    @test
    Examples:
      | email |
      | jose.correia@bringglobal.com |