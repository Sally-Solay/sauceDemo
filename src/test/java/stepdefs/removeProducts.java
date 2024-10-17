package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.landingpage.LandingPage;

import utils.BaseTests;

public class removeProducts extends BaseTests {

    LandingPage landingPage = new LandingPage(driver);

    @Test
    @When("I make sure that Remove buttons are displayed")
    public void i_try_to_remove_these_products_from_the_shopping_cart() {
        landingPage.verifyRemoveBtnsDisplayed();
    }

    @Test
    @Then("By removing these products, the shopping cart should be empty")
    public void the_shopping_cart_should_be_empty() throws Exception {
        landingPage.removeProductsFromCart();
    }

}
