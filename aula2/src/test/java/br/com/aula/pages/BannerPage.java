package br.com.aula.pages;

import org.openqa.selenium.By;

import javax.swing.*;

public class BannerPage extends BasePage{
    private static final By textValidate =
            By.cssSelector("#root-app > div > div.ui-search-main.ui-search-main--deals.ui-search-main--without-header.ui-search-main--only-products.shops__search-main > aside > div.ui-search-breadcrumb.shops__breadcrumb > h1");

    public String validarTextNaTela(){
        return getText(textValidate);
    }

    private static final By plantaoBlackFriday =
            By.cssSelector("#root-app > div > div:nth-child(1) > section > div > div > div > div > div > div:nth-child(3) > a");

    public void clicarPlantaoBlackFriday(){
        click(plantaoBlackFriday);
    }

}
