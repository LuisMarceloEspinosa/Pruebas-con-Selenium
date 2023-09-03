import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pagefactory1pom.BaseTest;
import com.pagefactory1pom.pages.HomePage;
import com.pom.CategoryPage;


class ApplicationTest extends BaseTest {

    WebDriver driver = null;
    HomePage homePage;
    CategoryPage categoryPage;

    /**
     * 
     */
    @Test
    void testWikipedia() {
        homePage = getHomePage();
        homePage.searchForCategory("Computer programming");

        categoryPage = new CategoryPage();

        String categoryTitle = categoryPage.getCategoryTitle();
        System.out.println("Categoría: " + categoryTitle);

        String categoryMembers = categoryPage.getCategoryTitle();
        System.out.println("Miembros de la categoría:");
        for (WebElement member : categoryMembers) {
            System.out.println("- " + member.getText());
        }
    }
}