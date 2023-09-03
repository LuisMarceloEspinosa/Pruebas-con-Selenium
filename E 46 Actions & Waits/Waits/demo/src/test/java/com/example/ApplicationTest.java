package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

class ApplicationTest {

  @Test
  void shouldAnswerWithTrue() {
    assertTrue(true);
  }
  
  // waits

  @Test
  void Ejercicio1waits() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    driver.findElement(By.tagName("textarea")).click();
    WebElement searchBox = driver.findElement(By.cssSelector("textarea#APjFqb"));
    searchBox.sendKeys("Selenium");

    searchBox.click();
  }
 

  @Test
  void TwitterWait() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    // Encontrar el elemento del cuadro de búsqueda por su atributo 'name'
    WebElement searchBox = driver.findElement(By.name("q"));

    // Realizar alguna operación con el cuadro de búsqueda (por ejemplo, enviar
    // texto)
    searchBox.sendKeys("Prueba de búsqueda");

    // Cerrar el navegador después de un tiempo para ver el cuadro de búsqueda lleno
    try {
      Thread.sleep(5000); // Esperar 5 segundos antes de cerrar el navegador
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Cerrar el navegador
    driver.quit();
  }

  @Test
  void youtube() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.youtube.com/watch?v=pPPXqTAnkKU");

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    // Desplazarnos hacia abajo en la página para cargar la sección de comentarios
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    // Esperar un breve tiempo para que se carguen los comentarios
    try {
      Thread.sleep(5000); // Esperar 5 segundos para cargar comentarios (ajusta según sea necesario)
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Encontrar el elemento que muestra la cantidad de comentarios
    WebElement commentsCountElement = driver.findElement(By.xpath("//h2[@id='count']"));
    String commentsCountText = commentsCountElement.getText();

    // Extraer el número de comentarios
    int numberOfComments = Integer.parseInt(commentsCountText.replaceAll("[^0-9]", ""));

    System.out.println("Cantidad de comentarios: " + numberOfComments);

    driver.quit();
  }

  @Test
  void youtube1() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.youtube.com/watch?v=pPPXqTAnkKU");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 1500);");

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    int commentsCountElement = driver.findElements(By.id("content-text")).size();
    System.out.println(commentsCountElement);
    driver.quit();
  }

  /*
   * 3. Esperar 45 segundos a que se cargue la sección de comentarios de un video
   * que quieras en YouTube y contar la cantidad de comentarios
   */
  @Test
  void driverWaitYoutube() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 45);
    driver.get("https://www.youtube.com/watch?v=pglK_ioATk4");
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ytd-comments#comments")));
    driver.manage().window().maximize();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 900);");
    // driver.findElement(By.cssSelector("body")).sendKeys(Keys.END); otra posible
    // solucion envez de usar el js executor
    int numero = driver.findElements(By.cssSelector("span.yt-formatted-string[dir=auto]")).size(); // falta arreglar que
                                                                                                   // cuente los
                                                                                                   // comentarios
    System.out.println(numero);
    // driver.quit();
  }

  /*
   * 4. Esperar a que se carguen los resultados de búsqueda en Amazon y obtener el
   * precio del primer producto.
   */
  @Test
  void driverWaitAmazon() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.amazon.com");
    try {
      Thread.sleep(9000);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
    driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Headphones");
    driver.findElement(By.id("nav-search-submit-button")).click();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    String precio = driver.findElement(By.cssSelector("span.a-price-whole")).getText();
    System.out.println(precio);
  }

  // Explicit wait
  // Esperar a que aparezca el cuadro de búsqueda en Google

  // Esperar a que el botón "Login" sea clickeable en GitHub

  // Esperar a que se cargue la lista de categorías en Wikipedia

  // Esperar a que esté disponible el menú desplegable de idioma en la página de
  // Facebook
  @Test
  void explicit1() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    element.sendKeys("Prueba de búsqueda en Google");
    driver.quit();
  }

  // *2- Esperar a que el botón "Login" sea clickeable en GitHub */

  /**
   * 
   */
  @Test
  void waitLogInButtonGithub() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.github.com");
    driver.manage().window().maximize();
    final WebDriverWait wait = new WebDriverWait(driver, 15);
    WebElement element = wait
        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.HeaderMenu-link--sign-in")));
    element.click();
  }

  @Test
  void Ejercicio3wait() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
    driver.manage().window().maximize();
    final WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-port")));
  }

  @Test
  void waitLanguageFacebook() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.facebook.com");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector(
        "a._51sy[ajaxify=\"/settings/language/language/?uri=https%3A%2F%2Fja-jp.facebook.com%2F&source=www_list_selector_more\"]"))
        .click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("language_container")));
  }
  // waitt fluent
  // 1. Esperar a que aparezca el logo en la página principal de Wikipedia

  @Test
  void waitFluent() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

    final int[] pollingCount = { 0 };
    Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(org.openqa.selenium.NoSuchElementException.class);

    wait.until(new Function<WebDriver, WebElement>() {
      public WebElement apply(WebDriver driver) {
        pollingCount[0]++;
        return driver.findElement(By.className("mw-logo-icon"));
      }
    });
    System.out.println("Cantidad de veces que se realizó polling: " + pollingCount[0]);

    driver.quit();
  }
  // 2. Esperar a que se cargue la sección de imágenes destacadas en Unsplash

  @Test
  void waitFluent2() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://unsplash.com/");
    final int[] pollingCount = { 0 };
    Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(1))
        .ignoring(org.openqa.selenium.NoSuchElementException.class);

    wait.until(new Function<WebDriver, WebElement>() {
      public WebElement apply(WebDriver driver) {
        pollingCount[0]++;

        return driver.findElement(By.className("mItv1"));
      }
    });

    System.out.println("Cantidad de veces que se realizó polling: " + pollingCount[0]);

    driver.quit();
  };

  // 3. Esperar a que se cargue el banner principal en la página de tecnología de
  // BBC
  @Test
  void waitFluent3() {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.bbc.com/news/technology");

    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(20))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(org.openqa.selenium.NoSuchElementException.class);
  }

  // 4. Esperar a que se cargue la sección de "Top Stories" en la página de
  // noticias de CNN
  // Estos ejercicios te ayudarán a comprender cómo aplicar Fluent Wait en
  // situaciones reales
  // sin la necesidad de interactuar con páginas que requieran inicio de sesión o
  // creación de una cuenta.

  @Test
  void waitFluent4() {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("https://edition.cnn.com/");

    Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(20))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(org.openqa.selenium.NoSuchElementException.class);

    wait.until(new Function<WebDriver, WebElement>() {
      public WebElement apply(WebDriver driver) {

        return driver.findElement(By.cssSelector(".cn__headline"));
      }
    });
    System.out.println("La sección de Top Stories se ha cargado.");

    driver.quit();
  }

  // Ejercicio 1: Búsqueda en Google con Implicit Wait
  // Objetivo: Realizar una búsqueda en Google y hacer clic en el primer enlace de
  // resultados,
  // utilizando Implicit Wait.

  @Test
  void Ejercicio1Integrador() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.findElement(By.tagName("textarea")).click();
    WebElement searchBox = driver.findElement(By.cssSelector("textarea#APjFqb"));
    searchBox.sendKeys("Selenium");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.className("wM6W7d")).click();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    WebElement firstResult = driver.findElement(
        By.cssSelector("#rso > div.hlcw0c > div > div > div > div > div > div > div > div.yuRUbf > div > a"));
    firstResult.click();
  }

  @Test
  void integradora2() {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.bbc.com/news/technology");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement imagen = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
        "#topos-component > div.mpu-available > div:nth-child(1) > div > div.nw-c-seven-slice.gel-layout__item.gs-u-pb\\+\\@m.gel-1\\/1\\@xl.gel-1\\/1\\@xxl.gs-u-ml0.nw-o-keyline.nw-o-no-keyline\\@m.gs-u-display-block\\@xs.gs-u-display-block\\@l.gs-u-display-block\\@xl.gs-u-display-none\\@xxl > div > div.gs-c-promo-image.gs-u-mb.gs-u-mb0\\@xs.gel-2\\/3\\@m.gel-1\\/2\\@xl")));
    imagen.click();

  }

  @Test
  void practicaExplicitWait() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.bbc.com/news/technology");
    driver.manage().window().maximize();

    WebDriverWait wait = new WebDriverWait(driver, 10);

    WebElement imgBbcElement = wait
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#homepage-link > svg")));
    imgBbcElement.click();
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.quit();
  }
  @Test
  void integradora3() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

    
    WebElement searchInput = driver.findElement(By.id("searchform"));

        // Type the search term
        searchInput.sendKeys("Selenium");

        // Submit the search form
        searchInput.submit();

        // Fluent Wait setup
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        // Wait for the search results page to load
        WebElement resultsHeading = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(".searchresults"));
            }
        });

        // Print the heading of the search results page
        System.out.println("Search results page loaded: " + resultsHeading.getText());

        driver.quit();
  }
  @Test
void practicaFluentWait(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.wikipedia.org/");
    driver.manage().window().maximize();

    WebElement inputBuscador= driver.findElement(By.cssSelector("input#searchInput"));
    inputBuscador.sendKeys("Selenium"+Keys.ENTER);

    Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(org.openqa.selenium.NoSuchElementException.class);
    
    

    wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
            return driver.findElement(By.cssSelector("#mw-content-text > div.mw-parser-output"));
            }});

    
    driver.quit();

}
}
