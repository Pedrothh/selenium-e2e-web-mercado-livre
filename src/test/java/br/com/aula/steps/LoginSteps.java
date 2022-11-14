package br.com.aula.steps;

import br.com.aula.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage = new LoginPage();

    @Test
    @Epic("Pagina de Login")
    @Feature("Email inválido")
    @DisplayName("validar mensagem de erro ao tentar logar com email não cadastrado.")
    public void validarMensagemErroLoginComEmailNaoCadastrado()  {
        loginPage.acessarTelaLogin();

        loginPage.escreverLoginInexistente();
        loginPage.clicarContinuarLogin();

        Assert.assertEquals("Complete este passo para continuar.", loginPage.validarMensagemDoRobo());

    }

//    //CheckBox do robô atrapalha o teste.
//    @Test
//    @Epic("Login")
//    @DisplayName("validar mensagem para Senha Inválida")
//    public void validarMensagemSenhaInvalida(){
//        loginPage.acessarTelaLogin();
//
//        loginPage.escreverSenhaInvalido();
//        loginPage.clicarContinuarLogin();
//
//        Assert.assertEquals("Complete este passo para continuar.", loginPage.validarMensagemDoRobo());
//
//        //Assert.assertEquals("Revise a sua senha.", loginPage.validarErroSenhaInvalida());
//    }

    @Test
    @Epic("Pagina de Login")
    @Feature("Campo email obrigatório")
    @DisplayName("validar mensagem para campo 'email' não preenchido")
    public void validarCampoEmailVazio(){
        loginPage.acessarTelaLogin();

        loginPage.clicarContinuarLogin();

        Assert.assertEquals("Complete este passo para continuar.", loginPage.validarMensagemDoRobo());

    }

    @Test
    @Epic("Pagina de Login")
    @Feature("Captcha para validar email")
    @DisplayName("validar redirecionamento para Pagina Login-Senha")
    public void validarRedirecionamentoLoginSenha(){
        loginPage.acessarTelaLogin();

        loginPage.escreverLoginValido();
        loginPage.clicarContinuarLogin();

        Assert.assertEquals("Complete este passo para continuar.", loginPage.validarMensagemDoRobo());

    }

}
