package stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import testrunner.TestRunner;
import utils.*;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.OutputType.BYTES;
import static utils.FileUtils.fileSeparator;


public class Hooks extends BaseTests {

    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    public static BaseTests base = new BaseTests();


    @Before
    public void beforeScenario(final Scenario scenario) throws IOException, InterruptedException {
        base.setupBrowser();
        base.openUrl();
        logger.info("Starting scenario: " + scenario.getName());
    }


    @After
    public void afterScenario(final Scenario scenario) throws  IOException, InterruptedException {

        takeScreenshot(scenario);
        logger.info("Finished scenario: " + scenario.getName());
        base.tearDown();
    }


    public void takeScreenshot(final Scenario scenario) throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        byte[] screenshot = camera.getScreenshotAs(BYTES);
        scenario.attach(screenshot, "image/png", scenario.getStatus() + " - " +
                CucumberUtils.getFeatureName(scenario) + ": " + scenario.getName());
        File sourceFile = camera.getScreenshotAs(OutputType.FILE);
        String destinationPath = "target" + fileSeparator + "screenshots" + fileSeparator +
                baseOutputFileStruct(scenario) + fileSeparator + scenario.getStatus() + ".png";
        FileUtils.copyFile(sourceFile.getPath(), destinationPath);
    }

    private  String baseOutputFileStruct(final Scenario scenario) {
        return CucumberUtils.getFeatureName(scenario) + fileSeparator + scenario.getName();
    }

}
