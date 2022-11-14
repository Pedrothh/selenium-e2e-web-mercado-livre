package br.com.aula.steps;

import br.com.aula.pages.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class HomeSteps extends BaseSteps {

    HomePage homePage = new HomePage();

    SearchPage searchPage = new SearchPage();

    BannerPage bannerPage = new BannerPage();

    LoginPage loginPage = new LoginPage();

    ModalPage modalPage = new ModalPage();

    @Test
    @Epic("Header")
    @Feature("Barra de Pesquisa")
    @DisplayName("Validar busca de produto válido")
    public void validarBuscaDeProduto() {
        homePage.escreverNoCampoPesquisar();
        homePage.clicarNoBotaoBuscar();

        homePage.validaUrl("tv");
        Assert.assertEquals("Tv 55", searchPage.validarTextNaTela());
    }
    @Test
    @Epic("Header")
    @Feature("Barra de Pesquisa")
    @DisplayName("Validar pesquisa quando não há inserção na barra de texto")
    public void validarBuscaProdutoSemTextoInserido(){
        homePage.clicarNoBotaoBuscar();

        Assert.assertEquals("https://www.mercadolivre.com.br/", driver.getCurrentUrl());
    }

    @Test
    @Epic("Banner")
    @Feature("Plantão Black Friday")
    @DisplayName("Validar redirecionamento página de Ofertas da Black Friday")
    public void validarRedirecionamentoPlantaoBlackFriday(){
        bannerPage.clicarPlantaoBlackFriday();


        if (bannerPage.validarTextNaTela().equals("PLANTÃO BLACK FRIDAY")) {
            homePage.validaUrl("plantao-black-friday");
        } else if (bannerPage.validarTextNaTela().equals("Veículos")) {
            homePage.validaUrl("acessorios-para-veiculos");
        } else {
            System.out.println(bannerPage.validarTextNaTela());
        }

    }


    @Test
    @Epic("Header")
    @Feature("Login")
    @DisplayName("Validar o redirecionamento para tela login")
    public void validarRedirecionamentoTelaLogin(){
        loginPage.acessarTelaLogin();

        homePage.validaUrl("login");
    }


    @Test
    @Epic("Header")
    @Feature("Detalhes Produto")
    @DisplayName("Validar redirecionamento para tela com Detalhes de um produto")
    public void validarRedirecionamentoDetalhesProduto(){
       homePage.selecionarProduto();

        homePage.validaUrl("produto");

    }

    @Test
    @Epic("Header")
    @Feature("Botão Categorias")
    @Story("Redirecionar por veículos")
    @DisplayName("Validar o redirecionamento para categoria por Veículos no botão Categorias")
    public void testeDeveValidarDropdownListaCategorias(){
        homePage.clicaEmCategorias();
        homePage.clicaEmVeiculos();

        Assert.assertEquals("https://www.mercadolivre.com.br/c/carros-motos-e-outros#menu=categories", driver.getCurrentUrl());
    }

    @Test
    @Epic("Header")
    @Feature("Botão informe seu CEP")
    @DisplayName("Validar o modal de informar o CEP")
    public void testeDeveValidarModalCep() throws InterruptedException {
        homePage.clicarNoBotaoCep();

        Assert.assertEquals(modalPage.validarTextNoModalCep(), "Selecione onde quer receber suas compras");
        Assert.assertEquals(modalPage.validarPlaceholderNoModalCep(), "Informar um CEP");
    }

    @Test
    @Epic("Header")
    @Feature("Botão informe seu CEP")
    @DisplayName("Validar buscar CEP pelo modal de informar o CEP")
    public void testeDeveValidarBuscarCepModalCep() throws InterruptedException {
        homePage.clicarNoBotaoCep();
        modalPage.escreverNoTextModal();
        modalPage.clicaNoBotaoUsarCep();

        Assert.assertEquals(modalPage.validarEnderecoDoCepBuscado(), "João Pessoa 58030020");
    }

    @Test
    @Epic("Header")
    @Feature("Botão informe seu CEP")
    @DisplayName("Validar erro ao deixar o numero do CEP em branco e tentar clicar no botão usar")
    public void testeDeveMostrarErroAoTentarValidarBuscarCepModalCepSemPassarUmCepValido() throws InterruptedException {
        homePage.clicarNoBotaoCep();
        modalPage.clicaNoBotaoUsarCepComSleep();

        Assert.assertEquals(modalPage.validarSpanInformarCepObrigatorio(), "Preencha esse dado.");
    }

    @Test
    @Epic("Header")
    @Feature("Botão Contato")
    @DisplayName("Validar o redirecionamento ao clicar no botão Contato")
    public void testeDeveRedirecionarParaPaginaContato() {
        homePage.clicarNoBotaoContato();

        homePage.validaUrl("ajuda");

    }

    @Test
    @Epic("Header")
    @Feature("Botão Vender")
    @DisplayName("Validar o redirecionamento ao clicar no botão Vender")
    public void testeDeveRedirecionarParaLoginAoClicarEmVenderSemEstarLogado() {
        homePage.clicarNoBotaoVender();

        Assert.assertThat(loginPage.validarMensagemDeLoginAoTentarVenderDeslogado().toLowerCase(), containsString("para vender"));
        homePage.validaUrl("login");
    }

    @Test
    @Epic("Header")
    @Feature("Botão Moda")
    @DisplayName("Validar o redirecionamento ao clicar no botão Moda")
    public void testeDeveRedirecionarParaPaginaModa() {
        homePage.clicarNoBotaoModa();

        homePage.validaUrl("roupas");
    }

    @Test
    @Epic("Header")
    @Feature("Botão Ofertas do dia")
    @DisplayName("Validar o redirecionamento ao clicar no botão Ofertas do dia")
    public void testeDeveRedirecionarParaPaginaOfertas() {
        homePage.clicarNoBotaoOfertas();

        homePage.validaUrl("ofertas");
    }

    @Test
    @Epic("Header")
    @Feature("Botão Categorias")
    @Story("Filtrar por produtos mais vendidos")
    @DisplayName("Validar o redirecionamento para página de produtos mais vendidos")
    public void testeDeveRedirecionarParaMaisVendidos(){
        homePage.clicaEmCategorias();
        homePage.clicaEmMaisVendidos();

        homePage.validaUrl("mais-vendidos");
    }

    @Test
    @Epic("Header")
    @Feature("Botão Categorias")
    @Story("Filtrar por Equipamento para Djs")
    @DisplayName("Validar o redirecionamento para página de Equipamento para Djs")
    public void testeDeveRedirecionarParaEquipamentoParaDjs(){
        homePage.clicaEmCategorias();
        homePage.clicaEmTecnologia();
        homePage.clicaEmEquipamentosParaDjs();

        homePage.validaUrl("equipamento-djs");
    }


}
