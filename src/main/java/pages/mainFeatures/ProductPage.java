package pages.mainFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.popups.ProceedToCheckoutPopupPage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#quantity_wanted")
    private WebElement quantityField;

    @FindBy(css=".add-to-cart")
    private WebElement addToCartButton;

    public ProductPage setProductQuantity(String quantity){
        sendKeysWithClear(quantityField, quantity);
        return this;
    }

    public ProceedToCheckoutPopupPage addProductToCart(){
        click(addToCartButton);
        return new ProceedToCheckoutPopupPage(driver);
    }
}
