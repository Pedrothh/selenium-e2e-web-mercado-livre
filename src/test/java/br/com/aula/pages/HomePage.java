package br.com.aula.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;


public class HomePage extends BasePage{

    private static final By campoPesquisar =
            By.cssSelector("#cb1-edit");
    private static final By btnBuscar =
            By.cssSelector(".nav-icon-search");

    private static final By btnProduto =
            By.xpath("//*[@id=\"root-app\"]/div/div[3]/section/section/div[2]/div/div/div/div[1]/div/div/a");

    private static final By btnProduto2 =
            By.xpath("//*[@id=\"root-app\"]/div/div/section[2]/div/div[2]/div/div[1]/div/div[1]/div/div/div[1]/a");
    static final By btnCookies =
            By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");
    private static final By dropdownCategorias =
            By.xpath("//*[@class=\"nav-menu\"]/ul/li[2]/a");
    private static final By itemVeiculos =
            By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[1]/a");

    private static final By btnCep =
            By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");

    private static final By btnContato =
            By.xpath("/html/body/header/div/div[2]/ul/li[7]/a");

    private static final By btnVender =
            By.xpath("/html/body/header/div/div[2]/ul/li[6]/a");

    private static final By btnModa =
            By.xpath("/html/body/header/div/div[2]/ul/li[5]/a");

    private static final By btnOfertas =
            By.xpath("/html/body/header/div/div[2]/ul/li[3]/a");

    private static final By itemMaisVendidos =
            By.cssSelector("body > header > div > div.nav-menu > ul > li:nth-child(2) > div > ul > li:nth-child(19) > a");

    private static final By itemMaisVendidosXpath =
            By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[19]/a");



    private static final By itemTecnologia =
            By.cssSelector("body > header > div > div.nav-menu > ul > li:nth-child(2) > div > ul > li.nav-categs-departments__list.nav-categs-departments__list--dynamic > a");

    private static final By itemTecnologiaXpath =
            By.xpath("/html/body/header/div/div[2]/ul/li[2]/div/ul/li[3]/a");

    private static final By itemEquipamentoParaDj =
            By.cssSelector("div.nav-categs-detail__categ:nth-child(4) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)");


    @Step("Escreve no campo pesquisar")
    public void escreverNoCampoPesquisar(){
        click(btnBuscar);
        sendKeys(campoPesquisar, "tv 55");
    }

    @Step("Clica no botao Buscar")
    public void clicarNoBotaoBuscar(){
        click(btnBuscar);
    }

    @Step("Clica no produto")
    public void selecionarProduto(){
        click(btnCookies);
        try {
            click(btnProduto);
        } catch (Exception err) {
            click(btnProduto2);
        }

    }

    @Step("Clica no botão(dropdown) Categorias e escolhe a opção categoria")
    public void clicaEmCategorias(){
        click(btnCookies);
        click(dropdownCategorias);
    }

    @Step("CLica em Veículos")
    public void clicaEmVeiculos(){
        click(itemVeiculos);
    }

    @Step("Clica no botao Informe seu CEP")
    public void clicarNoBotaoCep()  {
        click(btnCookies);
        click(btnCep);
    }

    @Step("Clica no botão Contato")
    public void clicarNoBotaoContato() {
        click(btnCookies);
        click(btnContato);
    }

    @Step("Clica no botão Vender")
    public void clicarNoBotaoVender() {
        click(btnCookies);
        click(btnVender);
    }

    @Step("Clica no botão Moda")
    public void clicarNoBotaoModa() {
        click(btnCookies);
        click(btnModa);
    }

    @Step("Clica no botão Ofertas do dia")
    public void clicarNoBotaoOfertas() {
        click(btnCookies);
        click(btnOfertas);
    }

    @Step("Clica em Mais Vendidos")
    public void clicaEmMaisVendidos(){
        try {
            click(itemMaisVendidos);
        } catch (Exception err){
            click(itemMaisVendidosXpath);
        }
    }

    @Step("Clica em Tecnologia")
    public void clicaEmTecnologia(){
        try {
            click(itemTecnologia);
        } catch (Exception err){
            click(itemTecnologiaXpath);
        }

    }

    @Step("Clica em Equipamentos para Djs")
    public void clicaEmEquipamentosParaDjs(){
        click(itemEquipamentoParaDj);
    }

    @Step("Valida url redirecionada")
    public void validaUrl(String buscada){
        Assert.assertThat(driver.getCurrentUrl(), containsString(buscada));
    }


}
