package br.com.aula.steps;

import br.com.aula.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginSteps extends BaseSteps{

    LoginPage loginPage = new LoginPage();
    HomeSteps homeSteps = new HomeSteps();

    @Test
    @Epic("Login")
    @DisplayName("validar mensagem de erro ao logar com email não cadastrado.")
    public void validarMensagemErroLoginComEmailNaoCadastrado(){
        homeSteps.validarRedirecionamentoTelaLogin();

        loginPage.escreverLoginInexistente();
        loginPage.clicarContinuarLogin();

        Assert.assertEquals("Revise o seu e-mail ou usuário.", loginPage.validarErroEmailNaoCadastrado());

    }

    //CheckBox do robô atrapalha o teste.
    @Test
    @Epic("Login")
    @DisplayName("validar mensagem para Senha Inválida")
    public void validarMensagemSenhaInvalida(){
        homeSteps.validarRedirecionamentoLoginSenha();

        loginPage.escreverSenhaInvalido();
        loginPage.clicarEntrarLogin();

        Assert.assertEquals("Revise a sua senha.", loginPage.validarErroSenhaInvalida());
    }

    @Test
    @Epic("Login")
    @DisplayName("validar mensagem para campo 'senha' nao preenchido")
    public void validarMensagemSenhaVazia(){
        homeSteps.validarRedirecionamentoLoginSenha();

        loginPage.escreverSenhaInvalido();
        loginPage.clicarEntrarLogin();

        Assert.assertEquals("Preencha esse dado.", loginPage.validarErroSenhaInvalida());
    }

}
