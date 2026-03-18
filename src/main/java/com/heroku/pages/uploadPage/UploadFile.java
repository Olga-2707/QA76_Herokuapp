package com.heroku.pages.uploadPage;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFile extends BasePage {
    public UploadFile(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;
    public UploadFile selectFile(String path) {
        fileUpload.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement submit;
    public UploadFile clickUpload() {
        click(submit);
        return this;
    }

    @FindBy(xpath = "//h3")
    WebElement text;
    public UploadFile verifyFromTitle(String title) {
        Assertions.assertEquals(title, text.getText());
        return this;
    }
}
