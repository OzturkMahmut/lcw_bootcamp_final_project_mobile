@ProductPage
Feature: Product Page

  @ChooseCategory @Filter @AddToCart
  Scenario Outline: Add a Product to the Cart
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
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

    Examples:
      | welcomeText|subCategory|category|categoriesPageTitle|filterPageTitle|filterType|filterValue|size|
      | Hoş geldin |Bluz       | Giyim  |Kategoriler        |FİLTRE         |Renk      |Siyah      |M |

