package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropDownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        DropDownPage dropDownPage = welcomePageObject.clickDropdownLink();
        dropDownPage.selectOption(2);
        String selectedOption = dropDownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected - " + selectedOption);

    }

}
