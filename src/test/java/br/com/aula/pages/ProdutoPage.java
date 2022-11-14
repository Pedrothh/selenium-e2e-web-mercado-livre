package br.com.aula.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;


public class ProdutoPage extends BasePage{


    private static final By btnAddCarrinho =
            By.cssSelector("button.andes-spinner__icon-base:nth-child(2) > span:nth-child(1)");

    public static final By btnFavoritos =
            By.cssSelector("svg.ui-pdp-icon--bookmark:nth-child(1)");


    @Step("Clica em adicionar ao carrinho")
    public void clicarAddCarrinho(){
        click(btnAddCarrinho);
    }

    @Step("Valida no ícone coração (em adicionar aos favoritos)")
    public void clicarAddFavoritos(){
        click(btnFavoritos);
    }

    public void validaUrlLogin(){
        Assert.assertThat(driver.getCurrentUrl(), containsString("login"));
    }
}
