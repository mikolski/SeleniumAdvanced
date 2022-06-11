package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class PaymentsCheckoutPage extends BasePage {
    public PaymentsCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#payment-option-1")
    private WebElement payByCheckOption;

    @FindBy(css="[id='conditions_to_approve[terms-and-conditions]']")
    private WebElement termsAgreement;

    @FindBy(css="#payment-confirmation .btn-primary")
    private WebElement placeOrderButton;

    public PaymentsCheckoutPage choosePayByCheck() {
        click(payByCheckOption);
        return this;
    }

    public PaymentsCheckoutPage agreeToTerms() {
        click(termsAgreement);
        return this;
    }

    public CheckoutConfirmationPage placeOrder() {
        click(placeOrderButton);
        return new CheckoutConfirmationPage(driver);
    }
}
