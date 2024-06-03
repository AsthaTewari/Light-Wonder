package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.testng.Assert.assertEquals;

public class AmazonSteps {

    private WebDriver driver;
    private AmazonHomePage amazonHomePage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private String productPrice1;
    private String productPrice2;

    @Given("I open Amazon homepage")
    public void iOpenAmazonHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        amazonHomePage = new AmazonHomePage(driver);
    }

    @When("I search for {string}")
    public void iSearchFor(String item) {
        amazonHomePage.searchFor(item);
        searchResultPage = new SearchResultPage(driver);
    }

    @When("I select the first item in the list")
    public void iSelectTheFirstItemInTheList() {
        searchResultPage.selectFirstItem();
        productPage = new ProductPage(driver);
    }

    @When("I select the second item in the list")
    public void iSelectTheSecondItemInTheList() {
        searchResultPage.selectSecondItem();
        productPage = new ProductPage(driver);
    }

    @When("I add the item to cart")
    public void iAddTheItemToCart() {
        if (productPrice1 == null) {
            productPrice1 = productPage.getPrice();
        } else {
            productPrice2 = productPage.getPrice();
        }
        productPage.addToCart();
    }
   
    @Then("I open the cart")
    public void iOpenTheCart() {
        driver.get("https://www.amazon.com/gp/cart/view.html");
        cartPage = new CartPage(driver);
    }

    @Then("I verify the cart price is same as product page price")
    public void iVerifyTheCartPriceIsSameAsProductPagePrice() {
        assertEquals(cartPage.getCartPrice(), productPrice1, "Cart price does not match product page price");
    }

    @Then("I verify the cart subtotal is same as product page price")
    public void iVerifyTheCartSubtotalIsSameAsProductPagePrice() {
        assertEquals(cartPage.getSubtotal(), productPrice1, "Cart subtotal does not match product page price");
    }

    @Then("I verify each item total price is correct")
    public void iVerifyEachItemTotalPriceIsCorrect() {
        assertEquals(cartPage.getCartPrice(), productPrice1, "First item price does not match");
        assertEquals(cartPage.getCartPrice(), productPrice2, "Second item price does not match");
    }

    @Then("I verify the subtotal is calculated correctly")
    public void iVerifyTheSubtotalIsCalculatedCorrectly() {
        String expectedSubtotal = String.format("$%.2f", Double.parseDouble(productPrice1.replace("$", "")) + Double.parseDouble(productPrice2.replace("$", "")));
        assertEquals(cartPage.getSubtotal(), expectedSubtotal, "Cart subtotal is incorrect");
        driver.quit();
    }
}
