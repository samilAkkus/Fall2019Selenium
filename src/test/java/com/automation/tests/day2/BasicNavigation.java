package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {

        //to start selenium script we need:
        //setup webDriver(browser driver) and create webDriver object


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //in selenium, everything starts from WebDriver interface

        driver.get("http://google.com"); //essential to open a website

        Thread.sleep(2000); //wait 3 seconds,
        // it throws exception,
        // i added "throws" keyword in main method

        String title = driver.getTitle(); //returns <title>SomeTitle</title>
        //If the page is Google, it returns title(Google)

        String expectedTitle = "Google";

        System.out.println("title = " + title);

        if(title.equals(expectedTitle)){

            System.out.println("TEST PASSED!!");
        }else {

            System.out.println("TEST FAILED!!");
        }

        driver.close(); // to close the browser


    }
}
