package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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

}
