package com.heroku.tests;

import com.heroku.core.TestBase;
import com.heroku.pages.HomePage;
import com.heroku.pages.alertsFrameWindows.FramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrameTests extends TestBase {

    HomePage homePage;
    FramePage framePage;

    @BeforeEach
    public void preconditions(){
        homePage = new HomePage(driver);
        framePage = new FramePage(driver);
    }

    @Test
    public void switchToNewIframe(){
        homePage.selectFrame();
        framePage.selectIframe()
                .switchToIframe()
                .verifyIframeByTitle("Your content goes here.")
                .switchToMainPage();
    }

}

