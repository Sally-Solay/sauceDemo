package stepdefs;

import io.cucumber.java.en.Then;
import org.testng.annotations.Test;
import pages.landingpage.LandingPage;

import utils.BaseTests;

public class addProducts extends BaseTests {
    LandingPage landingPage = new LandingPage(driver);

    @Test
    @Then("By adding some products, the number of products displayed in the shopping cart should equal to the added number of products")
    public void by_adding_some_products_the_number_of_products_displayed_in_the_shopping_cart_should_equal_to_the_added_number_of_products() {
      landingPage.addProductsToCart();
    }

}
