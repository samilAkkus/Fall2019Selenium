package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LateNightPractice {

    public static void main(String[] args) throws Exception {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");

        Thread.sleep(2000);

        WebElement username = driver.findElement(By.name("username"));

        username.sendKeys("tomsmith");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        WebElement h2 = driver.findElement(By.tagName("h2"));

        String h2Text =  h2.getText();

        System.out.println(h2Text);

        WebElement submit = driver.findElement(By.id("wooden_spoon"));

        submit.click();

        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        WebElement h4 = driver.findElement(By.tagName("h4"));

        String actual = h4.getText();

        if(expected.equals(actual)){

            System.out.println("TEST PASSED!!");
        }else {

            System.out.println("faillllll");
        }

//        WebElement logout = driver.findElement(By.linkText("Logout"));

        WebElement logout = driver.findElement(By.linkText("Logout"));

        String href = logout.getAttribute("href");

        System.out.println(href);

        logout.click();

        Thread.sleep(2000);














    }
}
