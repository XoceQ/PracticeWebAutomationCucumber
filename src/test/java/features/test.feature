#This is the name of your feature. It provides a high-level description of what the feature is about.
Feature: Test
#  It serves as a template for more concrete scenarios by using examples.
  Scenario Outline: Verify the content of the Wikipedia article for Star Wars Characters
#  this is the initial setup. It sets the context for the test.
#  The <number> is a placeholder that will be replaced by the actual character number during test execution.
    Given I am a user at the Wikipedia WebPage requesting SW character <number>
#  This step represents an action
    When I search for the requested character name on Wikipedia search page
#  This is the verification step.
    Then the information on the article page should match the details from the Star Wars API for the requested character

    Examples:
      | number |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |
