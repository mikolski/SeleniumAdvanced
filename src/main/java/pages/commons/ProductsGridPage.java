package pages.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.mainFeatures.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class ProductsGridPage extends BasePage {
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }
    //Lista produktów
    @FindBy(css=".product")
    private List<WebElement> productsList;

    private String productNameCssSelector = ".product-title a";

    public WebElement getRandomProduct(){
        return getRandomElement(productsList);
    }

    public String getProductName(WebElement product){
        String productName = product.findElement(By.cssSelector(productNameCssSelector)).getText();
        return productName;
    }

    public List<WebElement> getAllProducts(){
        return productsList;
    }

    public List<String> getAllProductsNames(){
        List<String> productsNamesList = new ArrayList<>();
        for (WebElement product: productsList) {
            productsNamesList.add(getProductName(product));
        }
        return productsNamesList;
    }

    public ProductPage goToProductPage(String productName){
        click(getWebElementFromTheList(productsList,productNameCssSelector,productName));
        return new ProductPage(driver);
    }

//    public WebElement searchForProduct(String productName){
//
//        for (WebElement productItem: productsList) {
//                if(productItem.findElement(By.cssSelector(".product-title a")).getText() == productName){
//                    return productItem;
//                }
//        }
//        return null;
//    }
}
