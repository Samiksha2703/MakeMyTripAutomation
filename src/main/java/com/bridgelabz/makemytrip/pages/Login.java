/**
 * purpose : To login into MakeMyTrip Application
 * Author : Samiksha Shende
 * Date : 07/06/21020
 */

package com.bridgelabz.makemytrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(xpath = "//p[text()='Login or Create Account']")
    WebElement login;

    @FindBy(xpath = "//label[text()='Login with Phone/Email']")
    WebElement loginWithEmail;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//button[@data-cy='continueBtn']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginButton;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to login into MakeMyTrip Application
    public void loginToAccount() throws InterruptedException {
        Thread.sleep(5000);
        if (login.isDisplayed()){
            login.click();
        }
        else if (loginWithEmail.isDisplayed()) {
            loginWithEmail.click();
        }
        username.clear();
        username.sendKeys("samikshashende777@gmail.com");
        continueButton.click();
        password.sendKeys("Welcome@01");
        loginButton.click();
    }
}
