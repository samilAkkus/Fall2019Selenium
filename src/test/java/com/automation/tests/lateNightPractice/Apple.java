package com.automation.tests.lateNightPractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Apple {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("https://www.apple.com/");

        BrowserUtils.wait(2);

        driver.findElement(By.id("ac-gn-link-search")).click();

        BrowserUtils.wait(2);

        driver.findElement(By.id("ac-gn-searchform-input")).sendKeys("iphone11", Keys.ENTER);

        BrowserUtils.wait(2);

        driver.findElement(By.linkText("iPhone 11 Pro and iPhone 11 Pro Max")).click();




    }
}
