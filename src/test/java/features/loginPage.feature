@LoginPage
Feature: Login Page

  @Skip
  Scenario Outline: Click Skip Button
    Given User opened LcWaikiki App
    When click Skip button
    Then should see Welcome Header "<title>"
    Examples:
      | title      |
      | Hoş Geldin |


  @FalseLogin @EmptyLogin
  Scenario Outline: False Login
    Given User opened LcWaikiki App
    When click Skip button
    Then should see Welcome Header "<title>"
    When click Profile
    Then should see "email" input form
    Then should see "password" input form
    Then should see login button
    Then should see signup button
    Then should see form title
    When click login button
    Then should see "<error>"
    When click "email" input form
    When click "password" input form
    When click login button
    Then should see "<emailError>" email error
    Then should see "<passwordError>" password error
    Examples:
      | title      | error       |emailError       |passwordError       |
      | Hoş geldin |   E-posta adresinizi ya da şifrenizi kontrol ediniz    |Lütfen geçerli bir e-posta adresi giriniz.|Lütfen şifre giriniz.    |
