@testAll
  Feature: As a User a want to see the account details of my account

    Scenario Outline: Account Details
      Given i am in the login page
      And i want to login with "<username>" and "<password>"
      Then i press the Submit button
      And user is on dashboard
      Then user selects one account
      And user is on account details of that account


      @test
      Examples:
        | username | password |
        | bango.group | bango.group|