package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {


    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
        /*SecureAreaPage secureAreaPage = loginPage.login(username,password);
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains(expectedErrorMessage));*/
        loginPage.negativeLogin(username, password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        Assert.assertTrue(message.contains(expectedErrorMessage));




        /*log.info("Starting negativeTest");

        // open main page
        String url = "http://the-internet.herokuapp.com/";
        driver.get(url);
        log.info("Main page is opened.");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Form Authentication")).click();

        // enter username and password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // push log in button
        driver.findElement(By.className("radius")).click();

        // Verification
        String actualErrorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);*/
    }
}