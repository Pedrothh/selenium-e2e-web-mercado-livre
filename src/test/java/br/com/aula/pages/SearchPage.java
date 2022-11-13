package br.com.aula.pages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage{

    private static final By textValidate =
            By.cssSelector(".ui-search-breadcrumb__title");

    public String validarTextNaTela(){
        return getText(textValidate);
    }

}
