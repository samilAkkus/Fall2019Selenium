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

        driver.manage().window().maximize(); // to maximize windows

//        driver.manage().window().fullscreen(); // to make it full screen

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

        driver.navigate().to("http://amazon.com");
        Thread.sleep(2000);

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
        //comeback to google
        driver.navigate().back();
        //checking if page title is equals to Google
        //.getTitle() - returns page title

        Thread.sleep(2000);
        verifyEquals(driver.getTitle(), "Google");
        //must be at the end

        driver.navigate().forward(); // again going to amazon, move forward

        System.out.println("Title: "+driver.getTitle());

        System.out.println("URL: "+driver.getCurrentUrl());

        Thread.sleep(2000);

        driver.navigate().refresh(); // to reload the page


        Thread.sleep(2000);

        driver.close();//to close browser
        //browser cannot close itself


    }

    public static void verifyEquals(String arg1,String arg2){

        if(arg1.equals(arg2)){

            System.out.println("TEST PASSED!");
        }else {

            System.out.println("TEST FAILED!!");
        }
    }
}
