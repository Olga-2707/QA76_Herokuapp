package com.heroku.pages.alertsFrameWindows;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/iframe']")
    WebElement iframe;
    public FramePage selectIframe() {
        click(iframe);
        return this;
    }

    @FindBy(id = "mce_0_ifr")
    WebElement iframeElement;
    public FramePage switchToIframe() {
        driver.switchTo().frame(iframeElement);
        return this;
    }

    @FindBy(id = "tinymce")
    WebElement iframeText;
    public FramePage verifyIframeByTitle(String text) {
        Assertions.assertTrue(iframe.getText().contains(text));
        return this;
    }

    public FramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }
}
