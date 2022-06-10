package pages.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;
import pages.mainFeatures.ShoppingCartPage;

public class ProceedToCheckoutPopupPage extends BasePage {
    public ProceedToCheckoutPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#blockcart-modal .btn-primary")
    WebElement proceedToCheckoutButton;

    public ShoppingCartPage proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        click(proceedToCheckoutButton);
        return new ShoppingCartPage(driver);
    }
}
