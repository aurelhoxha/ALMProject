package com.learnautomation.testcases;

import com.learnautomation.pages.AmazonHomePage;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTestAmazon extends BaseClass {

    @Test
    public void loginApp(){
        logger = report.createTest("Login To Amazon");
        //System.out.println(excel.getRowNumbers("Login"));
        LoginPage mLoginPage = PageFactory.initElements(driver,LoginPage.class);
        logger.info("Starting Application");
        AmazonHomePage mAmazonHomePage = PageFactory.initElements(driver,AmazonHomePage.class);
        mLoginPage.loginToAmazon(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
        mAmazonHomePage.openAccountInfo();
        logger.pass("Login Successful");
    }
}
