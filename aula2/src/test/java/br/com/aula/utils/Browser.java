package br.com.aula.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void browserUp(String url) {
        // Informando a automação qual app vai utilizar
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
<<<<<<< HEAD
        wait = new WebDriverWait(driver, 10);
=======
        wait = new WebDriverWait(driver, 5);
>>>>>>> 5704127cfea358d17aa6668aa75a6bd0be56fbce

        // Abrir navegador = .get
        driver.get(url);
        // Maximar
        driver.manage().window().maximize();
        // daley
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    public void browserDown() {
        driver.quit();
    }
}