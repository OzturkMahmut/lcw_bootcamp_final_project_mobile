@CategoriesPage
Feature: Categories Page

  @ChooseCategory
  Scenario Outline: Choose a Category
    Given User opens LcWaikiki App
    When  User clicks "Skip Button" element in tutorial page
    Then  User should see "<welcomeText>" text in "Welcome Header" element in homepage
    When  User clicks "Categories" bottom navigation button
    Then  User should see "<categoriesPageTitle>" text in "Page Title" element in categories page
    When  User clicks "Kadın" element in categories page
    When  User clicks "<subCategory>" subcategory in "<category>" category in categories page
    Examples:
      | welcomeText|subCategory|category|categoriesPageTitle|
      | Hoş geldin |Bluz       | Giyim  |Kategoriler        |





