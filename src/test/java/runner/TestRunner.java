package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/*
which indicates that this class should be run with Cucumber.
*/

@RunWith(Cucumber.class)

/*The features parameter specifies the path to the directory containing the feature files,
        and the glue parameter specifies the package where the step definitions are located*/

@CucumberOptions(
        features="src/test/java/features",
        glue={"seleniumgluecode"}

)

public class TestRunner {

}