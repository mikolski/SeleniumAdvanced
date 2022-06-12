package homeScreen;

import base.Pages;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest extends Pages {

    @Test
    public void shouldVerifyCategories(){
        //prziterować po wszystkich kategoriach
        //sprawdzić czy się przeszło do takiej kategorii
        //sprawdzić ile powinno być produktów
        //sprawdzić czy jest tyle produktów wyświetlonych

        int categoriesNumber = topMenuPage.getCategories().size();

        for(int i = 0; i < categoriesNumber; i++){
            String categoryName = topMenuPage.getCategoriesNames().get(i);

            topMenuPage.goToCategory(i);
            assertThat(categoryPage.getCategoryName()).isEqualTo(categoryName);
            assertThat(categoryPage.getDeclaredProductsNumber()).isEqualTo(categoryPage.getActualProductsNumber());
        }
    }
}
