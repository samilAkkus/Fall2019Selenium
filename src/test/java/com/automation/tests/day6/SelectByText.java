package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {


    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //create a webElement object for dropdown


        //FOR DROPDOWN I NEED TO USE SELECT CLASS
        //next one is creating select class
        //IT HAS TO COME FROM SELENIUM

        Select selectSimpleDropdown = new Select(simpleDropdown);
        //we need to assign webElement into Select constructor
        //PROVIDE WEB ELEMENT OBJECT

        selectSimpleDropdown.selectByVisibleText("Option 2");
        //select by visible text!!

        BrowserUtils.wait(2);

        selectSimpleDropdown.selectByVisibleText("Option 1");

        //////////////////////

        Select selectYear = new Select(driver.findElement(By.id("year")));
        //this is same as the one above
        //i passed webElement into Select

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        BrowserUtils.wait(2);
        selectMonth.selectByVisibleText("January");
        BrowserUtils.wait(2);
        selectYear.selectByVisibleText("2003");
        //under select module, options are visibleText
        //we see them when we click on day,month,year
        //I HAVE TO COPY-PASTE TEXT NOT VALUE
        //if i want to copy value, i need to use selectByValue

        BrowserUtils.wait(2);

        //SELECT ALL MONTHS

        List<WebElement> months = selectMonth.getOptions();
        //select all months one by one
        //getOptions() --> returns all options from dropdown as List<WebElement>

        for (WebElement eachMonth : months) {
            //get the month name and select based on that

            String monthName = eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            //select by visibleText(text here)
            //to get the text --> month.getText()

            BrowserUtils.wait(1);

            Select stateSelect = new Select(driver.findElement(By.id("state")));
            stateSelect.selectByVisibleText("District Of Columbia");

            String selected = stateSelect.getFirstSelectedOption().getText();
            //option that is currently selected
            //getFirstSelectedOption() --> returns a webelement
            //getText() -->visible text from webElement

            if(selected.equals("District Of Columbia")){

                System.out.println("test passed");
            }else {

                System.out.println("test failed");
            }

            List<WebElement> states = stateSelect.getOptions();

            for (WebElement stateOption : states) {

                System.out.println(stateOption.getText());

            }

        }

    }
}
