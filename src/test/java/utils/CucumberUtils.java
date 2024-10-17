package utils;

import io.cucumber.java.Scenario;

public class CucumberUtils {

    public static String getFeatureName(final Scenario scenario) {
        String currentFeature = scenario.getUri().toString().substring(scenario.getUri().toString().lastIndexOf("/"), scenario.getUri().toString().indexOf(".feature"));
        return currentFeature.substring(1);
    }

}
