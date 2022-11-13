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

    static final By btnCookies =
            By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");
    private static final By dropdownCategorias =
            By.xpath("//*[@class=\"nav-menu\"]/ul/li[2]/a");
    private static final By itemVeiculos =
            By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a");

    private static final By btnCep =
            By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");

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
        click(btnCookies);
        click(btnProduto);
    }

    @Step("Clico no dropdown Categorias e escolho a opção categoria")
    public void clicaEmCategorias(){
        click(btnCookies);
        click(dropdownCategorias);
    }

    public void clicaEmVeiculos(){
        click(itemVeiculos);
    }

    @Step("Clicando no botao Informe seu CEP")
    public void clicarNoBotaoCep()  {
        click(btnCookies);
        click(btnCep);
    }



}
