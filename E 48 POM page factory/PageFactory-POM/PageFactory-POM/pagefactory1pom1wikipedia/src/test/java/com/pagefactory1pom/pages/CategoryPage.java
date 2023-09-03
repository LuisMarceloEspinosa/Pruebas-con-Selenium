package com.pagefactory1pom.pages;

import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage{
    
    
    public CategoryPage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        
    }
}
