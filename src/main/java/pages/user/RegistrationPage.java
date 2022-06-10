package pages.user;

import models.SocialTitle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.commons.TopMenuPage;

import java.util.List;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#customer-form [name='id_gender']")
    private List<WebElement> genders;
    @FindBy(css = "#customer-form [name='firstname']")
    private WebElement firstName;
    @FindBy(css = "#customer-form [name='lastname']")
    private WebElement lastName;
    @FindBy(css = "#customer-form [name='email']")
    private WebElement email;
    @FindBy(css = "#customer-form [name='password']")
    private WebElement password;
    @FindBy(css = "#customer-form [name='customer_privacy']")
    private WebElement customerDataPrivacy;
    @FindBy(css = "#customer-form [name='psgdpr']")
    private WebElement generalTermsAcceptance;
    @FindBy(css = "#customer-form button.form-control-submit")
    private WebElement saveButton;

    public RegistrationPage selectRandomGender(){
        click(getRandomElement(genders));
        return this;
    }
    public RegistrationPage selectSocialTitle(SocialTitle socialTitle){

        switch (socialTitle){
            case Mr:
                click(genders.get(0));
                break;
            case Mrs:
                click(genders.get(1));
                break;
        }

        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        sendKeys(this.firstName, firstName );
        return this;
    }
    public RegistrationPage setLastName(String lastName) {
        sendKeys(this.lastName, lastName);
        return this;
    }
    public RegistrationPage setEmail(String email) {
        sendKeys(this.email, email);
        return this;
    }
    public RegistrationPage setPassword(String password) {
        sendKeys(this.password, password);
        return this;
    }
    public RegistrationPage setPrivacy() {
        click(customerDataPrivacy);
        return this;
    }
    public RegistrationPage setGeneralTerms() {
        click(generalTermsAcceptance);
        return this;
    }
    public TopMenuPage clickSaveButton() {
        click(saveButton);
        return new TopMenuPage(driver);
    }

}
