package com.heroku.pages.widgets;

import com.heroku.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BasePage {
    public Dropdown(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;
    public Dropdown dropdownList(String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
        return this;
    }

    public Dropdown verifyOption(String expectedText) {
        String result = new Select(dropdown).getFirstSelectedOption().getText();
        Assertions.assertEquals(expectedText, result);
        return this;
    }

    @FindBy(id = "column-a")
    WebElement columnA;
    public Dropdown moveAToB() {
        actions.dragAndDropBy(columnA,150,0).perform(); //можно передать два ел-та (columnA, columnB) поменяет местами
        return this;
    }

    @FindBy(id = "column-b")
    WebElement columnB;

    public Dropdown verifyColumnsHeader() {
        Assertions.assertEquals("B", columnA.getText());
        Assertions.assertEquals("A", columnB.getText());
        return this;
    }
}
