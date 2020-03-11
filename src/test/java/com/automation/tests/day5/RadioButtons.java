package com.automation.tests.day5;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class RadioButtons {
    public static void main(String[] args){
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        //<input type="radio">
        //I created a method to handle exception all time

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
        //put all radioButtons in a list and I will click them all

        for(WebElement radioButton: radioButtons){
            //to check if button can be clicked
            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();
            //check if its already selected

            System.out.println(isSelected);

            if(radioButton.isEnabled()) { // isEnabled --> check if its working,click if yes
                radioButton.click();
                System.out.println("Clicked on :: "+id);
                BrowserUtils.wait(1);
            } else {
                System.out.println("Button is disabled, not clicked :: "+id); //print this if no
            }
        }

        driver.quit();
    }
}