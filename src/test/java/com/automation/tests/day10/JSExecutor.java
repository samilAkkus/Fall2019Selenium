package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;
    //because WebDriver does not know anything about JavascriptExecutor
    //thats why i need to use RemoteWebDriver,
    //RemoteWebDriver is a class implements all of them
    //and it has more methods to work on


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){


        driver.quit();
    }

    @Test
    public void scrollTest(){

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        BrowserUtils.wait(2);

        //we need to cast if reference type is WebDriver
//        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scroll down 250 pixels
        //x-y coordinate
        // 0--> right,left
        // 250--> up,down
        driver.executeScript("window.scrollBy(0, 250)");

        BrowserUtils.wait(3);

        for (int i = 0; i < 10 ; i++) {

            driver.executeScript("window.scrollBy(0, 250)");

            BrowserUtils.wait(1);

        }


    }

    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView - javascript method
        //arguments[0] - means 1st webelement after comma
        //argument0 is link
        //scroll till link element(argument0) becomes visible
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
    }

}
