@WelcomePage
Feature: Welcome Page

  @Check @Components
  Scenario Outline: Check Tutorial Page Components
    Given User opened LcWaikiki App
    Then should see TvTutorials
    Then should see "<text>" text
    Then should see "<title>" title
    Then should see "<desc>" title description
    Then should see "<button>" button
    Examples:
      | text             | title           | desc               | button  |
      | Yeniliği Keşfet  | Pratik Alt Menu | Yenilenen Alt Menü | Atla    |


  @Skip
  Scenario Outline: Click Skip Button
    Given User opened LcWaikiki App
    When click Skip button
    Then should see Home Page "<title>"
    Examples:
      | title             |
      | KATEGORİ GÖRÜNÜMÜ |



