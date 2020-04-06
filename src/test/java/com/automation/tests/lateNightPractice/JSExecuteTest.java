package com.automation.tests.lateNightPractice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSExecuteTest {

    @Test
    public void testScroll(){

            Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 10 ; i++) {

            js.executeScript("window.scrollBy(0,250)");

            BrowserUtils.wait(2);

        }

        Driver.closeDriver();


        }


        @Test
        public void testScrollIntoView(){

        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement element = Driver.getDriver().findElement(By.linkText("Inputs"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true)" , element);

        BrowserUtils.wait(2);

        Driver.closeDriver();


        }

        @Test
        public void titleTest(){

            String expected= "Practice";

            Driver.getDriver().get("http://practice.cybertekschool.com/");

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            String actual = js.executeScript("return document.title").toString();

            Assert.assertEquals(actual,expected);

            Driver.closeDriver();

        }

        @Test
        public void  setAttributeTest(){

        Driver.getDriver().get("http://practice.cybertekschool.com/login");

        WebElement user= Driver.getDriver().findElement(By.cssSelector("input[name='username']"));

        WebElement password = Driver.getDriver().findElement(By.cssSelector("input[name='password']"));

        WebElement login = Driver.getDriver().findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('value','tomsmith')",user);

        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);

        js .executeScript("arguments[0].click()",login);




        }





}
