package homeScreen;

import base.Pages;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchingTests extends Pages {

    @Test
    public void shouldFindProduct() {


        String randomProduct = productsGridPage.getProductName(
                productsGridPage.getRandomProduct());

        topMenuPage.searchForProduct(randomProduct);

        assertThat(breadcrumbPage.getCurrentBreadcrumbPosition()).isEqualTo("Search results");
        assertThat(productsGridPage.getAllProductsNames()).contains(randomProduct);

    }
}
