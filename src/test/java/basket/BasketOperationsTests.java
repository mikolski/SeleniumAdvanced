package basket;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketOperationsTests extends Pages {

    private String productName = "HUMMINGBIRD T-SHIRT";

    @Test
    public void shouldAddAndRemoveProductFromBasket() {


        productsGridPage.goToProductPage(productName);

        assertThat(breadcrumbPage.getCurrentBreadcrumbPosition()).isEqualTo(productName);

        productPage.setProductQuantity("3")
                .addProductToCart();

        proceedToCheckoutPopupPage.proceedToCheckout();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(shoppingCartPage.getProductsNumber()).isEqualTo(1);
        softAssertions.assertThat(shoppingCartPage.getProductsNames()).contains(productName);
        softAssertions.assertThat(shoppingCartPage.getProductItemsQuantity(productName)).isEqualTo(3);
        softAssertions.assertThat(shoppingCartPage.getProductPrice(productName)).isEqualTo("$19.12");
        softAssertions.assertThat(shoppingCartPage.getProductTotalPrice(productName)).isEqualTo("$57.36");

        shoppingCartPage.deleteProduct(productName);

        softAssertions.assertThat(shoppingCartPage.getEmptyBasketMessage()).isEqualTo("There are no more items in your cart");
        softAssertions.assertAll();
    }
}
