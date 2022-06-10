package pages.commons;

import com.google.errorprone.annotations.concurrent.LazyInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.otherFeatures.SearchResultsPage;
import pages.user.LoginPage;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#_desktop_user_info a")
    private WebElement goToSignInButton;

    @FindBy(css = "#_desktop_user_info .account")
    private WebElement userName;

    //Search input
    @FindBy(css = "#search_widget input[type='text']")
    private WebElement searchInput;

    //przycisk lupki
    @FindBy(css = "#search_widget button[type='submit']")
    private WebElement searchButton;


    public LoginPage goToSignIn(){
        click(goToSignInButton);
        return new LoginPage(driver);
    }

    public String getUserName(){
        return userName.getText();
    }

    public SearchResultsPage searchForProduct(String productName){
        sendKeys(searchInput,productName);
        click(searchButton);
        return new SearchResultsPage(driver);
    }

}
