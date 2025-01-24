Feature: Search functionality
  As a user
  I want to use the search functionality
  So that I can find specific products on the website

  Background:
    Given  the browser is launched and "https://dressup.ge/ka/" login page is opened

  Scenario: Verify search functionality with a valid keyword
    When the user enters "Gant - Terry Cloth Piqué Polo Shirt" in the search field
    And the user clicks the search button
    Then the user should see search results containing "Gant - Terry Cloth Piqué Polo Shirt"

  Scenario: Verify search functionality with invalid input
    When the user enters "-------+++++" in the search field
    And the user clicks the search button
    Then the user should see a message indicating "პროდუქტი არ არის."

  Scenario: Add product to wishlist asks for login
    When the user enters "Gant - Terry Cloth Piqué Polo Shirt" in the search field
    And the user clicks the search button
    Then the user adds the "Gant - Terry Cloth Piqué Polo Shirt" to the wishlist
    Then the user should see a login prompt with "Google ავტორიზაცია" button displayed

  Scenario:Scenario: Log in, search for a product and add it to the wishlists
    When the user clicks on the "ავტორიზაცია" button
    And the user enters "xewovi7716@kurbieh.com" in the email field and "account2026" in the password field
    And clicks the Authorization button
    When the user enters "Gant - Terry Cloth Piqué Polo Shirt" in the search field
    And the user clicks the search button
    Then the user adds the "Gant - Terry Cloth Piqué Polo Shirt" to the wishlist

  Scenario: Log in, search for a product and click the specific one
    When the user clicks on the "ავტორიზაცია" button
    And the user enters "jicega9901@suggets.com" in the email field and "account2025" in the password field
    And clicks the Authorization button
    When the user enters "Gant - Terry Cloth Piqué Polo Shirt" in the search field
    And the user clicks the search button
    Then Quick see the "Gant - Terry Cloth Piqué Polo Shirt" product


















