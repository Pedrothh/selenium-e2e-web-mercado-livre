package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProdutoPage extends BasePage{
    private static final By detalhesValidate =
            By.cssSelector("#ui-pdp-main-container > div.ui-pdp-container__col.col-3.ui-pdp-container--column-center.pb-40 > div > div:nth-child(6) > div > div > h2");

    private static final By btnAddCarrinho =
            By.cssSelector("#buybox-form > div.ui-pdp-actions > div > button.andes-button.andes-spinner__icon-base.andes-button--quiet");
        public String validarTelaDetalhesProduto(){
        return getText(detalhesValidate);
    }


    public void clicarAddCarrinho(){
        click(btnAddCarrinho);
    }
}
