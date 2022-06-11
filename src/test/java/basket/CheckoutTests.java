package basket;

import base.Pages;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.SocialTitle;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTests extends Pages {

    private String productName;

    private Faker faker;
    private FakeValuesService fakeValuesService;
    private String firstName;
    private String lastName;
    private String password;

    @BeforeMethod
    public void testSetup() {

        faker = new Faker();
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = "password123";
        productName = "HUMMINGBIRD T-SHIRT";
    }

    @Test
    public void shouldProccedToCheckout(){
        productsGridPage.goToProductPage(productName);

        assertThat(breadcrumbPage.getCurrentBreadcrumbPosition()).isEqualTo(productName);

        productPage.setProductQuantity("3")
                .addProductToCart();

        proceedToCheckoutPopupPage.proceedToCheckout();

        // w koszyku click Proceed to checkout
        shoppingCartPage.proceedToCheckout();
        // 1 Personal Information - wypełnienie wymaganych danych
        personalInfoCheckoutPage
                .selectSocialTitle(SocialTitle.Mr)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(fakeValuesService.bothify("????##@gmail.com"))
                .setPassword(password)
                .setPrivacy()
                .setGeneralTerms();
        // klikamy continue
        personalInfoCheckoutPage.continueToNextSection();
        // 2 Adresses - wypełnienie wymaganych danych
        addressCheckoutPage

                .setAddress("Warszawska 100")
                .setCity("Legionowo")
                .setZipCode("05-120")
                .setCountry("Poland");

                // klikamy continue
        addressCheckoutPage.continueToNextSection();

        // 3 Shippinf methd - klikamy continue
        shippingCheckoutPage.continueToNextSection();
        // 4 payment zaznacz Pay by check i checbox I agree to terms...
        paymentsCheckoutPage.choosePayByCheck();
        paymentsCheckoutPage.agreeToTerms();

        // klikamy place Border
        paymentsCheckoutPage.placeOrder();
        // sprawdz czy teks YOUR ORDER IS CONFIRMED
        assertThat(checkoutConfirmationPage.getConfirmationMessage()).isEqualTo("YOUR ORDER IS CONFIRMED");
        // dla chetnych  - weryfikacja danych produktu (nazwa, cena, ilosc, cenalaczna)

        //assertThat(checkoutConfirmationPage.getNameOfProduct(productName)).isEqualTo(productName);
//        assertThat(checkoutConfirmationPage.getPriceOfProduct()).isEqualTo(productPrice);
//        assertThat(checkoutConfirmationPage.getQuantityOfProduct()).isEqualTo(productQuantity);
//        assertThat(checkoutConfirmationPage.getProductTotalPrice()).isEqualTo(productTotalPrice);

        // 5 do zmiennej zapisz wygenerowany numer zamowienia
        String orderID = checkoutConfirmationPage.getOrderId();
        // przejdz do your account
        topMenuPage.goToAccount();
        // przejdz do ORDER HISTORY aND DETAILS
        myAccountPage.goToOrderHistory();

        // sprawdz czy na stornie z histoia zamiein znajduje sie numer zamowienia z pinkyut 5
        assertThat(historyOfOrdersPage.getOrdersIDs()).isNotEmpty().contains(orderID);
        // 6 otwórz zamowienie z pkt 5
        historyOfOrdersPage.goToOrderDetails(orderID);
        // sprawdz czy tekst zawiera nr zamowienia z punktu 5
        assertThat(orderDetailsPage.getOrderReferenceInfo()).contains(orderID);
        // dla chetnych sprawdzic pozostałe dane zamowienia

    }
}
