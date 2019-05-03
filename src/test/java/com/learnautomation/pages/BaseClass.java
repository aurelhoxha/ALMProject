package com.learnautomation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite(){
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/AmazonReport_"+ Helper.getCurrentDateTime()+".html"));
        report = new ExtentReports();
        report.attachReporter(extent);
    }

    @BeforeClass
    public void setup () {
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
    }
    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            try {
                logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
            } catch (Exception e) {
                System.out.println("Unable to capture screenshot >> " + e.getMessage() );
            }
        }
        else if (result.getStatus() == ITestResult.FAILURE){
            logger.pass("Test Passed");
        }
        report.flush();
    }
}
