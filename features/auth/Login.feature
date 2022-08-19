@testAll
Feature: Login
  As a user i want to be able to login into our portal

  Scenario: Do the login with correct credentials
    Given i am in the login page
    Then i want to login with "diogo.brandao@gmail.com" and "Fake_Password"