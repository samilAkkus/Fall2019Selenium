package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {


    public static void main(String[] args) throws Exception {

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createADriver("chrome");
        // i used the method i created in DriverFactory class

        driver.get("http://practice.cybertekschool.com/sign_up");
        //go to the web page

        WebElement fullName = driver.findElement(By.name("full_name"));
        //inspect the page and find name of the input box,
        //***we will use the NAME(as a tag) to enter our name***
        //in this case its --> name="full_name"

        //we can use tagName also but its probably not unique,
        //so it might give me problem

        Thread.sleep(2000);

        fullName.sendKeys("Samil Akkus");
        // i entered my name into the box

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        //i found email input box

        email.sendKeys("samil1905@hotmail.com");
        //i entered my email

        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        // i found singUp button which has name as "wooden_spoon"

        signUp.submit();
        // if i see type="submit", its better to use submit method
        //instead of click. If i do not have submit, use click!!

//        signUp.click();
        //i clicked that button

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        //message we are supposed to see

        WebElement message = driver.findElement(By.className("subheader"));
        //i ll find the message which page shows
        //i used className to track what i am looking for
        //i could use By.tagName,By.className,By.name

        String actual = message.getText();
        //to get the message text, i ll use .getText() method
        //this shows me what i have in "WebElement message"
        //and i need to compare it with expected one

        if(expected.equals(actual)){

            System.out.println("TEST PASSED");
        }else {

            System.out.println("TEST FAILED");
        }
        //if expected and actual are matching,
        //that means TEST PASSED!!








    }
}
