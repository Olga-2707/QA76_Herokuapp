package com.heroku.tests;

import com.heroku.core.TestBase;
import com.heroku.pages.HomePage;
import com.heroku.pages.uploadPage.UploadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadPageTest extends TestBase {
    HomePage homePage;
    UploadFile uploadFile;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        uploadFile = new UploadFile(driver);
    }

    @Test
    public void uploadPageTest(){
        homePage.selectFileUpload();
        uploadFile.selectFile("C:/Tools/1.jpg")
                .clickUpload()
                .verifyFromTitle("File Uploaded!");
    }
}
