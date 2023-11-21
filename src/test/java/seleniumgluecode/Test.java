package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Test {
    private WebDriver driver;

    private SoftAssert softAssert = new SoftAssert();
    private String name;


    // Other methods...

    @Before
    public void setUp() {
        // Initialize WebDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    // Other methods...

    @After
    public void tearDown() {
        // Close the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am a user at the Wikipedia WebPage requesting SW character {int}")
    public void i_am_a_user_at_the_wikipedia_webPage_requesting_sW_character(Integer int1) {
        Response response;
        String url = "https://swapi.dev/api";
        response = RestAssured.given().get(url + "/people/" + int1);
        softAssert.assertEquals(response.getStatusCode(), 200);
        JsonPath jsonPath = response.jsonPath();
        name = jsonPath.get("name");


    }

    @When("I search for the requested character name on Wikipedia search page")
    public void i_search_for_the_requested_character_name_on_wikipedia_search_page() {

        driver.navigate().to("https://www.wikipedia.org/");

        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys(name);

        WebElement button = driver.findElement(By.cssSelector(".pure-button"));
        button.click();

        // Use explicit wait for better synchronization
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mw-page-title-main")));

        softAssert.assertEquals(title.getText(), name);


    }

    @Then("the information on the article page should match the details from the Star Wars API for the requested character")
    public void the_information_on_the_article_page_should_match_the_details_from_the_star_wars_api_for_the_requested_character() {
        softAssert.assertAll();


    }
}
