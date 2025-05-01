Feature: Product N Cart

  Scenario: Verify product Page is loaded properly
    Given the user is on the main page
    Then product page component is loaded properly

  Scenario: User see product detail
    Given the user is on the main page
    When user click certain product
    Then detail product page is shown

  Scenario: User add product to cart
    Given the user is on the main page
    When user click certain product
    And user click add product to cart
    Then product is added to cart notification is shown
    And added product exist in cart page

  Scenario Outline: User add multiple product
    Given the user is on the main page
    When user want to add "<items>" items on cart
    Then added product exist in cart page
    Examples:
    | items |
    | 2     |
    | 3     |
    | 4      |

