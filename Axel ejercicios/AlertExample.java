package com.rsegg;


import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Duplication;

public class AlertExample {
    
        @Test
        void testWschools(){
         WebDriverManager.chromedriver().setup();
        // Iniciar el navegador
        WebDriver driver = new ChromeDriver();

        // Navegar a la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

        // Cambiar al iframe que contiene el botón
        driver.switchTo().frame("iframeResult");

        // Hacer clic en el botón para activar la alerta
        driver.findElement(By.xpath("/html/body/button")).click();

        // Cambiar a la alerta
        Alert alert = driver.switchTo().alert();

        // Aceptar la alerta
        alert.accept();

        // Cerrar el navegador
        driver.quit();
    }

    @Test
    void testWschoolCancel(){
        WebDriverManager.chromedriver().setup();
        // Iniciar el navegador
        WebDriver driver = new ChromeDriver();

        // Navegar a la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

        driver.switchTo().frame("iframeResult");

        driver.findElement(By.xpath("/html/body/button")).click();

        Alert alertCancel = driver.switchTo().alert();

        alertCancel.dismiss();

    }

    @Test
    void testWschoolPrompt(){
        WebDriverManager.chromedriver().setup();
        // Iniciar el navegador
        WebDriver driver = new ChromeDriver();

        // Navegar a la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

        driver.switchTo().frame("iframeResult");

        driver.findElement(By.xpath("/html/body/button")).click();

        Alert alertHarryElSucio = driver.switchTo().alert();

        alertHarryElSucio.sendKeys("El sucio Potter ");

        alertHarryElSucio.accept();

}

@Test
void testIframeHolaMundo(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_default");

// Cambiar al iframe que contiene el editor
driver.switchTo().frame("iframeResult");

// Encontrar el elemento <h1> y cambiar su contenido
WebElement h1Element = driver.findElement(By.tagName("h1"));
((JavascriptExecutor) driver).executeScript("arguments[0].innerText = '¡Hola Mundo!'", h1Element);

// (Opcional) Cambiar de nuevo al contenido principal fuera del iframe
driver.switchTo().defaultContent();

driver.quit();
}

@Test
void testIframeParrafo(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
driver.get("https://www.quackit.com/html/html_editors/scratchpad/?example=/html/tutorial/html_iframe_example");

// Cambiar al iframe que contiene el editor
driver.switchTo().frame("preview").switchTo().frame(0);

driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
// Encontrar el elemento <h1> y cambiar su contenido
WebElement parrafoElement = driver.findElement(By.xpath("/html/body/p[1]"));
((JavascriptExecutor) driver).executeScript("arguments[0].innerText = 'Texto modificado con Selenium'", parrafoElement);

// (Opcional) Cambiar de nuevo al contenido principal fuera del iframe
driver.switchTo().defaultContent();
}

@Test
void testCalculadoraWschool(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
driver.get("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_binding");

// Cambiar al iframe que contiene el editor
driver.switchTo().frame("iframeResult");

driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
// Encontrar el elemento <h1> y cambiar su contenido
// WebElement calculadoraElement = driver.findElement(By.cssSelector("input[ng-model=\"quantity\"]"));
// ((JavascriptExecutor) driver).executeScript("arguments[0].value = '5'", calculadoraElement);
WebElement calculadoraElement = driver.findElement(By.cssSelector("input[ng-model=\"quantity\"]"));
calculadoraElement.sendKeys(Keys.BACK_SPACE + "5\n");;
// (Opcional) Cambiar de nuevo al contenido principal fuera del iframe
driver.switchTo().defaultContent();
}
}
