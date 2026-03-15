package com.heroku.tests;

import com.heroku.core.TestBase;
import com.heroku.pages.HomePage;
import com.heroku.pages.alertsFrameWindows.MultiplayWindows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplayWindowTest extends TestBase {
    MultiplayWindows window;
    HomePage homePage;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        window = new MultiplayWindows(driver);
    }

    @Test
    public void switchToMultiplayWindow(){
        homePage.selectMultiWindow();
        window.clickHere()
                .switchToNewTab(1)
                .verifyNewTabTitle("New Window");

    }
}
