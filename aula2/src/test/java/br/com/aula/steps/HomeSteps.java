package br.com.aula.steps;

import br.com.aula.pages.SearchPage;
import br.com.aula.pages.HomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class HomeSteps extends BaseSteps {

    HomePage homePage = new HomePage();

    SearchPage searchPage = new SearchPage();

    @Test
    @Epic("Barra de Pesquisa")
    @DisplayName("validar busca de produto")
    public void validarBuscaDeProduto() {
        homePage.escreverNoCampoPesquisar();
        homePage.clicarNoBotaoBuscar();

        Assert.assertThat(driver.getCurrentUrl(), containsString("tv"));
        Assert.assertEquals("Tv 55", searchPage.validarTextNaTela());
    }

}
