@ProductListPage
Feature: Login Page

  @ChooseCategory @Filter
  Scenario Outline: Choose Category and Filter Products
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

    Examples:
      | welcomeText|subCategory|category|categoriesPageTitle|filterPageTitle|filterType|filterValue|
      | Hoş geldin |Bluz       | Giyim  |Kategoriler        |FİLTRE         |Renk      |Siyah      |

