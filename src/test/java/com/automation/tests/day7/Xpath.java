package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Xpath {

   public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
   public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
   public static String loginBtnLocator = "//button[contains(text(), 'Login')]";

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        BrowserUtils.wait(2);

        driver.findElement(By.xpath(userNameLocator));
        // here i find sibling of the tag
        //the tag i am using --> label ---> //label[text()='Username']/following-sibling::input
        //the tag i am trying to reach --> input

        //following --> going down --> from login to input
        //preceding --> going up --> from input to login

        //label and input go along together, structure use them together
        // LABEL && INPUT

        BrowserUtils.wait(2);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();

    }
}
