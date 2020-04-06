package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
         driver = DriverFactory.createADriver("chrome");
         driver.manage().window().maximize();
         actions = new Actions(driver);
    }

    @Test
    public void hoverOnImage(){

        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        //if //img[1] does not work, it means its not child
        //we need to use (//img)[1]

        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        //build() --> when you need to execute couple of actions
        //together in a row
        //always end with perform()
        //this is builder pattern to build more than one action

        BrowserUtils.wait(2);
        //======================================================//

        //hover on the first image
        //verify that "name: user1" is displayed

        actions.moveToElement(img1).perform();

        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));

        Assert.assertTrue(imgText1.isDisplayed());

        //move to second one

        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));

        Assert.assertTrue(imgText2.isDisplayed());


    }

    @Test
    public void jqueryMenuTest(){

        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");


        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).
                pause(1000).
                moveToElement(downloads).
                pause(1000).
                click(pdf).
                build().perform();


    }
    @Test
    public void dragAngDropTest(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        BrowserUtils.wait(3);

        //click on accept cookies

        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        BrowserUtils.wait(3);

        WebElement earthTarget = driver.findElement(By.id("droptarget"));
        WebElement moonSource = driver.findElement(By.id("draggable"));


        actions.dragAndDrop(moonSource,earthTarget).perform();

        String expected = "You did great!";

        String actual = earthTarget.getText();

        Assert.assertEquals(actual,expected);




    }




    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
