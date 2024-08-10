package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeaturesFile/find_frames.feature",
        //tags={"@test1","@test2", "@test2", "@test3", "@test4","@test5","@test6","@test7","@test8"},
        glue = {"stepdef"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner {
}


