package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/featureFilesCucumber",
        glue = "stepsDefinitionCucumber"

)

public class testRunner extends AbstractTestNGCucumberTests {


}
