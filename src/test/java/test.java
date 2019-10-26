import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

public class test {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void test1(){
        driver = new ChromeDriver();
        driver.get("http://google.com.ua");
    }

    @Test
    public void test2(){

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        Set<Cookie> temp = driver.manage().getCookies();
        System.out.println(temp.toString());
        driver.get("http://google.com.ua");
        driver.get(url);


    }

}
