package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        /*String url = "http://the-internet.herokuapp.com/";
        driver.get(url);
        log.info("Main page is opened.");*/
        welcomePageObject.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
        //driver.findElement(By.linkText("Form Authentication")).click();

        // enter username and password
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
        //driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //WebDriverWait wait = new WebDriverWait(driver, 10);

        // push log in button
        /*WebElement logInButton = driver.findElement(By.className("radius"));
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();*/

        // verifications
        // new url
        Assert.assertEquals(secureAreaPage.getCurrentUrl(),secureAreaPage.getPageUrl());
        /*String expectedUrl = "http://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);*/

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),"LogOut is not visible");
        /*Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
                "logOutButton is not visible.");*/

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: " +
                expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
        /*String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);*/


    }
}
