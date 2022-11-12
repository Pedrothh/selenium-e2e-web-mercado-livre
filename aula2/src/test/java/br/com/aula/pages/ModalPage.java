package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ModalPage extends BasePage {


    private static final By iframe =
            By.cssSelector("body > div.modal-iframe-cp > div.andes-modal-dialog.andes-modal--loose > iframe");

    private static final By textValidateCep2 =
            By.xpath("//*[@id=\"root-app\"]/div/div[1]/h1");
// #root-app > div > div.andes-modal-dialog__header.layout--embed__header > h1
    // #root-app > div
    // //*[@id="root-app"]/div/div[1]/h1

    private static final By campoCep =
            By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input");



    @Step("Validando texto na tela")
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

    @Step
    public void escreverNoTextModal(){
        sendKeys(campoCep, "Testando");
    }
}
