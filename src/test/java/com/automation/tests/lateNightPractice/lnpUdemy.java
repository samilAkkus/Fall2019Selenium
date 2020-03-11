package com.automation.tests.lateNightPractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class lnpUdemy {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("https://www.udemy.com");

        BrowserUtils.wait(2);

        driver.findElement(By.id("header-search-field")).sendKeys("selenium", Keys.ENTER);

        BrowserUtils.wait(2);

        List<WebElement> h4s = driver.findElements(By.tagName("h4"));

        driver.get(h4s.get(0).getAttribute("href"));
    }
}
