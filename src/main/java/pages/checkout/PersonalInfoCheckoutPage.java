package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.user.RegistrationPage;

public class PersonalInfoCheckoutPage extends RegistrationPage {
    public PersonalInfoCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#checkout-guest-form .continue")
    private WebElement contineButton;

    public AddressCheckoutPage continueToNextSection(){
        click(contineButton);
        return new AddressCheckoutPage(driver);
    }
}
