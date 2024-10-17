package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.PropertiesReader;

import java.io.IOException;


@CucumberOptions(plugin = {"json:target/cucumber-report/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "",
        monochrome = true)


public class TestRunner extends AbstractTestNGCucumberTests {

    public PropertiesReader App_reader = new PropertiesReader();


    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @Parameters({"browserType"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String browser) throws IOException, InterruptedException {

        App_reader.initializePropertyFile();
        if (!browser.equals("param-val-not-found")) {
            App_reader.setProperty("BrowserType", browser);
        }
        logger.info("Starting tests!");
    }

    @AfterClass
    public static void afterClass() throws IOException, InterruptedException {
        logger.info("Tests finished");

    }


}
