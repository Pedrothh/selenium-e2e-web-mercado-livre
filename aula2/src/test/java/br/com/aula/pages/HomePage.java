package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private static final By campoPesquisar =
            By.cssSelector("#cb1-edit");
    private static final By btnBuscar =
            By.cssSelector(".nav-icon-search");

    private static final By btnProduto =
            By.cssSelector("#root-app > div > div:nth-child(3) > section > section > div.carousel-container > div > div > div > div:nth-child(1)");

    @Step
    public void escreverNoCampoPesquisar(){
        sendKeys(campoPesquisar, "tv 55");
    }

    @Step("clicando no botao")
    public void clicarNoBotaoBuscar(){
        click(btnBuscar);
    }

    @Step("clicando no produto")
    public void selecionarProduto(){
        click(btnProduto);
    }



}
