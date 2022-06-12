package pages.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.IExpectedExceptionsHolder;
import pages.base.BasePage;
import pages.otherFeatures.SearchResultsPage;
import pages.user.LoginPage;

import java.util.ArrayList;
import java.util.List;

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

    String categoriesCssSelector = "#top-menu > .category";


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

    public void goToAccount() {
        click(userName);
    }

    public List<String> getCategoriesNames() {
        List<String> categoriesNames = new ArrayList<>();
        for (WebElement category: getCategories()) {
            categoriesNames.add(category.getText());
        }
        return categoriesNames;
    }

    public List<WebElement> getCategories(){
        return driver.findElements(By.cssSelector(categoriesCssSelector));
    }

    public CategoryPage goToCategory(int i) {
        WebElement category = getCategories().get(i);
        wait.until(ExpectedConditions.elementToBeClickable(category));
        click(category);
        return new CategoryPage(driver);
    }
}
