package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.landingpage.LandingPage;
import pages.loginpage.LoginPage;
import utils.BaseTests;



public class loginSteps extends BaseTests {


    LoginPage loginPage = new LoginPage(driver);
    LandingPage landingPage = new LandingPage(driver);
    SoftAssert softassert = new SoftAssert();

    @Test
    @Given("I have navigated to saucedemo website")
    public void i_have_navigated_to_saucedemo_website() {
        softassert.assertEquals(driver.getCurrentUrl(), App_reader_2.getProperty("baseURL"));
    }

    @Test
    @When("I enter the required fields and press Login")
    public void i_enter_the_required_fields_and_press_login() {
        landingPage = loginPage.login(App_reader_2.getProperty("UserName"),App_reader_2.getProperty("Password") );

    }

    @Test
    @Then("I should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        landingPage.verifyTheuserloggedInSuccessfully(App_reader_2.getProperty("landing_page_URL"));
    }
}
