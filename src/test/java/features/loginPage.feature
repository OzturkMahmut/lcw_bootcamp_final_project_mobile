@LoginPage
Feature: Login Page

  @Login @CheckComponents @Email
  Scenario Outline: Check Email Components
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Profile" bottom navigation button
    When  User clicks "Email Radio Button" element in login page
    Then  User should see "<loginFormTitle>" text in "Login Form Title" element in login page
    Then  User should see "Email Radio Button" element in login page
    Then  User should see "Phone Radio Button" element in login page
    Then  User should see "Email Input Container" element in login page
    Then  User should see "Password Input Container" element in login page
    Then  User should see "<emailPlaceholder>" text in "Email Input Container" element in login page
    Then  User should see "<passwordPlaceholder>" text in "Password Input Container" element in login page
    Then  User should see "Show Password Icon" element in login page
    Then  User should see "Forgot Password Link" element in login page
    Then  User should see "Login Button" element in login page
    Then  User should see "Sign Up Button" element in login page
    Examples:
      | welcomeText |  loginFormTitle  | emailPlaceholder   | passwordPlaceholder  |
      | Hoş geldin  |  GİRİŞ YAP       | E-Posta Adresiniz  | Şifreniz             |


  @Login @CheckComponents @Phone
  Scenario Outline: Check Phone Components
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Profile" bottom navigation button
    When  User clicks "Phone Radio Button" element in login page
    Then  User should see "<loginFormTitle>" text in "Login Form Title" element in login page
    Then  User should see "Email Radio Button" element in login page
    Then  User should see "Phone Radio Button" element in login page
    Then  User should see "Phone Number Input Container" element in login page
    Then  User should see "Password Input Container" element in login page
    Then  User should see "<emailPlaceholder>" text in "Email Input Container" element in login page
    Then  User should see "<passwordPlaceholder>" text in "Password Input Container" element in login page
    Then  User should see "Show Password Icon" element in login page
    Then  User should see "Forgot Password Link" element in login page
    Then  User should see "Login Button" element in login page
    Then  User should see "Sign Up Button" element in login page
    Examples:
      | welcomeText |  loginFormTitle  | emailPlaceholder   | passwordPlaceholder  |
      | Hoş geldin  |  GİRİŞ YAP       | E-Posta Adresiniz  | Şifreniz             |

  @SuccessfulLogin
  Scenario Outline: Successful Login
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Profile" bottom navigation button
    Then  User should see "<loginFormTitle>" text in "Login Form Title" element in login page
    Then  User should see "Email Radio Button" element in login page
    Then  User should see "Phone Radio Button" element in login page
    Then  User should see "Email Input Container" element in login page
    Then  User should see "Password Input Container" element in login page
    Then  User should see "<emailPlaceholder>" text in "Email Input Container" element in login page
    Then  User should see "<passwordPlaceholder>" text in "Password Input Container" element in login page
    Then  User should see "Show Password Icon" element in login page
    Then  User should see "Forgot Password Link" element in login page
    Then  User should see "Login Button" element in login page
    Then  User should see "Sign Up Button" element in login page
    When  User fills out the "Email" input container with  "<emailInput>" in login page
    When  User fills out the "Password" input container with  "<passwordInput>" in login page
    When  User clicks "Login Button" element in login page
    When  User clicks "Profile" bottom navigation button
    When  User should see "<name>" text in "Full Name" element in profile page
    Examples:
      | welcomeText |  loginFormTitle  | emailPlaceholder   | passwordPlaceholder  |emailInput  |passwordInput|name|
      | Hoş geldin  |  GİRİŞ YAP       | E-Posta Adresiniz  | Şifreniz             |vba98041@zcrcd.com  |3ZxP9PEkn2tYQad|Ad Soyad|
