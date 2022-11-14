package br.com.aula.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static br.com.aula.pages.HomePage.btnCookies;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginPage extends BasePage{

    private static final By btnEntre =
            By.cssSelector("#nav-header-menu > a:nth-child(2)");

    private static final By campoLogin =
            By.cssSelector("#user_id");

    private static final By btnContinuar =
            By.cssSelector("#login_user_form > div.login-form__actions > button");
    // button.andes-button
    // /html/body/main/div/div[1]/div/div[2]/form/div[2]/button

    private static final By paginaLoginVendaValidate =
            By.xpath("/html/body/main/div/div[1]/div/div[2]/div/h1");

    private static final By paginaLoginRoboValidate =
            By.cssSelector("div.input-error:nth-child(2) > div:nth-child(1)");

    @Step("Clica no botão \"entrar\"")
    public void acessarTelaLogin(){
        click(btnCookies);
        click(btnEntre);
    }

    @Step("Escreve um email inexistente no campo de login")
    public void escreverLoginInexistente(){
       sendKeys(campoLogin,"esteloginnaoexiste@email.com");
    }

    @Step("Escreve um email válido no campo de login")
    public void escreverLoginValido(){
        sendKeys(campoLogin,"robotesteqadbc@gmail.com");
    }

    @Step("Clica no botão continuar")
    public void clicarContinuarLogin(){
        click(btnContinuar);
    }

    @Step("Valida mensagem de captcha")
    public String validarMensagemDoRobo(){
        return getText(paginaLoginRoboValidate);
    }

    @Step("Valida mensagem de Login ao tentar vender deslogado")
    public String validarMensagemDeLoginAoTentarVenderDeslogado(){
        return getText(paginaLoginVendaValidate);
    }

}
