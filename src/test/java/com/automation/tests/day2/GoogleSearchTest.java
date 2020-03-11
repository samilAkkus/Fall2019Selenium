package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest  {


    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("q")); //find search button by name

        //search is my searching button and i ll enter data by using it

        search.sendKeys("Java" , Keys.ENTER);
        // enter text on search button, sendKeys
        // then press Enter after entering text, use Key.ENTER
        //Keys.ENTER -> Performing keyboard action to press Enter

        Thread.sleep(2000);

        WebElement news  = driver.findElement(By.linkText("News"));

        //finding "News" element on the page

        news.click();

        //clicking on that button

//        driver.quit();


    }
}
