package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage extends BasePage{

    private static final By textValidate =
            By.cssSelector(".ui-search-breadcrumb__title");

    @Step("Valida texto")
    public String validarTextNaTela(){
        return getText(textValidate);
    }

}
