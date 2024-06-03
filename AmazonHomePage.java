package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage {
//FindBy
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String item) {
        searchField.sendKeys(item);
        searchField.submit();
    }
}
