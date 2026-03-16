package com.heroku.pages.elements;

import com.heroku.core.BasePage;
import com.heroku.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement hotSpot;
    public ContextMenuPage rightClick() {
        actions.contextClick(hotSpot).perform();
        return this;
    }

    public ContextMenuPage alertClick() {
        driver.switchTo().alert().accept();
        return this;
    }

    public ContextMenuPage clickDown() throws Exception {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement homePage;
    public HomePage verifyHomePage(String text) {
        Assertions.assertEquals(text, homePage.getText());
        return new HomePage(driver);
    }
}
