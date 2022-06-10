package base;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.annotations.BeforeMethod;
import pages.commons.BreadcrumbPage;
import pages.commons.ProductsGridPage;
import pages.commons.TopMenuPage;
import pages.mainFeatures.ProductPage;
import pages.mainFeatures.ShoppingCartPage;
import pages.otherFeatures.SearchResultsPage;
import pages.popups.ProceedToCheckoutPopupPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

import java.util.Locale;

public class Pages extends TestBase{

    public LoginPage loginPage;

    public RegistrationPage registrationPage;

    public TopMenuPage topMenuPage;

    public ProductsGridPage productsGridPage;

    public SearchResultsPage searchResultsPage;

    public BreadcrumbPage breadcrumbPage;

    public ProductPage productPage;

    public ProceedToCheckoutPopupPage proceedToCheckoutPopupPage;

    public ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void testPagesSetup() {
        topMenuPage = new TopMenuPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        productsGridPage = new ProductsGridPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        breadcrumbPage = new BreadcrumbPage(driver);
        productPage = new ProductPage(driver);
        proceedToCheckoutPopupPage = new ProceedToCheckoutPopupPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }



}
