package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ModalPage extends BasePage {

    private static final By textValidateCep =
            By.xpath("/html/body/main/div/div[1]/h1");

    @Step("Validando texto na tela")
    public String validarTextNoModalCep(){
        return getText(textValidateCep);
    }
}
