package br.com.aula.steps;

import br.com.aula.pages.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class HomeSteps extends BaseSteps {

    HomePage homePage = new HomePage();

    SearchPage searchPage = new SearchPage();

    BannerPage bannerPage = new BannerPage();

    LoginPage loginPage = new LoginPage();

    ProdutoPage produtoPage = new ProdutoPage();

    ModalPage modalPage = new ModalPage();

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


        if (bannerPage.validarTextNaTela().equals("PLANTÃO BLACK FRIDAY")) {
            Assert.assertThat(driver.getCurrentUrl(), containsString("plantao-black-friday"));
        } else if (bannerPage.validarTextNaTela().equals("Veículos")) {
            Assert.assertThat(driver.getCurrentUrl(), containsString("acessorios-para-veiculos"));
        } else {
            System.out.println(bannerPage.validarTextNaTela());
        }

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

        //Assert.assertEquals("Agora, sua senha do Mercado Livre", loginPage.validarEmailValido());
    }

    @Test
    @Epic("Detalhes Produto")
    @DisplayName("validar redirecionamento para tela com Detalhes de um produto")
    public void validarRedirecionamentoDetalhesProduto(){

       homePage.selecionarProduto();

       Assert.assertEquals(produtoPage.validarTelaDetalhesProduto(), "Descrição");

    }

    @Test
    @Epic("Botão Categorias")
    @Feature("Categoria por Veículos")
    @DisplayName("Validar o redirecionamento para categoria por Veículos no botão Categorias")
    public void testeDeveValidarDropdownListaCategorias(){
        homePage.clicaEmCategorias();
        homePage.clicaEmVeiculos();

        Assert.assertEquals("https://www.mercadolivre.com.br/c/carros-motos-e-outros#menu=categories", driver.getCurrentUrl());
        Assert.assertThat(produtoPage.validarTextoSpanCarrosECaminhonetes().toLowerCase(), containsString("carros"));
        Assert.assertThat(produtoPage.validarTextoDivH2CarrosECaminhonetes().toLowerCase(), containsString("carros"));

    }

    @Test
    @Epic("Botão Informe seu CEP")
    @Feature("Abrir modal")
    @DisplayName("Validar o modal de informar o CEP")
    public void testeDeveValidarModalCep() throws InterruptedException {
        homePage.clicarNoBotaoCep();

        Assert.assertEquals(modalPage.validarTextNoModalCep(), "Selecione onde quer receber suas compras");
        Assert.assertEquals(modalPage.validarPlaceholderNoModalCep(), "Informar um CEP");
    }

    @Test
    @Epic("Botão Informe seu CEP")
    @Feature("Buscar endereço pelo CEP")
    @DisplayName("Validar buscar CEP pelo modal de informar o CEP")
    public void testeDeveValidarBuscarCepModalCep() throws InterruptedException {
        homePage.clicarNoBotaoCep();
        modalPage.escreverNoTextModal();
        modalPage.clicaNoBotaoUsarCep();

        Assert.assertEquals(modalPage.validarEnderecoDoCepBuscado(), "João Pessoa 58030020");
    }

    @Test
    @Epic("Botão Informe seu CEP")
    @Feature("Buscar endereço sem CEP")
    @DisplayName("Validar erro ao deixar o numero do CEP em branco e tentar clicar no botão usar")
    public void testeDeveMostrarErroAoTentarValidarBuscarCepModalCepSemPassarUmCepValido() throws InterruptedException {
        homePage.clicarNoBotaoCep();
        modalPage.clicaNoBotaoUsarCepComSleep();

        Assert.assertEquals(modalPage.validarSpanInformarCepObrigatorio(), "Preencha esse dado.");
    }

    @Test
    @Epic("Botão Contato")
    @DisplayName("Validar o redirecionamento ao clicar no botão Contato")
    public void testeDeveRedirecionarParaPaginaContato() {
        homePage.clicarNoBotaoContato();

        Assert.assertThat(driver.getCurrentUrl(), containsString("ajuda"));

    }

    @Test
    @Epic("Botão Vender")
    @DisplayName("Validar o redirecionamento ao clicar no botão Vender")
    public void testeDeveRedirecionarParaLoginAoClicarEmVenderSemEstarLogado() {
        homePage.clicarNoBotaoVender();

        Assert.assertThat(loginPage.validarMensagemDeLoginAoTentarVenderDeslogado().toLowerCase(), containsString("para vender"));
        Assert.assertThat(driver.getCurrentUrl(), containsString("login"));
    }

    @Test
    @Epic("Botão Moda")
    @DisplayName("Validar o redirecionamento ao clicar no botão Moda")
    public void testeDeveRedirecionarParaPaginaModa() {
        homePage.clicarNoBotaoModa();

        Assert.assertThat(driver.getCurrentUrl(), containsString("roupas"));
    }

    @Test
    @Epic("Botão Ofertas do dia")
    @DisplayName("Validar o redirecionamento ao clicar no botão Ofertas do dia")
    public void testeDeveRedirecionarParaPaginaOfertas() {
        homePage.clicarNoBotaoOfertas();

        Assert.assertThat(driver.getCurrentUrl(), containsString("ofertas"));
    }


}
