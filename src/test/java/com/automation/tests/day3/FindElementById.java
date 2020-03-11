package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");

        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //this is the shortcut, i can do it in one line
        //but i cant use it later

//     WebElement username = driver.findElement(By.name("username"));
//
//      username.sendKeys("tomsmith");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //this is the shortcut, i can do it in one line
        //but i cant use it later

//        WebElement password = driver.findElement(By.name("password"));
//
//        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();
        //shortcut of finding Login button and click it

        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        //message we are supposed to see

        WebElement message = driver.findElement(By.tagName("h4"));
        //i ll find the message which page shows
        //i used tagName to track what i am looking for
        //i could use By.tagName,By.className,By.name
        //HOW CAN I UNDERSTAND ITS UNIQUE
        //use attribute=value pair like--> [name='password']

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

        //----------LOGOUT----------//
        //when we come to this point we see Logout
        //which looks like button but its a link
        //because tagName is <a>

        //lets click on LOGOUT-button-

        WebElement logout = driver.findElement(By.linkText("Logout"));
        //it has space before Logout but we had to remove it,
        //because it did not work with space
        //if we have couple of spaces use partialLinkText
        //linkText --> equals()
        //partialLinkText --> contains() -- complete match NOT required

        //===============================================================//
        String href = logout.getAttribute("href");
        // href is attribute of the link
        //i assign it to a string so i can see which url will be opened
        //with getAttribute("attribute name") , we can see what we have
        //in the attribute

        //IN THIS CASE,
        //class --> attribute
        //href --> attribute
        //Logout --> text

        System.out.println(href);
        //i can see the url now!
        //before clicking
        //===============================================================//

        logout.click();

        Thread.sleep(2000);
        ///////// INVALID CREDENTIALS ////////////

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));

        System.out.println(errorMessage.getText());

        //Your username is invalid! -->comes from text
        //× --> comes from the link which is used to close error message



//        driver.quit();

    }



}
