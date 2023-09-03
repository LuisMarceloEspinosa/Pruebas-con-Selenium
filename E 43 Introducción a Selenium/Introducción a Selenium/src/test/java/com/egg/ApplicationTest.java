package com.egg;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    // Ejercicio 1: Abrir el navegador y navegar hacia una página web

    @Test
    void ejercicio1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.close();
    }
    // Ejercicio 2: Manipular la ventana del navegador

    @Test
    void ejercicio2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.close();
    }

    // Ejercicio 3: Navegación hacia atrás y hacia delante
    @Test
    void ejercicio3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.openai.com");
        driver.navigate().back();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        driver.navigate().forward();
        driver.close();
    }

    // Practica Integradora:
    // 1. Abrir el navegador y navegar a la página de inicio de Google.
    // 2. Maximizar la ventana del navegador. 
    // 3. Navegar a la página de inicio de
    // OpenAI.
    // 4. Reducir la ventana del navegador a la mitad de su tamaño y centrarla en la
    // pantalla.
    // 5. Navegar a la página de inicio de Wikipedia.
    // 6. Cambiar el tamaño de la ventana del navegador a su tamaño original
    // 7. Cerrar el navegador
    @Test
    void integradora() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://www.openai.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Dimension originalWindowSize = driver.manage().window().getSize();
        int halfWidth = originalWindowSize.getWidth() / 2;
        int halfHeight = originalWindowSize.getHeight() / 2;
        Dimension halfWindowSize = new Dimension(halfWidth, halfHeight);
        driver.manage().window().setSize(halfWindowSize);

        int centerX = (originalWindowSize.getWidth() - halfWidth) / 2;
        int centerY = (originalWindowSize.getHeight() - halfHeight) / 2;
        driver.manage().window().setPosition(new org.openqa.selenium.Point(centerX, centerY));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://www.wikipedia.org");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
// Abrir una nueva ventana y una nueva pestaña
    @Test
    void nuevaVentanaYPestaña() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        // WebDriver driver1 = new ChromeDriver();

        driver.get("https://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.wikipedia.org','_blank');");

        String mainWindowHandle = driver.getWindowHandle();

// Obtén los identificadores de todas las ventanas abiertas
Set<String> allWindowHandles = driver.getWindowHandles();

// Itera a través de los identificadores para encontrar la nueva ventana
for (String handle : allWindowHandles) {
    if (!handle.equals(mainWindowHandle)) {
        // Cambia el enfoque a la nueva ventana
        driver.switchTo().window(handle);
        break;
    }
         
        // driver1.get("https://www.wikipedia.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    }
}
