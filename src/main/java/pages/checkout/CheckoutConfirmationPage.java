package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutConfirmationPage extends BasePage {
    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#content-hook_order_confirmation .card-title")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//*[text()[contains(.,'Order reference')]]")
    private WebElement orderID;

    @FindBy(css=".order-line")
    private List<WebElement> products;

    String productDetailsCssSelector = ".details span";

    String productPriceCssSelector = ".details span";

    public String getConfirmationMessage() {
        return confirmationMessage.getText().substring(1);
    }

    public String getOrderId(){
        return orderID.getText().replace("Order reference: ","");
    }

    public String getNameOfProduct(String productName) {
        WebElement product = getProductByProductName(productName);
        String desc = product.findElement(By.cssSelector(productDetailsCssSelector)).getText();
        return desc.substring(0, desc.indexOf(" - Size"));
    }

    public String getPriceOfProduct(String productName) {
        WebElement product = getProductByProductName(productName);
        return getProductDataMap(product).get("productPrice").getText();

    }

    public WebElement getProductByProductName(String productName){
        for (WebElement product: products) {
            String desc = product.findElement(By.cssSelector(productDetailsCssSelector)).getText();
            if(desc.substring(0, desc.indexOf(" - Size")).equals(productName)){
                return product;
            }
        }
        return null;
    }

    public Map<String, WebElement> getProductDataMap(WebElement product) {
        List<WebElement> listOfProductData = product.findElements(By.cssSelector(".order-line .row div"));
        Map<String, WebElement> mapOfData= new HashMap<>();
        mapOfData.put("productPrice", listOfProductData.get(0));
        mapOfData.put("productQuantity", listOfProductData.get(1));
        mapOfData.put("productTotalPrice", listOfProductData.get(2));
        return mapOfData;

    }

    public String getQuantityOfProduct(String productName) {
        WebElement product = getProductByProductName(productName);
        return getProductDataMap(product).get("productQuantity").getText();
    }

    public String getProductTotalPrice(String productName) {
        WebElement product = getProductByProductName(productName);
        return getProductDataMap(product).get("productTotalPrice").getText();
    }
}
