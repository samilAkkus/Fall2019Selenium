package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ebay_amazon_wiki {



    //    Go to ebay
//    enter search term
//    click on search button
//    print number of results -- use h1
//
//    go to amazon
//    enter search term
//    click on search button
//    verify title contains search term
//
//    Go to wikipedia.org
//    enter search term `selenium webDriver`
//    click on search button
//    click on search result `Selenium (software)`
//    verify url ends with `Selenium_(software)`

    public static void main(String[] args) throws Exception {

        ebay();
        amazon();
        wiki();



    }

    public static void ebay() throws Exception{

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        Thread.sleep(2000);

        driver.findElement(By.id("gh-ac")).sendKeys("macbook", Keys.ENTER);

        String h1 = driver.findElement(By.tagName("h1")).getText().split(" ")[0];

        System.out.println(h1);

        Thread.sleep(2000);

    }

    public static void amazon() throws Exception{

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("macbook" , Keys.ENTER);

        if(driver.getTitle().contains("macbook")){

            System.out.println("TITLE DOES CONTAIN ITEM");
        }else {

            System.out.println("TITLE DOES NOT CONTAIN ITEM");
        }

        Thread.sleep(2000);

    }

    public static void wiki() throws Exception{

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        Thread.sleep(2000);

        driver.findElement(By.id("searchInput")).sendKeys("selenium webDriver" ,Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.linkText("Selenium (software)")).click();

        System.out.println(driver.getCurrentUrl());

        if(driver.getCurrentUrl().endsWith("Selenium_(software)")){

            System.out.println("URL ENDS WITH Selenium_(software)");
        }else {

            System.out.println("URL DOES NOT END WITH Selenium_(software)");
        }




    }
}
