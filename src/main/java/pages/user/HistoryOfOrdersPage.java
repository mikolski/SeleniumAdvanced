package pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfOrdersPage extends BasePage {
    public HistoryOfOrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="tbody tr")
    private List<WebElement> orders;

    public List<String> getOrdersIDs() {
        List<String> ordersIDs = new ArrayList<>();
        for(WebElement order: orders){
            ordersIDs.add(order.findElement(By.cssSelector("th")).getText());
        }
        return ordersIDs;
    }

    public void goToOrderDetails(String orderID) {
        WebElement order = getOrderByID(orderID);
        click(order.findElement(By.cssSelector("[data-link-action='view-order-details']")));
    }

    private WebElement getOrderByID(String orderID) {
        for(WebElement order: orders){
            if(order.findElement(By.cssSelector("th")).getText().equals(orderID)){
                return order;
            }
        }
        return null;
    }
}
