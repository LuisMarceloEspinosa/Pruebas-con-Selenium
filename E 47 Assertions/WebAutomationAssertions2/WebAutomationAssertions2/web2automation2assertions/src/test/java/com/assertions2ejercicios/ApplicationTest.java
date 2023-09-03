package com.assertions2ejercicios;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

class ApplicationTest {
    /* Ejercicio 1: Verificar que la página de inicio de Google esté cargada. */

    @Test
    void assertionTrueGoogle() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        boolean elemento = driver.findElement(By.cssSelector("body")).isDisplayed();
        System.out.println(elemento);
        assertTrue(elemento);
        driver.quit();
    }

    /* Ejercicio 2: Verificar que un producto esté disponible en Amazon. */
    @Test
    void assertionTrueProductoAmazon() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(10000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones" + Keys.ENTER); // se puede concatenar
                                                                                              // acciones en la barra de
                                                                                              // busqueda
        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER); //
        // otra manera de resolver
        boolean producto = driver.findElement(By.cssSelector("a.a-link-normal")).isEnabled();
        System.out.println(producto);
        assertTrue(producto);
        driver.quit();
    }

    /*
     * Ejercicio 3: Verificar que un enlace a "Contacto" exista en un sitio web de
     * ejemplo.
     */
    @Test
    void assertionTrueHuertas() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://mundohuertas.com.ar/");
        driver.manage().window().maximize();
        driver.findElement(By.id("wpn-close-btn")).click();
        List<WebElement> ListaNav = driver.findElements(By.className("desktop-nav-link"));
        int numNav = ListaNav.size();
        System.out.println(numNav);
        int contador = 0;
        for (WebElement contacto : ListaNav) {
            if (contacto.getText().contains("Contacto")) {
                contador++;
            }
        }
        System.out.println(contador);
        // assertTrue(numNav.size());
    }

    @Test
    void assertionhuerta() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://mundohuertas.com.ar/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.id("wpn-close-btn")).click();
        List<WebElement> contactLinks = driver.findElements(By.cssSelector(
                "#container > div.js-main-content.main-content > div.row-fluid.desktop-head > div.span8.hidden-phone.desktop-nav-container > ul > li:nth-child(3) > a"));
        System.out.println(contactLinks);
        assertTrue(contactLinks.size() > 0);
        contactLinks.get(0).click();
    }

    /* .js-desktop-nav > li:nth-child(3) > a:nth-child(1) */
    /*
     * html body.template-home div#container div.js-main-content.main-content
     * div.row-fluid.desktop-head div.span8.hidden-phone.desktop-nav-container
     * ul.js-desktop-nav.desktop-nav li.desktop-nav-item a.desktop-nav-link
     */
    @Test
    void assertionstrueHueta() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://mundohuertas.com.ar/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.id("wpn-close-btn")).click();
        int cantidadEnlaces = driver.findElements(By.className("desktop-nav-link")).size();
        WebElement contacto = driver.findElement(By.className("a.desktop-nav-link[href=/contacto/]"));
        contacto.click();
        // assertTrue(contacto == "/contacto/");
    }

    /* AssertFalseEjercicios */
    /*
     * Ejercicio 1: Verificar que el botón de búsqueda está deshabilitado en Google
     * sin texto en la barra de búsqueda
     */
    @Test
    void assertFalseBtnGoogle() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        String busqueda = driver.findElement(By.id("APjFqb")).getText();
        boolean boton = !driver.findElement(By.className("gNO89b")).isEnabled();
        System.out.println(busqueda);
        assertFalse(boton);
        driver.quit();
    }

    /*
     * Ejercicio 2: Verificar que el checkbox "Recuérdame" no está marcado en la
     * página de inicio de sesión de GitHub
     */
    @Test
    void assertionFalseCheckboxAlibaba() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.alibaba.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        boolean checkbox = !driver.findElement(By.id("fm-keep-login")).isSelected();
        assertFalse(checkbox);
        driver.quit();
    }

    /*
     * Ejercicio 3: Verificar que una imagen específica no está visible en la página
     * de Wikipedia (puedes elegir una imagen que sepas que no esté en la página)
     */
    @Test
    void assertFalseWikipedia() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        driver.manage().window().maximize();
        driver.findElement(By.className("cdx-text-input__input")).sendKeys("imagen inexistente" + Keys.ENTER);
        int imagen = driver.findElements(By.cssSelector("mw-search-result")).size();
        // WebElement resultado =
        // driver.findElements(By.cssSelector("mw-search-result")).get(2);
        // String atributoAlt = resultado.getAttribute("svg");
        assertFalse(imagen > 0);
        driver.quit();
    }
    // List<WebElement> tercerResultado =
    // driver.findElements(By.cssSelector("searchResultImage-thumbnail"));
    // tercerResultado.size();
    // WebElement placeholder =
    // driver.findElement(By.cssSelector("searchResultImage-thumbnail-placeholder"));

    /* Ejercicios AssertNull */
    /*
     * Ejercicio 1: Verificar que un elemento inexistente en una página no se
     * encuentre (ejemplo, en la página de Google)
     */
    @Test
    void assertNullGoogle() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        // Intentar encontrar un elemento que no existe (por ejemplo, un botón con un ID
        // falso)
        WebElement elemento = null;
        try {
            elemento = driver.findElement(By.id("elemento-inexistente"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // No hacer nada, ya que esperamos que el elemento no se encuentre
        }

        // Verificar que el elemento es nulo (inexistente)
        assertNull(elemento, "El elemento inexistente no debería estar presente");

        driver.quit();
    }

    /*
     * Ejercicio 2: Verificar que una imagen sin atributo "alt" no tenga dicho
     * atributo (puedes elegir cualquier URL)
     */
    @Test
    void assertNullWikipedia() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://es.wikipedia.org/wiki/Catedral_de_Upsala");
        WebElement imagen = driver.findElement(By.cssSelector("a.mw-file-description"));
        String atributoAlt = imagen.getAttribute("alt");
        assertNull(atributoAlt);
        driver.quit();
    }

    /*
     * Ejercicio 3: Verificar que un campo de texto no tenga valor por defecto
     * (puedes usar el search box de Wikipedia o los campos de inicio de sesión en
     * Facebook)
     */
    @Test
    void assertNullSearchGoogle() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        WebElement buscador = driver.findElement(By.cssSelector("textarea#APjFqb[value]"));
        String value = buscador.getAttribute("");
        assertNull(value);
        driver.quit();
    }

    @Test
    void inte1() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.bing.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        assertTrue(searchBox.isDisplayed());

        WebElement listasugerida = driver.findElement(By.cssSelector("div.sa_as"));
        System.out.println(listasugerida);
        assertFalse(listasugerida.isDisplayed());
    }

    @Test
    void conteoDeBotones() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/about/careers");
        driver.manage().window().maximize();
        driver.findElement(
                By.cssSelector("#engineering > div > h3 > button > span.float-right.d-inline-block.my-4.f3-mktg"))
                .click();
        driver.findElement(By.cssSelector("#engineering ul li"));
        List<WebElement> elementos = driver.findElements(By.cssSelector("#engineering ul li"));
        int contadorEngineer = 0;
        String textoObjetivo = "engineer";
        for (WebElement elemento : elementos) {
            String texto = elemento.getText().toLowerCase();
            System.out.println("Texto del elemento: " + texto);
            String[] palabras = texto.split("\\s+");
            for (String palabra : palabras) {
                if (palabra.equals(textoObjetivo)) {
                    contadorEngineer++;
                    break;
                }
            }
        }
        System.out.println("Número de elementos que contienen 'engineer': " + contadorEngineer);
        assertTrue(contadorEngineer > 0, "El contador 'contadorEngineer' no coincide con el valor esperado");
        driver.quit();
    }
     @Test
    void c() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

        // Verificar el título de la página
        String tituloEsperado = "Wikipedia, la enciclopedia libre";
        String tituloActual = driver.getTitle();
        assertEquals(tituloEsperado, tituloActual);

        // Verificar la presencia del logo
        WebElement logo = driver.findElement(By.id("p-logo"));
        assertTrue(logo.isDisplayed());
    }
      /**
     * @throws InterruptedException
     */
    @Test
    void cy() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       
        
        WebDriverWait wait = new WebDriverWait(driver, null);
       
         driver.get("https://www.google.com");

        // Verificar la existencia del enlace "Gmail"
        By enlaceGmail = By.linkText("Gmail");
        wait.until(ExpectedConditions.presenceOfElementLocated(enlaceGmail));
        WebElement enlace = driver.findElement(enlaceGmail);

        // Realizar una búsqueda en Google
        String terminoBusqueda = "Selenium WebDriver";
        WebElement cajaBusqueda = driver.findElement(By.name("q"));
        cajaBusqueda.sendKeys(terminoBusqueda);
        cajaBusqueda.sendKeys(Keys.RETURN);

        // Verificar el título de la página de resultados
        String tituloEsperado = terminoBusqueda + " - Buscar con Google";
        wait.until(ExpectedConditions.titleContains(tituloEsperado));
        String tituloActual = driver.getTitle();
        assert tituloActual != null;
        assert tituloActual.contains(tituloEsperado);
    }
}
