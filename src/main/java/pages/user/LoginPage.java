package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.commons.TopMenuPage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //no account element + metoda
    @FindBy(css = ".no-account a")
    private WebElement createAccountButton;

    public RegistrationPage goToCreateAccount(){
        click(createAccountButton);
        return new RegistrationPage(driver);
    }
}
