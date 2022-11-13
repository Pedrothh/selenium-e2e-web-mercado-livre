package br.com.aula.pages;

import br.com.aula.utils.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Elements {

    public static void click(By by){
        waitElement(by);
//        element(by).click();
        waitVisibility(by).click();
    }

    public static void sendKeys(By by, String texto){
        waitElement(by);
        waitVisibility(by).sendKeys(texto);
    }

    public static String getText(By by){
        waitElement(by);
        return waitVisibility(by).getText();
    }

}
