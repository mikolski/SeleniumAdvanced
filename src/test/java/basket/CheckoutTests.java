package basket;

import base.Pages;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.SocialTitle;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTests extends Pages {

    private String productName;
    private Faker faker;
    private FakeValuesService fakeValuesService;
    private String firstName;
    private String lastName;
    private String password;
    private String productQuantity;
    private String expectedProductPrice;
    private String expectedTotalProductPrice;

    @BeforeMethod
    public void testSetup() {

        faker = new Faker();
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = "password123";
        productName = "HUMMINGBIRD T-SHIRT";
        expectedProductPrice = "$19.12";
        productQuantity = "3";
        expectedTotalProductPrice = "$"+ (Double.parseDouble(expectedProductPrice.substring(1)) * Double.parseDouble(productQuantity));
    }

    @Test
    public void shouldProccedToCheckout(){
        productsGridPage.goToProductPage(productName);

        assertThat(breadcrumbPage.getCurrentBreadcrumbPosition()).isEqualTo(productName);

        productPage.setProductQuantity(productQuantity)
                .addProductToCart();

        proceedToCheckoutPopupPage.proceedToCheckout();

        shoppingCartPage.proceedToCheckout();

        personalInfoCheckoutPage
                .selectSocialTitle(SocialTitle.Mr)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(fakeValuesService.bothify("????##@gmail.com"))
                .setPassword(password)
                .setPrivacy()
                .setGeneralTerms();

        personalInfoCheckoutPage.continueToNextSection();

        addressCheckoutPage
                .setAddress("Warszawska 100")
                .setCity("Legionowo")
                .setZipCode("05-120")
                .setCountry("Poland");

        addressCheckoutPage.continueToNextSection();

        shippingCheckoutPage.continueToNextSection();

        paymentsCheckoutPage.choosePayByCheck()
                .agreeToTerms()
                .placeOrder();

        assertThat(checkoutConfirmationPage.getConfirmationMessage()).isEqualTo("YOUR ORDER IS CONFIRMED");

        // dla chetnych  - weryfikacja danych produktu (nazwa, cena, ilosc, cenalaczna)
        assertThat(checkoutConfirmationPage.getNameOfProduct(productName)).isEqualTo(productName);
        assertThat(checkoutConfirmationPage.getPriceOfProduct(productName)).isEqualTo(expectedProductPrice);
        assertThat(checkoutConfirmationPage.getQuantityOfProduct(productName)).isEqualTo(productQuantity);
        assertThat(checkoutConfirmationPage.getProductTotalPrice(productName)).isEqualTo(expectedTotalProductPrice);

        String orderID = checkoutConfirmationPage.getOrderId();

        topMenuPage.goToAccount();

        myAccountPage.goToOrderHistory();

        assertThat(historyOfOrdersPage.getOrdersIDs()).isNotEmpty().contains(orderID);

        historyOfOrdersPage.goToOrderDetails(orderID);

        assertThat(orderDetailsPage.getOrderReferenceInfo()).contains(orderID);

        // dla chetnych sprawdzic pozostałe dane zamowienia

    }
}
