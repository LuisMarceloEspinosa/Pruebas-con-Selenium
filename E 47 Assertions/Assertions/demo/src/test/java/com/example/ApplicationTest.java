package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;




class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /* 1. Etiqueta + ID: Encuentra el cuadro de búsqueda en Google por su etiqueta y ID.

2. Etiqueta + Clase: Encuentra y haz clic en el primer enlace en la barra de navegación en la página de inicio de GitHub. 3. Etiqueta + Atributo: Encuentra el botón "Sign Up" en la página de inicio de Twitter.

4. Etiqueta + Clase + Atributo: Encuentra el enlace "Forgot password?" en la página de inicio de sesión de LinkedIn. 5. Etiqueta + Clase: Encuentra y haz clic en el primer artículo "Trending" en Medium. 6. Etiqueta + Clase: Encuentra y haz clic en el enlace "Contact" en el pie de página del sitio Stack Overflow. 7. Etiqueta + ID: Encuentra y muestra la descripción del primer producto en la página de inicio de Amazon.

8. Etiqueta + Atributo: Encuentra y muestra el título del primer video en la página de inicio de YouTube.

✨ Estos ejercicios son de tipo complementario. Esto quiere decir que te ayudará a avanzar en profundidad en el tema visto, pero no son obligatorios.

1. Inicia sesión en LinkedIn y navega hasta tu perfil.

2. Navega a una lista de reproducción en YouTube y muestra el título de los primeros 5 videos.

3. Navega a Amazon, realiza una búsqueda, luego filtra los resultados por una categoría específica. 4. Navega a una página de Wikipedia, selecciona una sección y muestra las referencias utilizadas en esa sección.

5. Navega a Pixabay, realiza una búsqueda de imágenes y explora la primera galería.

6. Navega a Best Buy, busca un producto y verifica si su precio está por debajo de un valor determinado. 7. Navega a FlightStats, rastrea un vuelo por su número y muestra el estado.

8. Navega a AllRecipes, busca una receta y muestra los ingredientes.
     */

     @Test
     void Ejercicio1() {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.google.com/");
         WebElement searchBox = driver.findElement(By.cssSelector("textarea#APjFqb"));
        
        // Realizar una acción en el cuadro de búsqueda, por ejemplo, escribir "Selenium"
        searchBox.sendKeys("Selenium");
     }

      @Test
     void Ejercicio2() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://github.com/");
         driver.manage().window().maximize();
         Thread.sleep(3000);
         WebElement searchBox = driver.findElement(By.cssSelector("a.px-2"));
        
        
        searchBox.click();
     }
       @Test
     void Ejercicio3() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://twitter.com/?lang=es");
         driver.manage().window().maximize();
         Thread.sleep(3000);
         WebElement searchBox = driver.findElement(By.cssSelector("[role=button]"));
        
        
        searchBox.click();
     }

        @Test
     void Ejercicio4() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.linkedin.com/");
         driver.manage().window().maximize();
         Thread.sleep(3000);
         WebElement searchBox = driver.findElement(By.cssSelector("a.font-sans[href=\"https://www.linkedin.com/uas/request-password-reset?trk=homepage-basic_forgot_password\"]"));
        
        
        searchBox.click();
     }
             @Test
     void Ejercicio5() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://medium.com/");
         driver.manage().window().maximize();
         Thread.sleep(3000);
         WebElement searchBox = driver.findElement(By.cssSelector("a.ii[href]"));
        
        
        searchBox.click();
     }
@Test
     void Ejercicio6() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://es.stackoverflow.com/");
         driver.manage().window().maximize();
         Thread.sleep(3000);
         WebElement searchBox = driver.findElement(By.cssSelector("a.js-gps-track -link"));
        
        
        searchBox.click();
     }
     @Test
     void Ejercicio7() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.amazon.com");
         driver.manage().window().maximize();
         Thread.sleep(3000);
         WebElement searchBox = driver.findElement(By.cssSelector("a.js-gps-track -link"));
        
        
        searchBox.click();
     }
    
   /*Ejercicio integrador de selectores 7, 1. Navegar a la página de Wikipedia de una ciudad, 
    leer el primer párrafo y acceder a la página de su país. */
    @Test
    void cityTestCountry() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        driver.manage().window().maximize();
        driver.findElement(By.id("searchInput")).sendKeys("Roma");
        driver.findElement(By.cssSelector("button.cdx-search-input__end-button")).click();
        String parrafo = driver.findElement(By.tagName("p")).getText();
        System.out.println(parrafo);
        driver.findElement(By.linkText("Italia")).click();
    }
//assertions
       @Test 
    public void testWikipediaTitle() { 
      WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
      driver.get("https://www.wikipedia.org");
      String element = driver.getTitle();
     //buscar elemento title y guardar como variable de texto; //
     assertEquals("Wikipedia", element); 
     driver.quit();

}
     @Test 
    public void eje2() { 
      WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
      driver.get("https://www.google.com/");
      driver.findElement(By.cssSelector("input.gNO89B"));
       String google = driver.getTitle();
     //buscar elemento title y guardar como variable de texto; //
     assertEquals("Wikipedia", google); 
     driver.quit();

}
 @Test 
    public void eje4() { 
      WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
      driver.get("https://www.YouTube.com/");
       

        // Navega a la página de inicio de YouTube
        driver.get("https://www.youtube.com");

        // Obtén el título de la página
        String pageTitle = driver.getTitle();

        // Verifica que el título no sea una cadena vacía
        assertNotEquals("", pageTitle);

        // Cierra el navegador
        driver.quit();
    }

    @Test 
    public void eje7() { 
      WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
      driver.get("https://twitter.com/?lang=es");
       

       
 // Encuentra el elemento del botón de inicio de sesión
 WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));

 // Obtén el texto del botón de inicio de sesión
 String buttonText = loginButton.getText();

 // Verifica que el texto no sea "Iniciar Sesión"
 assertNotEquals("Iniciar Sesión", buttonText);

 // Cierra el navegador
 driver.quit();
    }

    // Ejercicio 1: Verificar que la página de inicio de Google esté cargada.

    @Test
    void assertionEjemploGoogle() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        WebElement elemento = driver.findElement(By.cssSelector("body"));
        System.out.println(elemento);
        assertTrue(elemento.isDisplayed(),"not");
        
        driver.quit();
    }
    
/* Ejercicio 2: Verificar que un producto esté disponible en Amazon. */
    @Test
    void eje2r() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.amazon.com"); // Reemplaza PRODUCT_ID con el ID real del producto
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones");
        driver.findElement(By.id("twotabsearchtextbox")).submit();
        // Encuentra el botón de agregar al carrito
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));

        // Verifica si el botón está habilitado (producto disponible)
        assertTrue(addToCartButton.isEnabled(),"El producto no está disponible");

        // Cierra el navegador
        driver.quit();
    }
    /* Ejercicio 2: Verificar que un producto esté disponible en Amazon. */
    @Test
    void assertionEjemploGoogles () throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(10000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones"+Keys.ENTER); // se puede concatenar acciones en la barra de busqueda
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER); // otra manera de resolver
        boolean producto = driver.findElement(By.cssSelector("a.a-link-normal")).isEnabled();
        System.out.println(producto);
        assertTrue(producto);
        driver.quit();
    }
    //Ejercicio 3
      @Test 
    public void eje734() throws InterruptedException { 
      WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
      driver.get("https://mundohuertas.com.ar/");
     driver.manage().window().maximize();
      Thread.sleep(5000);
      driver.findElement(By.id("wpn-close-btn")).click();
    
        
        java.util.List<WebElement> contactLinks = driver.findElements(By.cssSelector("#container > div.js-main-content.main-content > div.row-fluid.desktop-head > div.span8.hidden-phone.desktop-nav-container > ul > li:nth-child(3) > a"));
        System.out.println(contactLinks);
        
        assertTrue( contactLinks.size() > 0,"No se encontró ningún enlace a 'Contacto'");
        contactLinks.get(0).click();

        
        driver.quit();

    }
//Ejercicio 1.2
      @Test 
    public void eje12() throws InterruptedException { 
      WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
      driver.get("https://www.google.com");
       driver.manage().window().maximize();

      
      WebElement searchButton = driver.findElement(By.name("btnK"));
      WebElement searchField = driver.findElement(By.name("q"));
      

     
      // assertFalse(searchButton.isEnabled(), "El botón de búsqueda no está deshabilitado");
      assertFalse(searchField==null, "La barra esta vacia");
      
      
      driver.quit();
}
}
