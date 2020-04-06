package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTestNG {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/");

        driver.manage().window().maximize();

        BrowserUtils.wait(3);

    }

    @Test
    public void loginTest(){

          driver.findElement(By.linkText("Form Authentication")).click();

          BrowserUtils.wait(3);

          driver.findElement(By.cssSelector("input[type='text']")).sendKeys("tomsmith");

          BrowserUtils.wait(2);

          driver.findElement(By.cssSelector("input[type='password']")).sendKeys("SuperSecretPassword", Keys.ENTER);

          String expected = "Welcome to the Secure Area. When you are done click logout below.";

          Assert.assertEquals(driver.findElement(By.cssSelector(".subheader")).getText(), expected);
    }




    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
