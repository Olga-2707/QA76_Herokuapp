package com.heroku.pages.alertsFrameWindows;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MultiplayWindows extends BasePage {

    public MultiplayWindows(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement newWindow;
    public MultiplayWindows clickHere() {
        click(newWindow);
        return this;
    }

    public MultiplayWindows switchToNewTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//h3")
    WebElement titleNewTab;
    public MultiplayWindows verifyNewTabTitle(String title) {
        Assertions.assertTrue(shouldHaveText(titleNewTab, title, 5));
        return this;
    }

    private boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public WebDriverWait getWait(int second){
        return new WebDriverWait(driver, Duration.ofSeconds(second));
    }
}
