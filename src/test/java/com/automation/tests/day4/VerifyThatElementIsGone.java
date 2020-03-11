package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    /**
     * INTERVIEW QUESTION
     *
     * how to check if element does not exist anymore in the DOM
     * DOM --> Document Object Model
     *
     * @param args
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.id("disappearing_button")).click();

        Thread.sleep(2000);

//        List<WebElement> list = driver.findElements(By.id("disappearing_button"));

        // I COULD ASSIGN IT IN LIST FIRST THEN PUT IT ON STATEMENT
        // BUT I DECIDED TO DO IT IN ONE SHOT

        if(driver.findElements(By.id("disappearing_button")).size() == 0){
            //i assign it in list of elements so i can check if i still
            //have it or not
            // IT HAS TO BE findElementSSSSSSSSSSSSSS

            System.out.println("TEST PASSED");
        }else {

            System.out.println("TEST FAILLLL!!!");
        }

        Thread.sleep(2000);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        // this line is to find all buttons and put them in List

        for (WebElement button : buttons) {

            button.click(); // click on every button
            Thread.sleep(2000); //wait 2 seconds

        }







    }
}
