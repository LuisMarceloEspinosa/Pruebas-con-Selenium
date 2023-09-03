package com.pagefactory1pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.pagefactory1pom.pages.ArticuloWiki;
import com.pagefactory1pom.pages.HomePage;
import com.pagefactory1pom.pages.buscarWikipedia;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    WebDriver driver = null;

    HomePage homePage;
    
    @BeforeEach
    public void beforeTest() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        driver.quit();
    }

    public HomePage getHomePage() {
            return new HomePage(driver, "https://www.wikipedia.org");
    }
    public buscarWikipedia getHomePage1() {
            return new buscarWikipedia(driver, "https://www.wikipedia.org");
    }
    public ArticuloWiki getHomePage2() {
            return new ArticuloWiki(driver, "https://es.wikipedia.org/wiki/Pelota");
    }
    
}
