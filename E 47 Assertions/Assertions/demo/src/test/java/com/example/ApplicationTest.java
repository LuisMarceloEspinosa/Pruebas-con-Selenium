package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;



class ApplicationTest {

  @Test
  void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  // Ejemplo de assertion en Google
  @Test
  void assertionEjemploGoogle() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.google.com");
    String titulo = driver.getTitle();
    System.out.println(titulo);
    assertEquals("Google", titulo);
    driver.quit();
  }

  /* Ejercicios assertEquals */
  /*
   * Ejercicio 1: Verificar el Título de una Página Objetivo:
   * Verificar que el título de la página principal de Wikipedia sea correcto.
   */
  @Test
  void assertionTituloWikipedia() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.wikipedia.org");
    String titulo = driver.getTitle();
    System.out.println(titulo);
    assertEquals("Wikipedia", titulo);
    driver.quit();
  }

  /*
   * Ejercicio 2: Verificar el Texto de un Botón Objetivo:
   * Verificar que el texto del botón "Buscar con Google" en la página principal
   * de
   * Google sea correcto.
   */ // Alt + z para identar codigo a la pantalla
  @Test
  void assertionBtnGoogle() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    String boton = driver.findElement(By.cssSelector("input.gNO89b")).getAttribute("aria-label");
    System.out.println(boton);
    assertEquals("Buscar con Google", boton);
    driver.quit();
  }

  /*
   * Ejercicio 3: Verificar la URL de un Enlace Objetivo:
   * Verificar que el enlace a la página de inicio de sesión en Twitter tenga la
   * URL correcta.
   */
  /*
   * En la linea del string login, se puede usar el Selector
   * ("a[data-testid=loginButton]")
   */
  // En vez de usar el quilombo de findElements y clase duplicadas aveces se puede
  // usar atributo
  // como un ID en caso de ser unico.
  @Test
  void assertionLinkTwitter() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.twitter.com");
    driver.manage().window().maximize();
    String login = driver.findElements(By.cssSelector("a.css-4rbku5")).get(4).getAttribute("href");
    System.out.println(login);
    assertEquals("https://twitter.com/login", login);
    driver.quit();
  }

  /* Ejercicios assertNotEquals */
  /*
   * Ejercicio 1: Verificar que el título de una página no sea una cadena vacía
   * Objetivo: Asegurarse de que el título de la página de inicio de YouTube no
   * sea una cadena vacía.
   */
  @Test
  void assertionTituloYoutube() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.youtube.com");
    String titulo = driver.getTitle();
    System.out.println(titulo);
    assertNotEquals("", titulo);
    driver.quit();
  }

  /*
   * Ejercicio 2: Verificar que el texto de un encabezado no sea un valor
   * particular Objetivo: Verificar que el texto del encabezado principal en la
   * página de Wikipedia en inglés no sea "Enciclopedia Libre".
   */
  @Test
  void assertionEncabezadoWikipedia() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://en.wikipedia.org/wiki/Main_Page");
    String encabezado = driver.findElement(By.cssSelector("img.mw-logo-tagline")).getAttribute("alt");
    System.out.println(encabezado);
    assertNotEquals("Enciclopedia Libre", encabezado);
    driver.quit();
  }

  /*
   * Ejercicio 3: Verificar que el texto del botón de Inicio de Sesión no sea
   * "Iniciar Sesión" Objetivo: Verificar que el texto del botón de inicio de
   * sesión en la página de inicio de Twitter no sea "Iniciar Sesión" (suponiendo
   * que el texto correcto sea diferente, como "Log in"). Este ejercicio verifica
   * que el texto del botón de inicio de sesión en Twitter no sea una traducción
   * incorrecta o un valor inesperado. Si la página de inicio de Twitter utiliza
   * un texto diferente para el botón de inicio de sesión, como "Log in", esta
   * prueba asegurará que el texto incorrecto "Iniciar Sesión" no esté presente.
   */
  /* En la linea del string login, se puede usar el linkText ("Sign in") */
  // En vez del quilombo de findElements y clases duplicadas, se puede aplicar
  // link text
  // Solucion encontrada por Claudia
  @Test
  void assertionBtnLoginTwitter() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.twitter.com");
    driver.manage().window().maximize();
    String login = driver.findElements(By.cssSelector("span.css-16my406")).get(12).getText();
    String login2 = driver.findElement(By.linkText("Sign in")).getText();
    System.out.println(login);
    System.out.println(login2);
    assertNotEquals("Iniciar Sesi\u00F3n", login);
    assertNotEquals("Iniciar Sesi\\u00F3n", login2);
    driver.quit();
  }

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
        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER); // otra manera de resolver
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
        boolean encontrado = false;
        for (WebElement contacto : ListaNav) {
            if (contacto.getText().contains("Contacto")) {
                encontrado=true;
            }
        }
        System.out.println(encontrado);
        assertTrue(encontrado);
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
        String busqueda = driver.findElement(By.id("APjFqb")).getAttribute("value");
        boolean boton =! driver.findElement(By.className("gNO89b")).isEnabled();
        System.out.println(busqueda);
        assertEquals(busqueda,"");
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
        boolean checkbox =! driver.findElement(By.id("fm-keep-login")).isSelected();
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
        int resultado = driver.findElements(By.cssSelector("table.searchResultImage")).size();
        int noimagen = driver.findElements(By.cssSelector("div.searchResultImage-thumbnail-placeholder")).size();
        assertFalse(resultado == noimagen);
        driver.quit();
    }
    
    
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
     /*Ejercicio 1: Verificar el título de la página de Wikipedia y el logo
        En este ejercicio combinarás la localización de elementos mediante ID, 
        la utilización de assertions para verificar el título de la página y un Implicit Wait 
        para asegurar que la página se haya cargado correctamente. */
    @Test
    void assertIntegradorWikipedia() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.wikipedia.org");
        String titulo = driver.getTitle();
        System.out.println(titulo);
        assertNotEquals("", titulo);
        driver.manage().timeouts().implicitlyWait(15, null);
        boolean logo = driver.findElement(By.cssSelector("img.central-featured-logo")).isDisplayed();
        assertTrue(logo);
        driver.quit();
    }
    /*  Ejercicio 2: Comprobar la existencia de un enlace y realizar una búsqueda en Google

        Para este ejercicio utilizarás un Explicit Wait para esperar a que el elemento link esté presente, 
        la ejecución de una acción (enviar una búsqueda) y la verificación del resultado utilizando una aserción.*/
        @Test
        void assertIntegradorGoogle() {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.google.com");
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body"))).isDisplayed();
            String link = driver.findElement(By.cssSelector("a.gb_y")).getAttribute("href");
            System.out.println(link);
            assertEquals(link, "https://mail.google.com/mail/&ogbl");
            driver.findElement(By.id("APjFqb")).sendKeys("Matematicas" + Keys.ENTER);
            boolean resultado = driver.findElement(By.id("res")).isDisplayed();
            assertTrue(resultado);
            driver.quit();
        }
        /*Ejercicio 3: Verificar el cambio de idioma en la página de Wikipedia

        En este ejercicio deberás emplear un implicit wait, una acción para hacer click y 
        un assertion de igualdad para comparar un tipo de texto que ha sido traducido al español. 
        Recomendamos probar con el título de la página.  */
        @Test
        void assertionIntegradorWikipedia() {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.get("https://en.wikipedia.org/wiki/Jos%C3%A9_de_San_Mart%C3%ADn");
            driver.manage().window().maximize();
            String tituloEN = driver.getTitle();
            System.out.println(tituloEN);
            driver.manage().timeouts().implicitlyWait(7, null);
            driver.findElement(By.id("p-lang-btn-checkbox")).click();
            driver.findElement(By.cssSelector("a.autonym[lang=es]")).click();
            String tituloES = driver.getTitle();
            System.out.println(tituloES);
            assertNotEquals(tituloEN, tituloES);
            driver.quit();
        }
        /*Ejercicio 4: Verificar la función de búsqueda en YouTube

        Aquí deberás usar un explicit wait que espere a que el resutlado de una búsqueda se haga presente 
        y un assert que indique que sí hay elementos presentes luego de la búsqueda. No olvides la acción de .sendkeys. */
        @Test
        void assertIntegradorYoutube() throws InterruptedException {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.youtube.com/");
            Thread.sleep(20000);
            driver.findElement(By.cssSelector("input#search")).sendKeys("Chihuahuas");
            driver.findElement(By.cssSelector("input#search")).sendKeys(Keys.ENTER); // No se puede concatenar en el buscador de youtube
            //driver.findElement(By.cssSelector("search-icon-legacy")).click(); // otra solucion es darle click al boton de busqueda
            WebDriverWait wait = new WebDriverWait(driver, 9);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#primary"))).isDisplayed();
            driver.manage().window().maximize();
            boolean resultado = driver.findElement(By.cssSelector("div.ytd-two-column-search-results-renderer")).isDisplayed();
            assertTrue(resultado);
            driver.quit();
        }

        @Test
        void assertSameGoogle() {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.google.com/");
            //WebElement botonS = driver.findElement(By.cssSelector("input.gNO89b[type=submit]"));
            WebElement botonV = driver.findElement(By.cssSelector("input.RNmpXc[type=submit]"));
            assertSame(botonV, botonV);
            driver.quit();
        }
        @Test
        void assertThrowGoogle() {
            assertThrows(NoSuchElementException.class, () -> {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.google.com/");
            driver.findElement(By.id("clase-prueba"));
            driver.quit();
        });
        }

}
