package com.pagefactory1pom.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class buscarWikipedia extends BasePage{
    @FindBy(id = "searchInput")
    private WebElement searchInput;

 
public  void setBarText(String text) {
        this.searchInput.sendKeys(text);
    }
    public buscarWikipedia(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        
    }
}
