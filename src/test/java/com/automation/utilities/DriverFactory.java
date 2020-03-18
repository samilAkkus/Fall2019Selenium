package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

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

            if(browserName.equalsIgnoreCase("firefox")){

                WebDriverManager.firefoxdriver().setup();

                return new FirefoxDriver();
            }else {

                if(browserName.equalsIgnoreCase("safari")){

                    return new SafariDriver();
                }else {

                    return null;
                }
            }
        }
    }
}
