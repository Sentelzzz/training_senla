package test.cucumber;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "cucumberSteps",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class CreateBirthCertificateTest {
}
