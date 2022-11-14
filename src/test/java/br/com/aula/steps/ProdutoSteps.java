package br.com.aula.steps;

import br.com.aula.pages.HomePage;
import br.com.aula.pages.ProdutoPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class ProdutoSteps extends BaseSteps{

    HomePage homePage = new HomePage();
    ProdutoPage produtoPage = new ProdutoPage();


    @Test
    @Epic("Produto")
    @Feature("Adicionar Produto ao Carrinho")
    @DisplayName("validar redirecionamento para Tela Login ao tentar adicionar produto ao Carrinho")
    public void validarRedirecionamentoTelaLoginClicarAddCarrinho(){
        homePage.selecionarProduto();
        produtoPage.clicarAddCarrinho();

        produtoPage.validaUrlLogin();
    }

    @Test
    @Epic("Produto")
    @Feature("Adicionar Produto aos Favoritos")
    @DisplayName("validar redirecionamento para Tela Login ao tentar adicionar produto aos Favoritos")
    public void validarRedirecionamentoTelaLoginClicarAddFavoritos(){
        homePage.selecionarProduto();
        produtoPage.clicarAddFavoritos();

        produtoPage.validaUrlLogin();
    }
}
