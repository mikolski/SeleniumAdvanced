package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CheckoutConfirmationPage extends BasePage {
    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#content-hook_order_confirmation .card-title")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//*[text()[contains(.,'Order reference')]]")
    private WebElement orderID;

    @FindBy(css="order-line")
    private List<WebElement> products;

    String productDetailsCssSelector = ".details span";

    public String getConfirmationMessage() {
        return confirmationMessage.getText().substring(1);
    }

    public String getOrderId(){
        return orderID.getText().replace("Order reference: ","");
    }

    public String getNameOfProduct(String productName) {
        //TODO napisać jakąś wersję poniższej metody żeby wyszukiwała element po wybranym fragmencie tekstu
        WebElement product = getWebElementFromTheList(products, productDetailsCssSelector, productName);
        String productDetails = product.findElement(By.cssSelector(productDetailsCssSelector)).getText();
        return productDetails.substring(0, productDetails.indexOf("- Size"));
    }
}
