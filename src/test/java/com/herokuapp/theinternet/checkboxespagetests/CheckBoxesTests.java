package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxesTest() {
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
        checkboxesPage.selectAllCheckboxes();
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"Not all checkboxes are checked");


    }
}
