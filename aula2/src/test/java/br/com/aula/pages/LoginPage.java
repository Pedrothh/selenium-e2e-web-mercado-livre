package br.com.aula.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final By btnEntre =
            By.cssSelector("#nav-header-menu > a:nth-child(2)");

    private static final By paginaLoginValidate =
            By.cssSelector("#root-app > div > div.wrap > div > div.andes-card.andes-card--flat.andes-card--default.center-card__body.center-card__body--footerless.andes-card--padding-default > div > h1");

    private static final By campoLogin =
            By.cssSelector("#user_id");

    private static final By campoSenha =
            By.cssSelector("#password");

    private static final By btnContinuar =
            By.cssSelector("#login_user_form > div.login-form__actions > button");

    private static final By btnEntrar =
            By.cssSelector("#action-complete > span");

    private static final By emailErrorValidate =
            By.cssSelector("#user_id-message > div > div");

    private static final By senhaErrorValidate =
            By.cssSelector("#login_user_form > div.login-form__row > div.login-form__input > div > div.andes-form-control__bottom > span > span > div > div");

    private static final By paginaLoginEmailValidate =
            By.cssSelector(" #root-app > div > div.wrap > div > div.andes-card.andes-card--flat.andes-card--default.center-card__body.center-card__body--footerless.andes-card--padding-default > div > h1 > div");



    public void acessarTelaLogin(){
        click(btnEntre);
    }

    public String validarTextLogin(){
        return getText(paginaLoginValidate);
    }

    public void escreverLoginInexistente(){
       sendKeys(campoLogin,"esteloginnaoexiste@email.com");
    }
    public void escreverSenhaInvalido(){
        sendKeys(campoSenha,"SenhaTotalmenteErrada");
    }

    public void escreverLoginValido(){
        sendKeys(campoLogin,"robotesteqadbc@gmail.com");
    }
    public void clicarContinuarLogin(){
        click(btnContinuar);
    }

    public void clicarEntrarLogin(){
        click(btnEntrar);
    }
    public String validarErroEmailNaoCadastrado(){
        return getText(emailErrorValidate);
    }
    public String validarEmailValido(){
        return getText(paginaLoginEmailValidate);
    }

    public String validarErroSenhaInvalida(){
        return getText(senhaErrorValidate);
    }

}
