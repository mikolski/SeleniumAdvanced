package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderDetailsPage extends BasePage {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#order-infos strong")
    private WebElement orderReferenceInfo;

    public String getOrderReferenceInfo() {
        return orderReferenceInfo.getText();
    }
}
