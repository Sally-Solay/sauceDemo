package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import pages.landingpage.LandingPage;
import pages.loginpage.LoginPage;
import testrunner.TestRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class BaseTests {
    protected static WebDriver driver;

    public PropertiesReader App_reader_2 = new PropertiesReader();



    static LoggingPreferences logPrefs = new LoggingPreferences();



    public void setupBrowser() throws InterruptedException, IOException{
        if (App_reader_2.getProperty("BrowserType").equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            logPrefs.enable(LogType.CLIENT, Level.ALL);
            logPrefs.enable(LogType.DRIVER, Level.ALL);
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            logPrefs.enable(LogType.SERVER, Level.ALL);
            chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
        }

        if (App_reader_2.getProperty("BrowserType").equalsIgnoreCase("Firefox")) {
            FirefoxOptions firfoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            logPrefs.enable(LogType.CLIENT, Level.ALL);
            logPrefs.enable(LogType.DRIVER, Level.ALL);
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            logPrefs.enable(LogType.SERVER, Level.ALL);
            firfoxOptions.setCapability("goog:loggingPrefs", logPrefs);
        }

        if (App_reader_2.getProperty("BrowserType").equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            logPrefs.enable(LogType.CLIENT, Level.ALL);
            logPrefs.enable(LogType.DRIVER, Level.ALL);
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            logPrefs.enable(LogType.SERVER, Level.ALL);
            edgeOptions.setCapability("goog:loggingPrefs", logPrefs);


        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    public void openUrl() throws  InterruptedException, IOException {
        driver.get(App_reader_2.getProperty("baseURL"));
        Thread.sleep(2000);
    }




    public void tearDown() throws  InterruptedException, IOException {
        driver.quit();
    }


}

