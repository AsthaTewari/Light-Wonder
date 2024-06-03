package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
//css
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id = "priceblock_ourprice")
    private WebElement price;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getPrice() {
        return price.getText();
    }
}
