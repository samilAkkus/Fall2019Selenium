package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropPractice {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/drag_and_drop");

        driver.manage().window().maximize();

        BrowserUtils.wait(3);

    }

    @Test
    public void dragDrop(){

        actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("column-a"));

        WebElement target = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(source,target).perform();

        BrowserUtils.wait(2);


    }






    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
