package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        //this is how we apply implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait 10 seconds till element becomes visible, if it takes shorter time it will work then
        //we are just saying it will be available in 10 seconds, be ready for it
        //if it takes less, do whenever it works
        //implicit just cares about presence of the element, nothing else --> 1 criteria
        //so general, use only once
        //explicit has more criteria --> individual, specific -- use as many times we need
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }
}