package com.heroku.pages;

import com.heroku.core.BasePage;
import com.heroku.pages.alerts.AlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css ="a[href = '/javascript_alerts']")
    WebElement alerts;
    public AlertsPage selectJSAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }
}