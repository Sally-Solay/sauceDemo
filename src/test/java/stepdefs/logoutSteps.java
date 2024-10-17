package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.landingpage.LandingPage;
import pages.loginpage.LoginPage;
import utils.BaseTests;


public class logoutSteps extends BaseTests {

    LoginPage loginPage = new LoginPage(driver);
    LandingPage landingPage = new LandingPage(driver);

    @Test
    @When("I am in Landing page, and I press logout")
    public void i_am_in_landing_page_and_i_press_logout() throws InterruptedException {
        loginPage = landingPage.logOut();

    }

    @Test
    @Then("The user should be logged out successfully")
    public void the_user_should_be_logged_out_successfully() throws InterruptedException {

        loginPage.verifyUserLoggedOutSuccessfully(App_reader_2.getProperty("baseURL"));
    }


}
