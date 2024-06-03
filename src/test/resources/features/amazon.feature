Feature: Amazon Cart Functionality

  Scenario: Adding a Monitor Item in Cart and verifying sub total
    Given I open Amazon homepage
    When I search for "Monitor"
    And I select the first item in the list
    And I add the item to cart
    Then I verify the cart price is same as product page price
    And I verify the cart subtotal is same as product page price

  Scenario: Adding a Laptop Item in Cart and verifying sub total
    Given I open Amazon homepage
    When I search for "Laptop"
    And I select the second item in the list
    And I add the item to cart
    Then I open the cart
    And I verify the cart price is same as product page price
    And I verify the cart subtotal is same as product page price

  Scenario: Adding two items in Cart and verifying sub total
    Given I open Amazon homepage
    When I search for "Headphones"
    And I select the first item in the list
    And I add the item to cart
    When I search for "Keyboard"
    And I select the first item in the list
    And I add the item to cart
    Then I open the cart
    And I verify each item total price is correct
    And I verify the subtotal is calculated correctly
