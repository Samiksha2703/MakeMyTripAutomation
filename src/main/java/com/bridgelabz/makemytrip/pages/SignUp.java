/**
 * purpose : To signup into MakeMyTrip Application
 * Author : Samiksha Shende
 * Date : 07/06/21020
 */

package com.bridgelabz.makemytrip.pages;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SignUp {
    public static String Account_SID = "AC44fcc83510cf17ef705330f6c0d77b3c";
    public static String Auth_Token = "e5b857089eff33e0169a3de80fb35cf6";

    @FindBy(xpath = "/html/body")
    WebElement homePage;

    @FindBy(xpath = "//p[text()='Login or Create Account']")
    WebElement signUp;

    @FindBy(xpath = "//input[@id='username']")
    WebElement loginWithMobile;

    @FindBy(xpath = "//i[@class='drop-down down']")
    WebElement dropdown;

    @FindBy(xpath = "//span[text()='US']")
    WebElement selectCountryCode;

    @FindBy(xpath = "//button[@data-cy='continueBtn']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@placeholder='Enter OTP here']")
    WebElement otp;

    @FindBy(xpath = "//span[text()='Verify & Create Account']")
    WebElement verify;

    public SignUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to signup into MakeMyTrip Account
    public void signUp() throws InterruptedException {
        homePage.click();
        signUp.click();
        loginWithMobile.sendKeys("8033494391");
        Thread.sleep(3000);
        dropdown.click();
        Thread.sleep(3000);
        selectCountryCode.click();
        Thread.sleep(3000);
        continueButton.click();
        Thread.sleep(3000);
        Twilio.init(Account_SID, Auth_Token);
        Thread.sleep(3000);
        String smsBody = getMessage();
        System.out.println(smsBody);
        String otpNumber = smsBody.replaceAll("[^-?0-9]+", "");
        Thread.sleep(3000);
        otp.sendKeys(otpNumber);
        Thread.sleep(3000);
        verify.click();
        Thread.sleep(3000);
    }

    public String getMessage() {
        return getMessages().filter(message -> message.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(message -> message.getTo().equals("+18033494391")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> message = Message.reader(Account_SID).read();
        return StreamSupport.stream(message.spliterator(), false);
    }
}
