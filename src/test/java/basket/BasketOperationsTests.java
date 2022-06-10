package basket;

import base.Pages;
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

        assertThat(shoppingCartPage.getProductsNumber()).isEqualTo(1);
        assertThat(shoppingCartPage.getProductsNames()).contains(productName);
        assertThat(shoppingCartPage.getProductItemsQuantity(productName)).isEqualTo(3);
        assertThat(shoppingCartPage.getProductPrice(productName)).isEqualTo("$19.12");
        assertThat(shoppingCartPage.getProductTotalPrice(productName)).isEqualTo("$57.36");

        shoppingCartPage.deleteProduct(productName);

        assertThat(shoppingCartPage.getEmptyBasketMessage()).isEqualTo("There are no more items in your cart");
    }
}
