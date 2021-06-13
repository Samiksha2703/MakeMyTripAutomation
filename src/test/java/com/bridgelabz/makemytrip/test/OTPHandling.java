/**
 * purpose : To perform test to handle OTP in signup feature of MakeMyTrip Application
 * Author : Samiksha Shende
 * Date : 09/06/21020
 */

package com.bridgelabz.makemytrip.test;

import com.bridgelabz.makemytrip.base.Base;
import com.bridgelabz.makemytrip.pages.SignUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OTPHandling extends Base {

    public SignUp signUp;

    //test to check the functionality of signup function
    @Test
    public void signUp() throws InterruptedException {
        signUp = new SignUp(webdriver);
        signUp.signUp();
        WebElement check = webdriver.findElement(By.xpath("//input[@placeholder='Enter OTP here']"));
        Assert.assertTrue(check.isDisplayed());
    }
}
