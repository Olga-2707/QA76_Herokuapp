package com.heroku.pages.widgets;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.prefs.BackingStoreException;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type = 'range']")
    WebElement rangeSlider;
    public SliderPage moveSlider() {
        actions.dragAndDropBy(rangeSlider,60,0).perform();
        return this;
    }


    public SliderPage verifySliderValue(String expectedValue) {
        Assertions.assertEquals(expectedValue, rangeSlider.getAttribute("value"));
        return this;
    }
}
