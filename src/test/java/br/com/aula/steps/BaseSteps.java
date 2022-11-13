package br.com.aula.steps;


import br.com.aula.utils.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

public class BaseSteps extends Browser {


    @Before
    public void abrirNavegador(){
        browserUp("https://www.mercadolivre.com.br/");
        driver.manage().deleteAllCookies();
    }

    @After
    public void fecharNavegador(){
        browserDown();
    }

}
