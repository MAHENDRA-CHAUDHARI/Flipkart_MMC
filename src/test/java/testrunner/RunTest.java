package testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		         features="src/test/resources/BUSINESS_LOGIC/CUCUMBER_SUITES",
		         tags="@SmokeTest",
		         glue="cucumbermap",
		         monochrome=true,
		         plugin="pretty"
		)


public class RunTest
{
               
}
