package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(name = "email") WebElement userEmail;
    @FindBy(name = "password") WebElement userPassword;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]") WebElement signInButton;

    public void loginToAmazon(String email, String password){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        signInButton.click();
    }
}
