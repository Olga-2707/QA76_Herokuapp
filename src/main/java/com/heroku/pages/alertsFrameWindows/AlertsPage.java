package com.heroku.pages.alertsFrameWindows;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "button[onclick='jsAlert()']")
    WebElement jsAlert;
    public AlertsPage verifyJSAlert() {
        click(jsAlert);
        Assertions.assertTrue(isAssertPresent(10));
        return new AlertsPage(driver);
    }

    public WebDriverWait getWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    private boolean isAssertPresent(int seconds) {
        Alert alert = getWait(seconds)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept(); //switchTo чтобы перейти на алерт и нажать ок
            return true;
        }
    }


    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement jsConfirm;
    public AlertsPage clickOnJSConfirmButton() {
        click(jsConfirm);
        return this;
    }

    public AlertsPage selectResult(String result) {
        if (result != null && result.equals("ОК")){
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Отмена")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }


    @FindBy(id = "result")
    WebElement confirmResult;
    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(confirmResult.getText().contains(text));
        return this;
    }

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPrompt;
    public AlertsPage clickOnPromptButton() {
        click(jsPrompt);
        return this;
    }

    public AlertsPage sendMessageToPrompt(String text) {
        if (text != null){
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement promptResult;
    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(promptResult.getText().contains(text));
        return this;
    }
}
