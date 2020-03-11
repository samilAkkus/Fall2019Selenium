package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUpTask_03_04 {


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


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        Thread.sleep(2000);

        WebElement search = driver.findElement(By.id("gh-ac"));

        search.sendKeys("macbook");

        Thread.sleep(2000);

        WebElement enterSearch = driver.findElement(By.id("gh-btn"));

        enterSearch.click();

        Thread.sleep(2000);

        WebElement numberOfResult = driver.findElement(By.tagName("h1"));

        String num = numberOfResult.getText();

        System.out.println(num);

        driver.get("https://www.amazon.com/");

        Thread.sleep(2000);

        WebElement amazonSearch = driver.findElement(By.id("twotabsearchtextbox"));

        amazonSearch.sendKeys("macbook" , Keys.ENTER);

        Boolean containItem = driver.getTitle().contains("macbook");

        System.out.println(containItem);

        driver.get("https://wikipedia.org");

        WebElement searchButtonWiki = driver.findElement(By.id("searchInput"));

        searchButtonWiki.sendKeys("selenium webDriver", Keys.ENTER);



        driver.findElement(By.linkText("Selenium (software)")).click();
        //link text is the text it has near a href
        //title="Selenium (software)"

        Boolean last = driver.getCurrentUrl().endsWith("Selenium_(software)");

        System.out.println(last);






    }
}
