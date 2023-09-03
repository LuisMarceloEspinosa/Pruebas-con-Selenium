package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /*Seleccion por ID
     * En grupo, encuentren al menos 4 páginas web que
     * contengan atributos del tipo ID y utilizen las acciones getElement y
     * sendKeys para identificarlos y llenar con datos en caso que el elemento lo
     * permita.
     */

    @Test
    void seleccionPorID() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        driver.findElement(By.id("APjFqb")).sendKeys("wikipedia");

        driver.navigate().to("https://zoom.us/es/signin#/login");

        driver.findElement(By.id("email")).sendKeys("prueba@prueba.com");

        driver.navigate().to("https://www.bing.com");

        driver.findElement(By.id("sb_form_q")).sendKeys("youtube");

        driver.navigate().to("https://search.brave.com/");

        driver.findElement(By.id("searchbox")).sendKeys("mercado libre");

        driver.quit();
    }

    /* Seleccion por Name
     * Localiza al menos 3 elementos distintos por Name
     * y envía un valor o haz click en ellos según los elementos
     * lo permitan.
     */

    @Test
    void seleccionPorName() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.wikipedia.org");

        driver.findElement(By.name("search")).sendKeys("Selenium");

        driver.navigate().to("https://zoom.us/es/signin#/login");

        driver.findElement(By.name("email")).sendKeys("prueba@prueba.com");

        driver.findElement(By.name("password")).sendKeys("password123test");

        driver.quit();
    }

    /* Seleccion por linkText
     * Toma las páginas que has utilizado anteriormente
     * y localiza al menos un link en cada una de ellas
     * y automatiza la acción click.
     */

    @Test
    void seleccionPorLinkText() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.alibaba.com/");

        driver.findElement(By.linkText("Ready to Ship")).click();

        driver.get("https://zoom.us/es/signin#/login");

        driver.findElement(By.linkText("Soporte")).click();

        driver.get("https://www.google.com");

        driver.findElement(By.linkText("Gmail")).click();

        driver.get("https://www.amazon.com/");

        driver.findElement(By.linkText("Sell")).click();

        driver.get("https://www.mercadolibre.com.ar/");

        driver.findElement(By.linkText("Ayuda")).click();

        driver.quit();

    }

    /* Integradora 
     * ¡Excelente! Has aprendido cómo identificar elementos por ID,
     * Name y LinkText.
     * 
     * Ahora crea una prueba que:
     * 
     * Abra el navegador en Chrome.
     * 
     * Vaya a una URL de tu preferencia.
     * 
     * Identifique un elemento por ID.
     * 
     * Vaya a otra URL.
     * 
     * Identifique un elemento por LinkText.
     * 
     * Haga click en ese elemento.
     * 
     * Cierre el navegador.
     */

    @Test
    void integradorDePruebas() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.findElement(By.id("APjFqb")).sendKeys("wikipedia");

        driver.get("https://zoom.us/es/signin#/login");

        driver.findElement(By.linkText("Soporte")).click();

        driver.quit();
    }
    //           Seleccion por className
    // 1. Encuentra todos los botones que existan en una página web de tu
    // preferencia y cuéntalos.

    @Test
    void ejercicio1Botones() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        int botons = driver.findElements(By.className("")).size();
        System.out.println(botons);
        driver.quit();

    }
    // 2. Encuentra cuántas imágenes tiene este producto.

    // 3. Encuentra todos los productos en este link y cuenta cuáles pertenecen a
    // Star Wars.
    @Test
    public void ejercicio3StarWars() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.thisisfeliznavidad.com/por-producto/retro-sweaters/?mpage=5");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);

        List<WebElement> cont_productos = driver.findElements(By.className("js-item-name"));

        String fraseBuscada = "Star Wars";
        int contador = 0;

        for (WebElement cont_producto : cont_productos) {
            if (cont_producto.getText().contains(fraseBuscada)) {
                contador++;
            }
        }

        System.out.println(contador);
        driver.quit();
    }    
        // Seleccion por tagName
    // 1. Identifica cuántos encabezados de jerarquía 2 hay en este link.

    @Test
    void encabezados2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wizardingworld.com/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        int encabezados = driver.findElements(By.tagName("h2")).size();
        System.out.println(encabezados);
    }
    // 2. Encuentra y haz click en el primer link de esa página.
    @Test
    void ejercicio2tag() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wizardingworld.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.tagName("a")).click();
        driver.quit();

    }
    // 3. Identifica cuántas imágenes hay en este link.
    @Test
    void ejercicio3tag() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.infobae.com/");

        int imagenes = driver.findElements(By.tagName("img")).size();
        System.out.println(imagenes);
        driver.quit();

    }
    // 4. Encuentra el primer botón de la página anterior y haz click en el.
    @Test
    void ejercicio4tag() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.infobae.com/");
        Thread.sleep(3000);

        driver.findElement(By.tagName("button")).click();
        driver.quit();
    }
              // Integradora

    @Test
    void Integradora() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        WebElement buscador = driver.findElement(By.name("search"));
        buscador.sendKeys("Oro");
        buscador.submit();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement firstLink = driver.findElement(By.cssSelector("body"));
        firstLink.click();

        // Esperar un momento para que la página se cargue
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cerrar el navegador
        driver.quit();
    }

    @Test
    void Integradoraejemplo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("hidrógeno");
        searchBox.submit();

        // Esperar un momento para que los resultados se carguen
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encontrar y hacer clic en el primer enlace de resultados
        WebElement firstLink = driver.findElement(By.tagName("a"));
        firstLink.click();

        // Esperar un momento para que la página se cargue
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
