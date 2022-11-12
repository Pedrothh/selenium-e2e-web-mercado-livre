package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProdutoPage extends BasePage{
    private static final By detalhesValidate =
            By.cssSelector("#ui-pdp-main-container > div.ui-pdp-container__col.col-3.ui-pdp-container--column-center.pb-40 > div > div:nth-child(6) > div > div > h2");

    private static final By btnAddCarrinho =
            By.cssSelector("#buybox-form > div.ui-pdp-actions > div > button.andes-button.andes-spinner__icon-base.andes-button--quiet");

    public static final By btnFavoritos =
            By.cssSelector("#ui-pdp-main-container > div.ui-pdp-container__col.col-3.ui-pdp-container--column-center.pb-40 > div > div.ui-pdp-container__row.ui-pdp-with--separator--fluid.ui-pdp-with--separator--40 > div.ui-pdp-container__col.col-2.mr-32 > div.ui-pdp-container__top-wrapper.mt-40 > form > button > svg.ui-pdp-icon.ui-pdp-icon--bookmark.ui-pdp-bookmark__icon-bookmark");

    public static final By spanCarrosECaminhonetes =
            By.xpath("/html/body/main/div/div[3]/div/section/div/div/div[1]/div/div/button/span");

    public static final By divH2DynamicCarouselCarrosECaminhetes =
            By.xpath("/html/body/main/div/div[6]/section/section/div[1]/h2");


    public  static final By erroFavoritarProduto =
            By.cssSelector("#root-app > div > div.wrap > div > div.andes-card.andes-card--flat.andes-card--default.center-card__body.center-card__body--footerless.andes-card--padding-default > div > h1");


    public String validarTelaDetalhesProduto(){
        return getText(detalhesValidate);
    }

    public String validarErroFavoritarProduto(){
        return getText(erroFavoritarProduto);
    }

    public void clicarAddCarrinho(){
        click(btnAddCarrinho);
    }

    public void clicarAddFavoritos(){
        click(btnFavoritos);
    }


    @Step("Valido o texto \"Carros e Caminhonetes\" como primeiro filtro de busca ")
    public String validarTextoSpanCarrosECaminhonetes(){
        try {
        waitElement(spanCarrosECaminhonetes);
        return getText(spanCarrosECaminhonetes);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            waitElement(spanCarrosECaminhonetes);
            return getText(spanCarrosECaminhonetes);
        }
    }
    @Step("Valido o texto \"Carros e Caminhonetes\" na div de texto em cima do primeiro carrousel ")
    public String validarTextoDivH2CarrosECaminhonetes(){
        waitElement(spanCarrosECaminhonetes);
        waitElement(divH2DynamicCarouselCarrosECaminhetes);
        return getText(divH2DynamicCarouselCarrosECaminhetes);
    }

}
