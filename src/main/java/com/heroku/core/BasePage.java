package com.heroku.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        if (text != null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
}
