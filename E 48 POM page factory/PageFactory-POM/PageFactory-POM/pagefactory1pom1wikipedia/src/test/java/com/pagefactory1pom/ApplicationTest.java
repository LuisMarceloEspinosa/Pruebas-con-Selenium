package com.pagefactory1pom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.pagefactory1pom.pages.ArticuloWiki;
import com.pagefactory1pom.pages.CategoryPage;
import com.pagefactory1pom.pages.HomePage;
import com.pagefactory1pom.pages.buscarWikipedia;

class ApplicationTest extends BaseTest {

    WebDriver driver = null;

    HomePage homePage;
    // CategoryPage categoryPage;

    // buscarWikipedia buscarwikipedia;
    // ArticuloWiki articuloWiki;

    @Test
    void testWikipedia() {
        HomePage homePage = getHomePage();
        // ArticuloWiki articuloWiki = getHomePage2();
        // buscarWikipedia buscarwikipedia = getHomePage1();
        // String content = articuloWiki.getContent();
        // System.out.println("Contenido del artículo:");
        // System.out.println(content);

        homePage.setBarText("Selenium");
        assertEquals(homePage.getFooterText(), "You can support our work with a donation.");
        assertTrue(homePage.btnDisplayed());
        homePage.clickOnSearch();
    }
}
