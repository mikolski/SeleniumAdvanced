package base;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.annotations.BeforeMethod;
import pages.checkout.*;
import pages.commons.BreadcrumbPage;
import pages.commons.CategoryPage;
import pages.commons.ProductsGridPage;
import pages.commons.TopMenuPage;
import pages.mainFeatures.ProductPage;
import pages.mainFeatures.ShoppingCartPage;
import pages.otherFeatures.SearchResultsPage;
import pages.popups.ProceedToCheckoutPopupPage;
import pages.user.*;

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

    public AddressCheckoutPage addressCheckoutPage;

    public CheckoutConfirmationPage checkoutConfirmationPage;

    public PaymentsCheckoutPage paymentsCheckoutPage;

    public PersonalInfoCheckoutPage personalInfoCheckoutPage;

    public ShippingCheckoutPage shippingCheckoutPage;

    public HistoryOfOrdersPage historyOfOrdersPage;

    public MyAccountPage myAccountPage;

    public OrderDetailsPage orderDetailsPage;

    public CategoryPage categoryPage;

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
        addressCheckoutPage = new AddressCheckoutPage(driver);
        checkoutConfirmationPage = new CheckoutConfirmationPage(driver);
        paymentsCheckoutPage = new PaymentsCheckoutPage(driver);
        personalInfoCheckoutPage = new PersonalInfoCheckoutPage(driver);
        shippingCheckoutPage = new ShippingCheckoutPage(driver);
        historyOfOrdersPage = new HistoryOfOrdersPage(driver);
        myAccountPage = new MyAccountPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        categoryPage = new CategoryPage(driver);
    }



}
