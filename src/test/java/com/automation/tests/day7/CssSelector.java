package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        // .(dot)--> is used for finding class name in css

        WebElement home = driver.findElement(By.cssSelector(".nav-link"));

        WebElement btn1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        //this is how we find element with css

        WebElement btn2 = driver.findElement(By.cssSelector("[name='button2']"));

        WebElement btn3 = driver.findElement(By.cssSelector("[id^='button_']"));
        //starts with--id

        WebElement btn4 = driver.findElement(By.cssSelector("[onclick$='4()']"));
        //ends with--onclick

        WebElement btn5 = driver.findElement(By.cssSelector("[onclick$='5()"));

        WebElement btn6 = driver.findElement(By.cssSelector("#disappearing_button"));
        //just id with #

        BrowserUtils.wait(2);

        btn1.click();
        BrowserUtils.wait(1);
        btn2.click();
        BrowserUtils.wait(1);
        btn3.click();
        BrowserUtils.wait(1);
        btn4.click();
        BrowserUtils.wait(1);
        btn5.click();
        BrowserUtils.wait(1);
        btn6.click();



    }
}
