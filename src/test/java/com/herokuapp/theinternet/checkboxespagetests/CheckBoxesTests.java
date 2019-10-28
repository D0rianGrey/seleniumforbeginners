package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxesTest() {
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        CheckboxesPage checkboxesPage = welcomePageObject.clickCheckboxesLink();
        checkboxesPage.selectAllCheckboxes();
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"Not all checkboxes are checked");


    }
}
