package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".block-category h1")
    private WebElement categoryName;

    @FindBy(css=".total-products")
    private WebElement declarationOfProductNumber;

    @FindBy(css=".product")
    private List<WebElement> products;

    public String getCategoryName(){
        return categoryName.getText();
    }

    public int getDeclaredProductsNumber() {
        String declaration = declarationOfProductNumber.getText();
        return Integer.parseInt(declaration.replace("There are ","").replace(" products.",""));
    }

    public int getActualProductsNumber() {
        return products.size();
    }
}
