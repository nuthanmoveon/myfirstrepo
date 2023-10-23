Feature: Verify Different GET operations uisng REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/post"
    And I perform GET for the post number 2
    Then I should see the author name as "Paddu"
