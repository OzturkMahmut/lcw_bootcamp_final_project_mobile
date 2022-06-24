@SignUpPage
Feature: Sign Up Page

  @CheckSignUpFormElements
  Scenario Outline: Check Sign Up Form Elements
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Profile" bottom navigation button
    Then  User should see "<loginFormTitle>" text in "Login Form Title" element in login page
    When  User clicks "Sign Up Button" element in login page
    Then  User should see "<signUpFormTitle>" text in "Sign Up Form Title" element in sign-up page
    Then  User should see "Email Input Container" element in sign-up page
    Then  User should see "Password Input Container" element in sign-up page
    Then  User should see "Show Password Icon" element in sign-up page
    Then  User should see "Phone Number Input Container" element in sign-up page
    Then  User should see "Email CheckBox " element in sign-up page
    Then  User should see "Call CheckBox " element in sign-up page
    Then  User should see "SMS CheckBox " element in sign-up page
    Then  User should see "Register Info Container " element in sign-up page
    Then  User should see "Terms of Use CheckBox " element in sign-up page
    Then  User should see "Clarification Text " element in sign-up page
    Then  User should see "Sign Up Button " element in sign-up page
    Then  User should see "Login Button " element in sign-up page
    Examples:
      | welcomeText | loginFormTitle | signUpFormTitle |
      | Hoş geldin    | GİRİŞ YAP      |    ÜYE OL       |


  @SignUp @FillOutForm
  Scenario Outline: New User Registration
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Profile" bottom navigation button
    Then  User should see "<loginFormTitle>" text in "Login Form Title" element in login page
    When  User clicks "Sign Up Button" element in login page
    Then  User should see "<signUpFormTitle>" text in "Sign Up Form Title" element in sign-up page
    When  User fills out the "Email" input container with  "<emailInput>" in sign up page
    When  User fills out the "Password" input container with  "<passwordInput>" in sign up page
    When  User fills out the "Phone Number" input container with  "<phoneNumberInput>" in sign up page
    When  User checks "Terms of Use" checkbox in sign-up page
    When  User clicks  "Sign Up Button" element in sign-up page
    Then  User should see "<popUpTitle>" text in "Phone Confirmation Pop Up" element in sign-up page
    Then  User should see "<phoneNumberInput>" text in "Phone Confirmation Pop Up Description" element in sign-up page
    Then  User should see "Complete Sign Up Button" element in sign-up page
    Examples:
      | welcomeText | loginFormTitle | signUpFormTitle | emailInput           |passwordInput |phoneNumberInput  |popUpTitle|
      | Hoş geldin  |    GİRİŞ YAP   |      ÜYE OL     | seday30647@gmail.com |12345678a      |5234567890       |TELEFON DOĞRULAMA KODU|