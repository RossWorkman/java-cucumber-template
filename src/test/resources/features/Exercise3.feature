Feature: Trainline Search
  As a Trainline user
  I want to be able to search for journeys from Brighton to London
  So that I can find a range of train tickets to book.

  Scenario Outline: Trainline search
    Given I'm on the https://www.thetrainline.com/ main page
    When I enter the origin station <originStation>
    And I enter the destination station <destinationStation>
    And I select return
    And I select a date in the future
    And I click search button
    Then the train times should be displayed
    And I should have option to change my choices

    Examples:
      | originStation   |   destinationStation     |
      | "Brighton"      |   "London"               |


  Scenario Outline: Multiple people
      Given I'm on the https://www.thetrainline.com/ main page
      When I enter the origin station <originStation>
      And I enter the destination station <destinationStation>
      And I pick 2 Adults and 2 Children
      And I click search button
      Then the train times should be displayed


     Examples:
      | originStation   |   destinationStation     |
      | "Brighton"      |   "London"               |

  Scenario Outline: Same Day Return
      Given I'm on the https://www.thetrainline.com/ main page
      When I enter the origin station <originStation>
      And I enter the destination station <destinationStation>
      And I pick return
      And I choose to return on the same day
      And I choose to return hours later
      And I click search button
      Then the train times should be displayed


     Examples:
      | originStation   |   destinationStation     |
      | "Brighton"      |   "London"               |