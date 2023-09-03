package com.pagefactory1pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.pagefactory1pom.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    WebDriver driver = null;

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
}