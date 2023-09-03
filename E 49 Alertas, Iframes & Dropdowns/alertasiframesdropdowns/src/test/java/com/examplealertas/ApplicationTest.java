package com.examplealertas;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    // Alertas Iframes Dropdowns

    // ejemplo
    @Test
    void testWschools() {
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

    // ejercicio 1
    @Test
    void testWschoolCancel() {
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

    // ejercicio 2
    @Test
    void testWschoolPrompt() {
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

    // ejemplo iFrame
    @Test
    void testIframeHolaMundo() {
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

    // ejercicio 1
    @Test
    void testIframeParrafo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.quackit.com/html/html_editors/scratchpad/?example=/html/tutorial/html_iframe_example");

        // Cambiar al iframe que contiene el editor
        driver.switchTo().frame("preview").switchTo().frame(0);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Encontrar el elemento <h1> y cambiar su contenido
        WebElement parrafoElement = driver.findElement(By.xpath("/html/body/p[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = 'Texto modificado con Selenium'",
                parrafoElement);

        // (Opcional) Cambiar de nuevo al contenido principal fuera del iframe
        driver.switchTo().defaultContent();
    }

    // ejercicio 2
    @Test
    void testCalculadoraWschool() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/angular/tryit.asp?filename=try_ng_binding");

        // Cambiar al iframe que contiene el editor
        driver.switchTo().frame("iframeResult");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Encontrar el elemento <h1> y cambiar su contenido
        // WebElement calculadoraElement =
        // driver.findElement(By.cssSelector("input[ng-model=\"quantity\"]"));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].value = '5'",
        // calculadoraElement);
        WebElement calculadoraElement = driver.findElement(By.cssSelector("input[ng-model=\"quantity\"]"));
        calculadoraElement.sendKeys(Keys.BACK_SPACE + "5\n");
        ;
        // (Opcional) Cambiar de nuevo al contenido principal fuera del iframe
        driver.switchTo().defaultContent();
    }
    // ejemplo dropdowns

    @Test
    void testdropdowns() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.switchTo().frame("iframeResult");
        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Saab");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Saab");
        driver.quit();
    }

    // ejercicio 1
    @Test
    void ejercicio1dropdown() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://getbootstrap.com/docs/4.3/components/dropdowns/");
        try {

            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement dropdownButton = wait
                    .until(ExpectedConditions.elementToBeClickable(By.id("id_del_boton_del_dropdown")));

            // Hacer clic en el botón del dropdown
            dropdownButton.click();

            // Esperar a que la opción "Action" sea clickeable y hacer clic en ella
            WebElement actionOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'dropdown-menu')]//a[contains(text(), 'Action')]")));
            actionOption.click();

            // Pausa para ver el resultado antes de cerrar el navegador
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }

    // ejercicio 2
    @Test
    void eje2dropdowns() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.switchTo().frame("iframeResult");
        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Volvo");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Volvo");
        driver.quit();
    }
    // integrador1

    @Test
    void integrador1() throws InterruptedException {
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

        // Volver al contexto de la página principal
        driver.switchTo().defaultContent();

        // Ir a la página de HTML select tags
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option");

        // Cambiar al iframe "iframeResult"
        driver.switchTo().frame("iframeResult");

        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Volvo");

        // Pausa para ver el resultado antes de cerrar el navegador
        Thread.sleep(3000);

        driver.quit();

    }

    // integrador 2
    @Test
    void integrador2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        // Iniciar el navegador
        WebDriver driver = new ChromeDriver();

        // Navegar a la página
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");

        driver.switchTo().frame("iframeResult");

        // Seleccionar "Saab" del dropdown
        WebElement dropdown = driver.findElement(By.id("cars"));
        dropdown.click();
        WebElement saabOption = driver.findElement(By.cssSelector("#cars option[value='saab']"));
        saabOption.click();

        // Usar JavaScript para generar una alerta que diga "Seleccionado Saab"
        String script = "alert('Seleccionado Saab');";
        ((JavascriptExecutor) driver).executeScript(script);

        // Esperar a que aparezca la alerta y luego aceptarla
        WebDriverWait wait = new WebDriverWait(driver, 2);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        // Pausa para ver el resultado antes de cerrar el navegador
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    void practicaIntegradora(){
        WebDriverManager.chromedriver().setup();
        // Iniciar el navegador
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("li.resp-tab-item:first-child")).click();
        driver.findElement(By.cssSelector("#post-2632 > div.twelve.columns > div > div > div.single_tab_div.resp-tab-content.resp-tab-content-active > a")).click();

        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handles);
        driver.switchTo().window(handlesList.get(1));

        driver.findElement(By.id("iFrame")).click();
        driver.switchTo().frame("globalSqa");

        driver.findElement(By.cssSelector("span#current_filter")).click();
        driver.findElement(By.cssSelector("#current_filter")).click();
        driver.findElement(By.cssSelector("img[alt=\"Manual Online Testing Training\"]")).click();

        WebElement tituloManualTest = driver.findElement(By.cssSelector("#wrapper > div > div.full_container_page_title > div > div > div > div.page_heading > h1"));
        String tituloString = tituloManualTest.getText();

        assertEquals("Manual Testing Training", tituloString);



        driver.quit();
    }


}


    
   

