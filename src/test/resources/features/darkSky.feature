@web @regression @darkSky
  Feature: Verify current temperature

    Background:
      Given I am on Darksky Home Page

      @darksky-1
        Scenario: Verify current Temperature should not be greater or less than the temperature from Daily Timeline
        When  I verify current temp is not greater or less then temps from daily timeline

      @darksky-2
        Scenario: Verify timeline is displayed in correct format
        When I verify timeline is displayed with two hours incremented

      @darksky-3
        Scenario: Verify individual day temperature timeline
        When I expand today's timeline
        Then I verify lowest and highest temp is displayed correctly

      @darksky-4
      Scenario: Verify invalid Signup error message
        When I click on darksky API
        And I click on darksky Sign Up
        Then I verify I am on register page by asserting Register header
