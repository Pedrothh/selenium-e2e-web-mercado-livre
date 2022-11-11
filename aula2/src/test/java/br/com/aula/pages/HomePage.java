package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    //MAPEAMENTO
    private static final By campoPesquisar =
            By.cssSelector("#cb1-edit");
    private static final By btnBuscar =
            By.cssSelector(".nav-icon-search");

    @Step
    public void escreverNoCampoPesquisar(){
        sendKeys(campoPesquisar, "tv 55");
    }

    @Step("clicando no botao")
    public void clicarNoBotaoBuscar(){
        click(btnBuscar);
    }


}
