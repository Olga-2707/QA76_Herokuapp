package com.heroku.pages;

import com.heroku.core.BasePage;
import com.heroku.pages.alertsFrameWindows.AlertsPage;
import com.heroku.pages.alertsFrameWindows.FramePage;
import com.heroku.pages.alertsFrameWindows.MultiplayWindows;
import com.heroku.pages.elements.ContextMenuPage;
import com.heroku.pages.widgets.DragAndDrop;
import com.heroku.pages.widgets.Dropdown;
import com.heroku.pages.widgets.HoversPage;
import com.heroku.pages.widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = "//a[@href='/windows']")
    WebElement windows;
    public MultiplayWindows selectMultiWindow() {
        click(windows);
        return new MultiplayWindows(driver);
    }

    @FindBy(xpath = "//a[@href='/frames']")
    WebElement frames;
    public FramePage selectFrame() {
        click(frames);
        return new FramePage(driver);
    }

    @FindBy(xpath = "//a[@href = '/dropdown']")
    WebElement dropdownPage;
    public Dropdown selectDropdown() {
        click(dropdownPage);
        return new Dropdown(driver);
    }

    @FindBy(xpath = "//a[@href='/drag_and_drop']")
    WebElement dragAndDropPage;
    public DragAndDrop selectDragAndDrop() {
        click(dragAndDropPage);
        return new DragAndDrop(driver);
    }

    @FindBy(xpath = "//a[@href='/horizontal_slider']")
    WebElement horizontalSlider;
    public SliderPage selectHorizontalSlider() {
        click(horizontalSlider);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//a[@href='/hovers']")
    WebElement hoversPage;
    public HoversPage selectHovers() {
        click(hoversPage);
        return new HoversPage(driver);
    }

    @FindBy(xpath = "//a[@href='/context_menu']")
    WebElement contextMenu;
    public ContextMenuPage selectContextMenu() {
        click(contextMenu);
        return new ContextMenuPage(driver);
    }
}