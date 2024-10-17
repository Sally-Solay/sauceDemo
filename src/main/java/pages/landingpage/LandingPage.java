package pages.landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import pages.loginpage.LoginPage;
import pages.shoppingcartpage.CartPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    SoftAssert softassert = new SoftAssert();
    Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    private By burgerIcon = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By removeFromCartBtn = By.xpath("//button[contains(text(), 'Remove')]");
    private By addToCartBtn = By.xpath("//button[contains(text(), 'Add to cart')]");
    private By shoppingCartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
    private By childTag = By.cssSelector("a > span[data-test='shopping-cart-badge']");
    private By sortingList = By.className("product_sort_container");
    private By productName = By.className("inventory_item_name");
    private By shoppingCartLink = By.className("shopping_cart_link");


    public void verifyTheuserloggedInSuccessfully(String cURL) {
        String currentURl = driver.getCurrentUrl();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(currentURl, cURL);
        softassert.assertTrue(driver.findElement(burgerIcon).isDisplayed());
        softassert.assertAll();
    }

    public LoginPage logOut() throws InterruptedException {
        WebDriverWait wait_element = new WebDriverWait(driver, Duration.ofSeconds(8000));
        wait_element.until(ExpectedConditions.visibilityOfElementLocated(burgerIcon));
        driver.findElement(burgerIcon).click();
        wait_element.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        driver.findElement(logoutLink).click();
        return new LoginPage(driver);
    }


    public void addProductsToCart() {
        try {
            List<WebElement> addButtons = driver.findElements(addToCartBtn);
            int productsToAdd = 3;
            for (int i = 0; i < productsToAdd && i < addButtons.size(); i++) {
                WebElement product = driver.findElement(productName);
                addButtons.get(i).click();

            }

            int displayedCount = Integer.parseInt(driver.findElement(shoppingCartBadge).getText());
            softassert.assertEquals(productsToAdd, displayedCount, "Cart count does not match the number of added items");
            softassert.assertAll();
            logger.info("Cart count is correct: " + displayedCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void verifyRemoveBtnsDisplayed() {
        WebDriverWait wait_element = new WebDriverWait(driver, Duration.ofSeconds(8000));
        wait_element.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeFromCartBtn));

    }


    public void removeProductsFromCart() throws Exception {
        try {

            List<WebElement> removeButtons = driver.findElements(removeFromCartBtn);
            int productsToRemove = 3;
            for (int i = 0; i < productsToRemove && i < removeButtons.size(); i++) {
                removeButtons.get(i).click();

            }

            softassert.assertFalse(driver.findElement(childTag).isDisplayed());
            softassert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void selectSortingOption() {
        Select dropdown = new Select(driver.findElement(sortingList));
        dropdown.selectByValue("za");
    }

    public void sortProducts() {


        try {
            List<WebElement> productElements = driver.findElements(productName);
            List<String> productNames = new ArrayList<>();
            for (WebElement product : productElements) {
                productNames.add(product.getText());
            }


            List<String> sortedProductNames = new ArrayList<>(productNames);
            Collections.sort(sortedProductNames, Collections.reverseOrder());
            softassert.assertEquals(sortedProductNames, productNames, "Products are not sorted alphabetically from Z to A");
            logger.info("Products are sorted from Z to A correctly!");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    public List<String> getaddedProducts() {

        List<WebElement> addButtons = driver.findElements(addToCartBtn);
        List<String> addedProducts = new ArrayList<>();

        for (WebElement button : addButtons) {
            List<WebElement> products = button.findElements(productName);
            for (WebElement item : products) {
            addedProducts.add(item.getText());
            }

            button.click();
        }

        return addedProducts;
    }

    public CartPage navigateToCartPage() {

        driver.findElement(shoppingCartLink).click();

        return new CartPage(driver);
    }
}