package com.heroku.tests;

import com.heroku.core.TestBase;
import com.heroku.pages.HomePage;
import com.heroku.pages.elements.ContextMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ElementsTests extends TestBase {
    HomePage homePage;
    ContextMenuPage contextMenuPage;


    @BeforeEach
    public void precondition(){
    homePage = new HomePage(driver);
    contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void contextMenuTest() throws Exception {
        homePage.selectContextMenu();
        contextMenuPage.rightClick()
                .alertClick()
                .clickDown()
                .verifyHomePage("Welcome to the-internet");
    }
}
