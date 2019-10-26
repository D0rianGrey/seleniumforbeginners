package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
    //

    @Test(priority = 1, groups = {"negativeTests", "smokeTests"})
    public void incorrectUsernameTest() {
        System.out.println("Starting incorrectUsernameTest");
        WebDriver driver = new FirefoxDriver();
        sleep(2000);
        driver.manage().window().maximize();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");


        //Enter Username
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("incorrectUserName");

        //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");


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
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Something went wrong");

        driver.quit();
    }

    @Test(priority = 2, groups = {"negativeTests"})
    public void incorrectPasswordTest() {
        System.out.println("Starting incorrectPasswordTest");
        WebDriver driver = new ChromeDriver();
        sleep(2000);
        driver.manage().window().maximize();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened.");


        //Enter Username
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");

        //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("IncorrectPassword");


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
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Something went wrong");

        driver.quit();
    }

    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
