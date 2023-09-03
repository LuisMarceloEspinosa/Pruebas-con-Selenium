package com.pagefactory1pom.pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = ".footer-sidebar-text + div.footer-sidebar-text")
    private WebElement footerText;

    @FindBy(css = "button[type=submit]")
    private WebElement submitBtn;

    @FindBy(className = "central-featured-lang")
    private List<WebElement> lang_list;

   

    public void setBarText(String text) {
        this.searchInput.sendKeys(text);
    }

    public  void clickOnSearch() {
        this.submitBtn.click();
    }

    public String getFooterText() {
        this.isElementDisplayed(this.footerText);
        return this.footerText.getText();
    }

    public boolean btnDisplayed() {
        this.isElementDisplayed(this.submitBtn);
        return this.submitBtn.isDisplayed();
    }

    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        
    }
    public void searchForCategory(String categoryName) {
        searchInput.sendKeys(categoryName);
        this.submitBtn.click();
    }
    /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); */

    /*List<WebElement> lang_list = 
                    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(
                    "central-featured-lang")));

        assertEquals(lang_list.size(), 10); */
        //assertTrue(submitBtn.isDisplayed());
}
