package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //coming from AbstractTestBase
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        //all purpose is creating a report
        //WE NEED THESE IMPLEMENTATIONS TO GET THAT REPORT
        //I also have screenshot in the file
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //like system.out, but it goes to report
        //it will show up in report
        test.info("Login as store manager"); // log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page title Dashboard was verified");
        //this is the message i need to see in my report if test passes
    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //take a screenshot
//        BrowserUtils.getScreenshot("warning_message");
        //we do not need this anymore!! we already have it in AbstractTestBase class

        test.pass("Warning message is displayed");
    }

    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName,String password){

        test = report.createTest("Verify page title as "+userName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as store manager");
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");

    }


    @DataProvider
    public Object[][] credentials(){

        return new Object[][]{

                {"storemanager85","UserUser123"},
                {"salesmanager110","UserUser123"},
                {"user16","UserUser123"}

        };
    }
}