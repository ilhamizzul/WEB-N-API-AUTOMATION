Feature: Product N Cart

  Scenario: Verify product Page is loaded properly
    Given the user is on the main page
    Then product page component is loaded properly

  Scenario: User see product detail
    Given the user is on the main page
    When user click certain product
    Then detail product page is shown

