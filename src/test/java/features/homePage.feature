@HomePage
Feature: Home Page

  @NavigationButtons
  Scenario Outline: Check Navigation Buttons
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User should see "Homepage" bottom navigation button
    When  User should see "Categories" bottom navigation button
    When  User should see "MyCart" bottom navigation button
    When  User should see "Favorites" bottom navigation button
    When  User should see "Profile" bottom navigation button
    Then should see "Anasayfa" selected navigation button
    Examples:
      | welcomeText |
      | Hoş geldin  |




