# PracticeWebAutomationCucumber

API + Web Automation Complementary practice


QC Basics Reference


In this practice, we are going to join and complement the concepts of java + Selenium + Rest Assured + Cucumber. If you need to review in greater detail what is Cucumber for, check the following article: 👉https://cucumber.io/docs/guides/overview/

For this practical exercise we need to start by creating a maven java project (use the standard archetype used previously) And include the dependencies used in order to work with Java, TestNG, and Selenium. Additionally, Add the cucumber dependency and configure cucumber into your framework. Here you can find a guide for installing cucumber into your project https://cucumber.io/docs/installation/java/ and here the guide for configuring it and creating your first scenarios https://www.browserstack.com/guide/automation-using-cucumber-selenium (Consider this last guide does not include Page Object Model implementation, however you should use POM into your framework)

Now we have our framework created and configured, let’s start by creating some scenarios.  Remember a scenario is the same as a Test Case, but in BDD Syntax. Create the following scenarios into your framework:

Create a Scenario Outline, to request the Star Wars API (https://swapi.dev/) on it’s /people/ service (example https://swapi.dev/api/people/1) , get the name of the character, search for it on wikipedia web page , and make the needed assertions to check if the character page is displayed correctly (Example: the name of the wikipedia page matches the name of the character, the side bar and nave bars are displayed, and the page sections are also displayed). The scenario should look like this (steps maybe written differently): Scenario Outline : Check wikipedia article displayed for Star Wars Characters Given I am an user at the Wikipedia WebPage requesting SW character <number> When I search the requested character name on Wikipedia search page Then I should be able to see the article page correctly displayed for the requested character. Examples |1| |2| |3| |4| |5| The examples should cover the first 5 characters available on the characters service. More information on scenario outlines here: https://cucumber.io/docs/gherkin/reference/#scenario-outline

Create a scenario to request for a random movie movie using theStar Wars API (Consider only 6 movies are available on the API services, and create a method to request one of them randomly) , search for this movie on wikipedia web page, go to the article page and click on the Edit Link. Check the edit page is displayed correctly, including the matching of the title for the article page (Example, if the page is for “The empire strikes back, the title of the Edit page should include “Edición de The Empire Strikes Back”).

Test
Create a scenario to request for a random movie movie using theStar Wars API (Consider only 6 movies are available on the API services, and create a method to request one of them randomly) , search for this movie on wikipedia web page, go to the article page and click on the Ver Historial Link. Check the History page is displayed correctly, including the matching of the title for the article page (Example, if the page is for “The empire strikes back, the title of the History Page page should include “Historial de The Empire Strikes Back”)

Test
📌Notes: 

Remember using the Page Object Model for this practice, the Page Objects should work exactly the same as in previous practices, however the Test layer would be different, with the step definitions calling the respective page object methods.

You can use hooks in order to manage preconditions on your tests, working similar to the Before and After Annotations on TestNG. More information on cucumber hooks here: https://cucumber.io/docs/cucumber/api/?lang=java#hooks
