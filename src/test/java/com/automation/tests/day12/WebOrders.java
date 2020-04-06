package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createADriver("chrome");
        wait = new WebDriverWait(driver,10);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


    }

    @Test
    public void checkBoxTest(){

        driver.findElement(By.xpath("//a[text()='Check All']")).click();

        List<WebElement> boxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement box : boxes) {

            Assert.assertTrue(box.isSelected());

        }

    }

    @Test
    public void updateZipCode(){

        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[4]//td[9]")).getText(),"21233");

        driver.findElement(By.xpath("//table[@class='SampleTable']//tr[4]//td[13]//input")).click();

        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        wait.until(ExpectedConditions.visibilityOf(zipInput));

        zipInput.clear();

        zipInput.sendKeys("20002");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tr[4]//td[9]")).getText(),"20002");

    }



    @AfterMethod
    public void teardown(){

        driver.quit();
    }

}
