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
