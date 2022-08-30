@testAll
Feature:  As a user i want to be able to login into our portal

  Scenario Outline: Do the login with correct credentials
    Given i am in the login page
    And i want to login with "<username>" and "<password>"
    Then i press the Submit button
    And user is on dashboard

  @test
    Examples:
      | username | password |
      | bango.group | bango.group|

  #@uxt
    #Examples:
      #| username | password |
      #| uxt.company | Fake_Password_UXT |

  #@uat
    #Examples:
      #| username | password |
      #| uat.company | Fake_Password_UAT |

  #Scenario Outline: Do the login with wrong credentials
    #Given i am in the login page
    #Then i want to login with "<username>" and "<password>"

  #@test
    #Examples:
      #| username | password |
      #| real1 | Password1* |

  #@uxt
    #Examples:
      #| username | password |
      #| real1 | Password1* |

  #@uat
    #Examples:
      #| username | password |
      #| real1 | Password1* |