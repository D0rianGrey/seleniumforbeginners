package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropDownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        DropDownPage dropDownPage = welcomePage.clickDropdownLink();
        dropDownPage.selectOption(2);
        String selectedOption = dropDownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected - " + selectedOption);

    }

}
