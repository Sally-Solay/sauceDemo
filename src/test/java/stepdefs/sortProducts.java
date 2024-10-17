package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pages.landingpage.LandingPage;
import utils.BaseTests;

public class sortProducts extends BaseTests {

    LandingPage landingPage = new LandingPage(driver);

    @Test
    @When("I select sorting from Z to A")
    public void i_click_on_sorting_name_a_to_z()  {
        landingPage.selectSortingOption();
    }

    @Test
    @Then("I should see the displayed products sorted successfully")
    public void i_should_see_the_displayed_products_sorted_successfully() {
       landingPage.sortProducts();
    }



}
