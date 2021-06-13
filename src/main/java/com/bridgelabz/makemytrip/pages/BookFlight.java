package com.bridgelabz.makemytrip.pages;

import com.bridgelabz.makemytrip.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class BookFlight {
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/label[1]/div")
    WebElement depFlight;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/label[1]/div")
    WebElement returnFlight;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/label[1]/div/div[2]/div[2]/p")
    WebElement depPrice;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/label[1]/div/div[2]/div[2]/p")
    WebElement retPrice;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]")
    WebElement getDetails;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[1]/div/span")
    WebElement getDetailsDep;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[2]/div/span")
    WebElement getDetailsRet;

    public BookFlight(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to book flight
    public void bookFlight() {
        String deptStr = depPrice.getText();
        String retStr = retPrice.getText();
        String detailsDep = getDetailsDep.getText();
        String detailsRet = getDetailsRet.getText();
        String details = getDetails.getText();
        depFlight.click();
        returnFlight.click();
        System.out.println(details);
        System.out.println(" ");
        if (detailsDep.equals(deptStr)) {
            if (detailsRet.equals(retStr)) {
                System.out.println("Reflecting Price");
            }
        }
    }
}
