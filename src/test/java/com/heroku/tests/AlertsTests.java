package com.heroku.tests;

import com.heroku.core.TestBase;
import com.heroku.pages.HomePage;
import com.heroku.pages.alertsFrameWindows.AlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertsTests extends TestBase {
    AlertsPage alerts;
    HomePage homePage;

    @BeforeEach
    public void preconditions(){
        alerts = new AlertsPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void jsAlertTest(){
        homePage.selectJSAlerts();
        alerts.verifyJSAlert();
    }

    @Test
    public void jsConfirmAlert(){
        homePage.selectJSAlerts();
        alerts.clickOnJSConfirmButton()
                .selectResult("Отмена") //для положительного ОК
                .verifyResult("Cancel");//для положительного Ok
    }

    @Test
    public void sendMessageToPromptTest(){
        homePage.selectJSAlerts();
        alerts.clickOnPromptButton()
                .sendMessageToPrompt("Hello!!")
                .verifyMessage("Hello!!");
    }


}
