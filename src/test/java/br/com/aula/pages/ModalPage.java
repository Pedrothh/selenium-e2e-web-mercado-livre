package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ModalPage extends BasePage {


    private static final By iframe =
            By.cssSelector("body > div.modal-iframe-cp > div.andes-modal-dialog.andes-modal--loose > iframe");

    private static final By textValidateCep2 =
            By.xpath("//*[@id=\"root-app\"]/div/div[1]/h1");


    private static final By campoCep =
            By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input");

    // .andes-form-control__field

    private static final By botaoUsarCep =
            By.cssSelector("button.andes-button > span:nth-child(1)");

    private static final By spanEnderecoDoCep =
            By.xpath("/html/body/header/div/div[2]/ul/li[1]/a/span[2]");

    private static final By spanInformarCepObrigatorio =
            By.cssSelector(".andes-form-control__message");

    @Step("Valida texto no modal CEP")
    public String validarTextNoModalCep() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element1 = element(iframe);
        driver.switchTo().frame(element1);

        try {
            return getText(textValidateCep2);
        } catch (Exception err){
            return "deu ruim! " + err.getMessage();
        }
        // driver.switchTo().defaultContent();
    }

    @Step("Valida placeholder no modal CEP")
    public String validarPlaceholderNoModalCep() {
        return driver.findElement(By.cssSelector(".andes-form-control__field")).getAttribute("placeholder");
    }

    @Step("Escreve no campo de CEP")
    public void escreverNoTextModal() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element1 = element(iframe);
        driver.switchTo().frame(element1);

        sendKeys(campoCep, "58030020");
    }


    @Step("Clica no Botão Usar")
    public void clicaNoBotaoUsarCep()  {
        click(botaoUsarCep);
    }

    @Step("Clica no Botão Usar")
    public void clicaNoBotaoUsarCepComSleep() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element1 = element(iframe);
        driver.switchTo().frame(element1);
        click(botaoUsarCep);
    }

    @Step("Valida o endereço buscado")
    public String validarEnderecoDoCepBuscado() throws InterruptedException {
        Thread.sleep(5000);
        return getText(spanEnderecoDoCep);
    }

    @Step("Valida o endereço buscado")
    public String validarSpanInformarCepObrigatorio() throws InterruptedException {
        Thread.sleep(5000);
        return getText(spanInformarCepObrigatorio);
    }

}


