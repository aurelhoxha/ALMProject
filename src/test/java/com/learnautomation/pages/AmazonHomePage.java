package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AmazonHomePage {
    WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/div/a[2]/span[1]") WebElement welcomeMessage;

    public void openAccountInfo(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        welcomeMessage.click();
    }
}
