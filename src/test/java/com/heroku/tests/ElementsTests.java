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

    // Тест сценарий:
    //  1. Переходим на страницу Context Menu
    //  2. Делаем правый клик по элементу с пунктирной линией
    //  3. Нажимаем OK в появившемся alert
    //  4. Нажимаем ARROW_DOWN затем ENTER через класс Keys
    //  5. Проверяем что вернулись на домашнюю страницу
    @Test
    public void contextMenuTest() throws Exception {
        homePage.selectContextMenu();
        contextMenuPage.rightClick()
                .alertClick()
                .clickDown()
                .verifyHomePage("Welcome to the-internet");
    }
}
