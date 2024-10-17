package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.landingpage.LandingPage;
import pages.shoppingcartpage.CartPage;
import utils.BaseTests;

import java.util.List;

public class viewCart extends BaseTests {

    LandingPage landingPage = new LandingPage(driver);
    CartPage cartPage = new CartPage(driver);
    List<String> addedProductNames;

    @Test
    @When("Add some products and by checking the shopping cart")
    public void add_some_products_and_by_checing_the_shopping_cart() {
        addedProductNames = landingPage.getaddedProducts();
        cartPage = landingPage.navigateToCartPage();



    }

    @Test
    @Then("The added products should be the same ones displayed in the shopping cart")
    public void the_added_products_should_be_the_same_ones_displayed_in_the_shopping_cart() {
       cartPage.viewCart(addedProductNames);
    }
}
