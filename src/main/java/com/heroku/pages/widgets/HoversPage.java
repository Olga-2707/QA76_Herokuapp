package com.heroku.pages.widgets;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".figure")
    List<WebElement> figures;
    public HoversPage hoverMouseOnPicture(int index) {
        WebElement figure = figures.get(index);
        actions.moveToElement(figure).perform();
        return this;
    }


    public HoversPage verifyNamePicture(int index, String expectedText) {
        WebElement caption = figures.get(index).findElement(By.cssSelector(".figcaption h5"));
        Assertions.assertTrue(caption.isDisplayed());
        Assertions.assertEquals(expectedText, caption.getText());
        return this;
    }
}
