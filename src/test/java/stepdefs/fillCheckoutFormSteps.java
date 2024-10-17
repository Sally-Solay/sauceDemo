package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.landingpage.LandingPage;
import pages.shoppingcartpage.CartPage;
import utils.BaseTests;

public class fillCheckoutFormSteps extends BaseTests {


    LandingPage landingPage = new LandingPage(driver);

    CartPage cartPage;


    @Test
    @Given("I Navigate to the shopping cart")
    public void i_navigate_to_the_shopping_cart() {
        cartPage = landingPage.navigateToCartPage();
    }


    @Test
    @When("I fill the required fields and press checkout")
    public void i_fill_the_required_fields_and_press_checkout() {
        cartPage.clickCheckoutBtn();
        String fNme = App_reader_2.getProperty("checkOut_firstName");
        String lNme = App_reader_2.getProperty("checkOut_lastName");
        String pCode = App_reader_2.getProperty("checkOut_pCode");
        cartPage.fillCheckoutForm(fNme, lNme, pCode);
    }

    @Test
    @Then("I should see the checkout overview and finish the process")
    public void i_should_see_the_checkout_overview_and_finish_the_process() {
        cartPage.continueCheckoutForm();
        cartPage.verifyTotalisZero();
    }

    @Test
    @Then("I should see the checkout overview and cancel the process")
    public void i_should_see_the_checkout_overview_and_cancel_the_process() {
        cartPage.continueCheckoutForm();
        cartPage.cancelCheckout();
    }
}
