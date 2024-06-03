package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
//css
    @FindBy(css = "div.s-main-slot div.s-result-item")
    private List<WebElement> results;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstItem() {
        if (!results.isEmpty()) {
            results.get(0).click();
        }
    }

    public void selectSecondItem() {
        if (results.size() > 1) {
            results.get(1).click();
        }
    }
}
