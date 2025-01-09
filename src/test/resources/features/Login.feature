

@smokefeature
Feature: Login
@smoketest
  Scenario: Successfully login with valid credentials
    Given User is on login page
    When User enter username and password
    And Clicks on login button
    Then Clicks on location


  @skip
  Scenario: cart page
    Given click on start session
    When navigate to cart page


  @sanity
  Scenario: product page
    Given click on add customer details
    When click on product details
    And add on product
    Then Enter the product details

  @regression
  Scenario: Order page
    Given click on total
    When enter total amount
    And click on pay
    Then click on continue button




