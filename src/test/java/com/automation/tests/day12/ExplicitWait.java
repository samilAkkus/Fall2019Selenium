package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createADriver("chrome");

        driver.manage().window().maximize();



    }

    @Test
    public void waitForTitle(){

        driver.get("http://google.com");

        WebDriverWait wait = new WebDriverWait(driver,10);
        //explicit --> WAIT FOR CERTAIN CONDITION

        wait.until(ExpectedConditions.titleContains("Google"));

        //wait until title of the page contains "Google"

        driver.navigate().to("https://amazon.com");

        wait.until(ExpectedConditions.titleContains("Amazon"));


    }

    @Test
    public void waitForVisibility(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        ////button[text()='Start'] --> xPath


        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");

        //visibilityOf --> wait till element becomes visible
        //and send keys

        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");

        wait.until(ExpectedConditions.visibilityOf(submit));
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        //wait until element becomes clickable and click it!!

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual, expected);



    }

    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        //WAIT UNTIL THIS LOADING ICON ELEMENT IS GONE, THEN CONTINUE PROCESS

        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();


        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual, expected);



    }






    @AfterMethod
    public void teardown(){

    driver.quit();

    }
}
