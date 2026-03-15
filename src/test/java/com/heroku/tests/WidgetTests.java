package com.heroku.tests;

import com.heroku.core.TestBase;
import com.heroku.pages.HomePage;
import com.heroku.pages.widgets.DragAndDrop;
import com.heroku.pages.widgets.Dropdown;
import com.heroku.pages.widgets.HoversPage;
import com.heroku.pages.widgets.SliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WidgetTests extends TestBase {
    HomePage homePage;
    Dropdown dropdown;
    DragAndDrop dragAndDrop;
    SliderPage sliderPage;
    HoversPage hoversPage;

    @BeforeEach
    public void preconditions() {
        homePage = new HomePage(driver);
        dropdown = new Dropdown(driver);
        dragAndDrop = new DragAndDrop(driver);
        sliderPage = new SliderPage(driver);
        hoversPage = new HoversPage(driver);
    }

    @Test
    public void dropdownTest(){
        homePage.selectDropdown();
        dropdown.dropdownList("1")
                .verifyOption("Option 1");
    }

    @Test
    public void DragAndDropTest(){
        homePage.selectDragAndDrop();
        dropdown.moveAToB()
                .verifyColumnsHeader();
    }

    @Test
    public void moveSlider(){
        homePage.selectHorizontalSlider();
        sliderPage.moveSlider()
                .verifySliderValue("5");
    }

    @Test
    public void hoverMouseOnPicture(){
        homePage.selectHovers();
        hoversPage.hoverMouseOnPicture(0)
                .verifyNamePicture(0,"name: user1");
    }
}
