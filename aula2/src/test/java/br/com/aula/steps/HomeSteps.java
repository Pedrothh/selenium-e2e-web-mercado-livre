package br.com.aula.steps;

import br.com.aula.pages.BannerPage;
import br.com.aula.pages.LoginPage;
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

    BannerPage bannerPage = new BannerPage();

    LoginPage loginPage = new LoginPage();

    @Test
    @Epic("Barra de Pesquisa")
    @DisplayName("validar busca de produto")
    public void validarBuscaDeProduto() {
        homePage.escreverNoCampoPesquisar();
        homePage.clicarNoBotaoBuscar();

        Assert.assertThat(driver.getCurrentUrl(), containsString("tv"));
        Assert.assertEquals("Tv 55", searchPage.validarTextNaTela());
    }
    @Test
    @Epic("Barra de Pesquisa")
    @DisplayName("validar pesquisa quando não há inserção na barra de texto")
    public void validarBuscaProdutoSemTextoInserido(){
        homePage.clicarNoBotaoBuscar();

        Assert.assertEquals("https://www.mercadolivre.com.br/", driver.getCurrentUrl());
    }

    @Test
    @Epic("Plantão Black Friday")
    @DisplayName("validar redirecionamento página de Ofertas da Black Friday")
    public void validarRedirecionamentoPlantaoBlackFriday(){
        bannerPage.clicarPlantaoBlackFriday();

        Assert.assertEquals("PLANTÃO BLACK FRIDAY", bannerPage.validarTextNaTela());
    }


    @Test
    @Epic("Login")
    @DisplayName("validar o redirecionamento para tela login")
    public void validarRedirecionamentoTelaLogin(){
        loginPage.acessarTelaLogin();

        Assert.assertEquals("Olá! Digite o seu telefone, e-mail ou usuário", loginPage.validarTextLogin());
        Assert.assertThat(driver.getCurrentUrl(), containsString("login"));
    }



    @Test
    @Epic("Login")
    @DisplayName("validar redirecionamento para Pagina Login-Senha")
    public void validarRedirecionamentoLoginSenha(){
        validarRedirecionamentoTelaLogin();

        loginPage.escreverLoginValido();
        loginPage.clicarContinuarLogin();

        Assert.assertEquals("Agora, sua senha do Mercado Livre", loginPage.validarEmailValido());
    }



}
