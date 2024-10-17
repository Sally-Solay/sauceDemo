package pages.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import pages.landingpage.LandingPage;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    SoftAssert softassert = new SoftAssert();


    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn= By.id("login-button");



    public LandingPage login(String user_name, String pass_word){
        driver.findElement(username).sendKeys(user_name);
        driver.findElement(password).sendKeys(pass_word);
        driver.findElement(loginBtn).click();
        return new LandingPage(driver);
    }

    public void verifyUserLoggedOutSuccessfully(String url){
        String currentURl = driver.getCurrentUrl();

        softassert.assertEquals(currentURl, url);
        softassert.assertTrue(driver.findElement(username).isDisplayed());
        softassert.assertAll();

    }

}
