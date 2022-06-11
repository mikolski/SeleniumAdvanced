package homeScreen;

import base.Pages;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTests extends Pages {

    @Test
    public void shouldFindProduct() {
        String randomProduct = productsGridPage.getRandomProductName();

        topMenuPage.searchForProduct(randomProduct);

        assertThat(breadcrumbPage.getCurrentBreadcrumbPosition()).isEqualTo("Search results");

        assertThat(productsGridPage.getAllProductsNames()).isNotEmpty();
        for (String productName: productsGridPage.getAllProductsNames()) {
            assertThat(productName).contains(randomProduct);
        }

    }
}
