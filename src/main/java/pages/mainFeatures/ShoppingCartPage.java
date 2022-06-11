package pages.mainFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;
import pages.checkout.PersonalInfoCheckoutPage;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".cart-item")
    private List<WebElement> productsList;

    @FindBy(css=".no-items")
    private WebElement emptyCartMessage;

    @FindBy(css=".cart-summary .btn-primary")
    private WebElement proceedToCheckoutButton;

    private String productNameCssSelector = ".product-line-info .label";

    private String productItemPriceCssSelector = ".product-price .price";

    private String productTotalPriceCssSelector = ".price .product-price";

    private String removeButtonCssSelector = ".remove-from-cart";

    private String productQuantityCssSelector = "[name='product-quantity-spin']";

    public int getProductsNumber() {
        return productsList.size();
    }

    public List<String> getProductsNames() {
        List<String> productsNames = new ArrayList<>();
        for (WebElement product: productsList) {
             String name = product.findElement(By.cssSelector(productNameCssSelector)).getText();
             productsNames.add(name);
        }
        return productsNames;
    }

    public int getProductItemsQuantity(String productName) {
        WebElement product = getWebElementFromTheList(productsList,productNameCssSelector,productName);
        return Integer.parseInt(product.findElement(By.cssSelector(productQuantityCssSelector)).getAttribute("value"));
    }

    public String getProductPrice(String productName){
        WebElement product = getWebElementFromTheList(productsList,productNameCssSelector,productName);
        return product.findElement(By.cssSelector(productItemPriceCssSelector)).getText();
    }

    public String getProductTotalPrice(String productName) {
        WebElement product = getWebElementFromTheList(productsList,productNameCssSelector,productName);
        return product.findElement(By.cssSelector(productTotalPriceCssSelector)).getText();
    }

    public void deleteProduct(String productName) {
        WebElement product = getWebElementFromTheList(productsList,productNameCssSelector,productName);
        WebElement binButton = product.findElement(By.cssSelector(removeButtonCssSelector));
        click(binButton);
        wait.until(ExpectedConditions.invisibilityOf(binButton));
    }

    public String getEmptyBasketMessage() {
        return emptyCartMessage.getText();
    }

    public PersonalInfoCheckoutPage proceedToCheckout() {
        click(proceedToCheckoutButton);
        return new PersonalInfoCheckoutPage(driver);
    }
}
