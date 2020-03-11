package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    /**
     * This method return webDriver object based on browser type
     * @param browserName
     * @return webDriver object (chromeDriver is webDriver)
     */


    public static WebDriver createADriver(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();
        }else {

            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver();
        }
    }
}
