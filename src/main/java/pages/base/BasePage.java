package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public void sendKeys(WebElement element, String text){
        System.out.println("Typing: " + text);
        element.sendKeys(text);
    }

    public void sendKeysWithClear(WebElement element, String text){
        System.out.println("Clearing input");
        element.clear();
        sendKeys(element,text);
    }
    public void click(WebElement element){
        System.out.println("Clicking: " + element.getText());
        element.click();
    }

    public void waitToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        return elements.get(rnd.nextInt(elements.size()));
    }

    public WebElement getWebElementFromTheList(List<WebElement> webElementList, String selector, String webElementText){

        for (WebElement webElement: webElementList) {
            if(webElement.findElement(By.cssSelector(selector)).getText().equals(webElementText)){
                return webElement;
            }
        }
        return null;
    }

    public boolean isDisplayed(By by){
        try{
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException exc){
            return false;
        }
    }

}
