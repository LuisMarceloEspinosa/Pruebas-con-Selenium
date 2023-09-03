package com.pagefactory1pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticuloWiki extends BasePage{
     
    public String getContent() {
        // Encuentra el elemento <p> que contiene el contenido del artículo
        WebElement contentElement = driver.findElement(By.tagName("p"));

        // Obtiene el texto del contenido
        return contentElement.getText();
    }



      public ArticuloWiki(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
        
    }
}
