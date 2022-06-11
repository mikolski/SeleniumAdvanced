package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class ShippingCheckoutPage extends BasePage {
    public ShippingCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[name='confirmDeliveryOption']")
    private WebElement continueToNextSection;

    public PaymentsCheckoutPage continueToNextSection() {
        wait.until(ExpectedConditions.elementToBeClickable(continueToNextSection));
        click(continueToNextSection);
        return new PaymentsCheckoutPage(driver);
    }
}
