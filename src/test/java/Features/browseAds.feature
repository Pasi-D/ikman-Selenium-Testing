Feature: BrowseSpecificAds
  This feature allows you to browse ikman.lk with three bedrooms and specific price range

  Scenario: Browse the specific ads
    Given I navigate to the webpage
    And I click on the Property link
    And I click on the Houses
    And I click on Colombo
    And I Apply the price range between "5000000" and "7500000"
    And I apply filter button
    And I select number of beds as "3"
    Then I display the number of results
    Then I display all the adds
