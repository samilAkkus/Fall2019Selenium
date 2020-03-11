package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForIFrame {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");

        BrowserUtils.wait(2);

        //we cant see frame content right away, its hidden in text
        //before looking for that element we need jump into the FRAME
        //we need to specify name, id, index of the frame

        // FRAME IS ANOTHER HTML DOCUMENT HIDDEN IN HTML, IT BECOMES VISIBLE ONCE YOU SWITCH TO IT.
        // ITS LIKE ANOTHER LAYER, YOU NEED TO DIG DEEPER TO HAVE IT.

        driver.switchTo().frame("mce_0_ifr");
                //now this content becomes visible
        //i can reach the information inside

        WebElement textInput = driver.findElement(By.id("tinymce"));
        // i found the element i needed after jump into the frame by id

        System.out.println(textInput.getText());

        BrowserUtils.wait(2);

        textInput.clear();
        textInput.sendKeys("Hello, world!");

        BrowserUtils.wait(2);

        driver.switchTo().defaultContent();
        //exit from the frame and go back
        // ITS FOR EXITING FROM THE LAYER WE DIG INTO!!
        // GOING BACK WHERE WE CAME FROM!!!

        WebElement heading = driver.findElement(By.tagName("h3"));

        System.out.println(heading.getText());
    }
}
