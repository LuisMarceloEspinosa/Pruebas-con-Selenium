package com.pagefactory1pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = "button[type=submit]")
    private WebElement submitBtn;

    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
    }

    public void searchForCategory(String categoryName) {
        searchInput.sendKeys(categoryName);
        submitBtn.click();
    }
}