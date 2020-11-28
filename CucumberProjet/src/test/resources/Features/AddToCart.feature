Feature: Add to Cart

@AddToCart
Scenario Outline: Verify Add to Cart functionality
Given I am on nopCommerce login page
When I enter <ProductName> in search box
And Click Serch button
And I add item to the Cart
Then Item should added to Cart

Examples:

|ProductName|
|HTC One Mini Blue|
|HTC One M8 Android L 5.0 Lollipop|

@AddToCart
Scenario: Verify RemoveCart functionality
When I click Shopping Cart
And click Remove Check box
And click on Update Shopping Cart
Then Shopping Cart should be empty