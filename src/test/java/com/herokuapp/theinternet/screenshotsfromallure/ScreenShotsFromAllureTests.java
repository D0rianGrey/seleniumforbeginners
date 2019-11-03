package com.herokuapp.theinternet.screenshotsfromallure;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.GooglePage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ScreenShotsFromAllureTests extends TestUtilities {

    @Test
    public void test1() {

        GooglePage googlePage = new GooglePage(driver,log);
        googlePage.openPage();
        String baseURL = "https://www.google.com.ua/";
        Allure.addAttachment("My attachment", "google website is opened correctly");
        Assert.assertEquals(driver.getCurrentUrl(),baseURL);
    }


}
