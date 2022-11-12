package br.com.aula.steps;

import br.com.aula.pages.HomePage;
import br.com.aula.pages.ProdutoPage;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class ProdutoSteps extends BaseSteps{

    HomePage homePage = new HomePage();

    HomeSteps homeSteps = new HomeSteps();


    ProdutoPage produtoPage = new ProdutoPage();


    @Test
    @Epic("Adicionar Produto ao Carrinho")
    @DisplayName("validar redirecionamento para Tela Login ao tentar adicionar produto ao Carrinho")
    public void validarRedirecionamentoTelaLoginClicarAddCarrinho(){
        homeSteps.validarRedirecionamentoDetalhesProduto();

        produtoPage.clicarAddCarrinho();

        Assert.assertThat(driver.getCurrentUrl(), containsString("login"));
    }

    @Test
    @Epic("Adicionar Produto aos Favoritos")
    @DisplayName("validar redirecionamento para Tela Login ao tentar adicionar produto aos Favoritos")
    public void validarRedirecionamentoTelaLoginClicarAddFavoritos(){
        homeSteps.validarRedirecionamentoDetalhesProduto();

        produtoPage.clicarAddFavoritos();

        Assert.assertEquals(produtoPage.validarErroFavoritarProduto(), "Olá! Para adicionar aos favoritos, acesse a sua conta");

    }
}
