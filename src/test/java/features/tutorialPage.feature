@WelcomePage
Feature: Welcome Page

  @Check @Components
  Scenario: Check Tutorial Page Components
    Given User opens LcWaikiki App
    When  User should see "Tv Tutorials" element in tutorial page
    When  User should see "Discover New Feature" element in tutorial page
    When  User should see "New Bottom NavBar Info Title" element in tutorial page
    When  User should see "New Bottom NavBar Info" element in tutorial page
    When  User should see "Skip Button" element in tutorial page


  @Skip
  Scenario Outline: Click Skip Button
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    Examples:
      | welcomeText             |
      | Hoş geldin |



