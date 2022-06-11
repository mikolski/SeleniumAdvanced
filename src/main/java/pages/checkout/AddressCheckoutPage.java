package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

public class AddressCheckoutPage extends BasePage {
    public AddressCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[name='address1']")
    private WebElement address;

    @FindBy(css="[name='city']")
    private WebElement city;

    @FindBy(css="[name='postcode']")
    private WebElement zipCode;

//    @FindBy(css="[name='id_country']")
//    private Select countrySelect;

    @FindBy(css="[name='confirm-addresses']")
    private WebElement continueToNextSection;

    public AddressCheckoutPage setAddress(String addressToTypeIn) {
        sendKeys(address, addressToTypeIn);
        return this;
    }

    public AddressCheckoutPage setCity(String cityName) {
        sendKeys(city, cityName);
        return this;
    }

    public AddressCheckoutPage setZipCode(String zipCodeToTypeIn) {
        sendKeys(zipCode, zipCodeToTypeIn);
        return this;
    }

    public AddressCheckoutPage setCountry(String country) {

        Select countrySelect = new Select(driver.findElement(By.cssSelector("[name='id_country']")));
        countrySelect.selectByVisibleText(country);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("[name='id_state']"))));

        return this;
    }

    public ShippingCheckoutPage continueToNextSection(){

        wait.until(ExpectedConditions.elementToBeClickable(continueToNextSection));

        click(continueToNextSection);
        return new ShippingCheckoutPage(driver);
    }
}
