package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {


    @Description("Some description for from allure")
    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        /*SecureAreaPage secureAreaPage = loginPage.login(username,password);
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains(expectedErrorMessage));*/
        loginPage.negativeLogIn(username, password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        Assert.assertTrue(message.contains(expectedErrorMessage));
        Allure.addAttachment("My attachment","yeah, I am an attachment");




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