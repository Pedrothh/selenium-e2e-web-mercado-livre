package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage{

    private static final By campoPesquisar =
            By.cssSelector("#cb1-edit");
    private static final By btnBuscar =
            By.cssSelector(".nav-icon-search");

    private static final By btnProduto =
            By.cssSelector("#root-app > div > div:nth-child(3) > section > section > div.carousel-container > div > div > div > div:nth-child(1)");


    private static final By dropdownCategorias =
            By.xpath("//*[@class=\"nav-menu\"]/ul/li[2]/a");
    private static final By itemVeiculos =
            By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a");

    @Step("Escrevendo no campo pesquisar")
    public void escreverNoCampoPesquisar(){
        sendKeys(campoPesquisar, "tv 55");
    }

    @Step("Clicando no botao Buscar")
    public void clicarNoBotaoBuscar(){
        click(btnBuscar);
    }

    @Step("Clicando no produto")
    public void selecionarProduto(){
        click(btnProduto);
    }

    @Step("Clicando no dropdown Categorias")
    public void clicaEmCategorias(){
        try {
            click(dropdownCategorias);
            driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[2]")).click();
        } catch (org.openqa.selenium.ElementNotInteractableException err){
            waitElement(dropdownCategorias);
            click(dropdownCategorias);
            driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[2]")).click();
        }

    }

    @Step("Clicando no item Veículos")
    public void clicaEmVeiculos(){
        click(itemVeiculos);


//        driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a")));
//            click((By) element);
//
//            waitElement(itemVeiculos);
//            driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();
//
//        } catch (Exception err) {
//            //waitElement(dropdownCategorias);
//            waitElement(itemVeiculos);
//            driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();
//        }


    }



}
