package pages.shoppingcartpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    SoftAssert softassert = new SoftAssert();

    Logger logger = LoggerFactory.getLogger(String.valueOf(this));
    private By productNameInCart = By.className("inventory_item_name");

    private By checkoutBtn = By.id("checkout");
    private By fName = By.id("first-name");
    private By lName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By cancelBtn = By.id("cancel");
    private By finishBtn = By.id("finish");
    private By totalPrice = By.cssSelector("div[data-test='total-label']");


    public void viewCart(List<String> addedValues) {
        try {
            List<WebElement> cartProducts = driver.findElements(productNameInCart);
            List<String> cartProductNames = new ArrayList<>();
            for (WebElement cartProduct : cartProducts) {
                cartProductNames.add(cartProduct.getText());
            }
            softassert.assertEquals(addedValues, cartProductNames, "The products in the cart do not match the added products");

            logger.info("Products in the cart match the added products!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void fillCheckoutForm(String firstName, String lastName, String pCode) {
        driver.findElement(fName).sendKeys(firstName);
        driver.findElement(lName).sendKeys(lastName);
        driver.findElement(postalCode).sendKeys(pCode);
    }

    public void continueCheckoutForm() {
        driver.findElement(continueBtn).click();


    }

    public void cancelCheckout() {
        driver.findElement(cancelBtn).click();

    }

    public void clickCheckoutBtn() {
        driver.findElement(checkoutBtn).click();

    }


    public void finishCheckout() {
        driver.findElement(finishBtn).click();

    }


    public String getTotalValue(String str) {
        String value = null;
        String[] arrOfStr = str.split(": ");
        for (String a : arrOfStr) {
           value = a ;
        }
        return value;
    }


    public void verifyTotalisZero(){
        String priceTotal = driver.findElement(totalPrice).getText();
        String extractedValue = getTotalValue(priceTotal);
        logger.info(extractedValue);
        softassert.assertEquals(extractedValue, "$0.00", "It doesn't match");
        softassert.assertAll();
    }
    
    
}
