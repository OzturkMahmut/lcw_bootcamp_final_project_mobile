@FullScenario
Feature: Full Scenario

  @OrderAProduct
  Scenario Outline: Login, Filter Products, Add a Product to the Cart, Complete the Order
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Profile" bottom navigation button
    Then  User should see "Email Radio Button" element in login page
    Then  User should see "Phone Radio Button" element in login page
    Then  User should see "Email Input Container" element in login page
    Then  User should see "Password Input Container" element in login page
    Then  User should see "Show Password Icon" element in login page
    Then  User should see "Forgot Password Link" element in login page
    Then  User should see "Login Button" element in login page
    Then  User should see "Sign Up Button" element in login page
    When  User fills out the "Email" input container with  "<emailInput>" in login page
    When  User fills out the "Password" input container with  "<passwordInput>" in login page
    When  User clicks "Login Button" element in login page
    When  User clicks "Categories" bottom navigation button
    Then  User should see "<categoriesPageTitle>" text in "Page Title" element in categories page
    When  User clicks "Kadın" element in categories page
    When  User clicks "<subCategory>" subcategory in "<category>" category in categories page
    Then  User should see "<subCategory>" text in "Page Title" element in productList page
    When  User clicks "Filtre" element in productList page
    Then  User should see "<filterPageTitle>" text in "Page Title" element in productList page
    When  User filters "<filterType>" of the products by "<filterValue>" in productList page
    When  User clicks the 1. item in the product list
    Then  User should see "Product Image" element in product page
    Then  User should see "Close Button" element in product page
    Then  User should see "Expand Button" element in product page
    Then  User should see "Product Name" element in product page
    Then  User should see "Product Price" element in product page
    Then  User should see "Add Favorites Button" element in product page
    Then  User should see "Share Button" element in product page
    Then  User should see "AddToCart Button" element in product page
    When  User clicks the "Expand Button" element in product page
    Then  User should see "Size Options" element in product page
    When  User chooses "<size>" size in product page
    When  User clicks the "AddToCart Button" element in product page
    Then  User should see "GotoCart Pop Up" element in product page
    When  User clicks the "GotoCart Button" element in product page
    Then  User should see "<cartPageTitle>" text in "Page Title" element in cart page
    Then  User should see "Product Name" element in cart page
    Then  User should see "Product Code" element in cart page
    Then  User should see "Product Quantity" element in cart page
    Then  User should see "Product Size" element in cart page
    Then  User should see "Complete Order Button" element in cart page
    Then  User should see "Product Price" element in cart page
    Then  User should see "Clear Basket Button" element in cart page
    Then  User should see "Grand Total" element in cart page
    Then  User should see "Apply Coupon Button" element in cart page
    Then  User should see "Apply Coupon Input Area" element in cart page
    Then  User should see "Close Button" element in cart page
    Then  User should see "Order Summary" element in cart page
    Then  User should see "<filterValue>" text in "Product Color" element in cart page
    When  User clicks "Complete Order Button" element in cart page
    Then  User should see "Delivery Type Selection Card" element in checkout page
    Examples:
      | welcomeText|subCategory|category|categoriesPageTitle|filterPageTitle|filterType|filterValue|size|cartPageTitle||emailInput  |passwordInput|
      | Hoş geldin |Bluz       | Giyim  |Kategoriler        |FİLTRE         |Renk      |Siyah      |M |Sepetim||vba98041@zcrcd.com  |3ZxP9PEkn2tYQad|

