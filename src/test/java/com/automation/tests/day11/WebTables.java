package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        //just to print
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
        //our method get WebElements and turn them into String Array
        //as we can see we can compare collection as well!!

        //====================================//

        //table --> all table
        //tbody --> body of the table(except header)
        //th --> table header
        //tr --> table row
        //td --> table column

        //=====================================//
    }

    @Test
    public void verifyRowCount() {
        // //tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        //expected - 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
    }

    /**
     * To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn() {
        //td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    @Test
    public void deleteRowTest(){

        WebElement delete = driver.findElement(By.xpath("//table[1]//tbody//tr[1]//td[3]//following-sibling::td[3]//a[text()='delete']"));

        delete.click();

        BrowserUtils.wait(2);

        Assert.assertEquals(driver.findElements(By.xpath("//table[1]//tbody//tr")).size() , 3);

//        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
//
//        Assert.assertTrue(emails.isEmpty());

        //this is how vasily has done

        List<WebElement> mails = driver.findElements(By.xpath("//table[1]//tbody//td[5]"));

        List<String> mailList = BrowserUtils.getTextFromWebElements(mails);

        Assert.assertTrue(!mailList.contains("http://www.jsmith.com"));


    }

    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();

            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));

            if (actualColumnName.equals(columnName)) {
                index = i + 1;
                break;
            }
        }

        Assert.assertEquals(index, 3);

    }


    @Test
    public void getSpecificCell(){

        String expected = "http://www.jdoe.com";

        int row = 3;
        int column = 5;

        String xpath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(),expected);


    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
