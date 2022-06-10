package pages.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class BreadcrumbPage extends BasePage {

    public BreadcrumbPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".breadcrumb")
    private WebElement breadcrumb;

    public String getCurrentBreadcrumbPosition() {
        String positionDepth = breadcrumb.getAttribute("data-depth");

        String position = breadcrumb.findElement(By.xpath("//*[@content='"+positionDepth+"']/../span")).getText();

        return position;
    }
}
