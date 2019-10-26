package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {

    private WebDriver driver;

    @BeforeMethod
    private void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void PositiveLoginTest() {
        System.out.println("Starting login test");
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Assertion is failed");


        WebElement logOut = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logOut.isDisplayed(), "Logout is not visible");


        WebElement succsessfulMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = succsessfulMessage.getText();
        //Assert.assertEquals(actualMessage,expectedMessage, "Assertion is failed");
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Assertion is failed\n");
    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void negativeLoginTest(String username, String password, String expectedMessage) {
        System.out.println("Starting negativeLoginTest with " + username + " and " + password + " and " + expectedMessage);
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");


        //Enter Username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
        userNameField.sendKeys(username);

        //Enter password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);


        //LoginButton
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        /*String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl, "Assertion is failed");


        WebElement logOut = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logOut.isDisplayed(),"Logout is not visible");


        WebElement succsessfulMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = succsessfulMessage.getText();
        //Assert.assertEquals(actualMessage,expectedMessage, "Assertion is failed");
        Assert.assertTrue(actualMessage.contains(expectedMessage),"Assertion is failed\n");*/


        //Verifications

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        //String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedMessage), "Something went wrong");

    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
