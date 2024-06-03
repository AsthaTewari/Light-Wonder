package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
//css
    @FindBy(css = "span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold")
    private WebElement cartPrice;

    @FindBy(css = "span.sc-subtotal-amount-activecart span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap")
    private WebElement subtotal;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartPrice() {
        return cartPrice.getText();
    }

    public String getSubtotal() {
        return subtotal.getText();
    }
}
