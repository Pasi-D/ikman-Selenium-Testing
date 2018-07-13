package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Pasindu\\IdeaProjects\\ikmanBDD\\src\\test\\java\\Features\\browseAds.feature"
        ,glue = {"Steps"}
        ,format={"pretty","html:target/cucumber"}
)

public class TestRunner_ikman {
}
