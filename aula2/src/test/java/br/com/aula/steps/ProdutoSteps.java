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

    ProdutoPage produtoPage = new ProdutoPage();

    @Test
    @Epic("Detalhes Produto")
    @DisplayName("validar redirecionamento para Tela com detalhes do Produto")
    public void validarRedirecionamentoTelaDetalhesProduto(){
        homePage.selecionarProduto();

        Assert.assertEquals("Descrição", produtoPage.validarTelaDetalhesProduto());
    }

    @Test
    @Epic("Adicionar Produto ao Carrinho")
    @DisplayName("validar redirecionamento para Tela Login ao tentar adicionar produto ao Carrinho")
    public void validarRedirecionamentoTelaLoginClicarAddCarrinho(){
        validarRedirecionamentoTelaDetalhesProduto();

        produtoPage.clicarAddCarrinho();

        Assert.assertThat(driver.getCurrentUrl(), containsString("login"));
    }
}
