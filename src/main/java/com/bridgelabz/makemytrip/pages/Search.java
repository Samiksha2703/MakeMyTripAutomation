/**
 * purpose : To search flights with different filter of MakeMyTrip Application
 * Author : Samiksha Shende
 * Date : 07/06/21020
 */

package com.bridgelabz.makemytrip.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Search {

    public static LinkedList<String> flights = new LinkedList<>();
    public static LinkedList<String> oneStopFlights = new LinkedList<>();
    public static LinkedList<String> nonStopFlights = new LinkedList<>();
    @FindBy(xpath = "/html/body")
    WebElement homePage;

    @FindBy(xpath = "//span[text()='Flights']")
    WebElement flightModule;

    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    WebElement roundTripRadioButton;

    @FindBy(xpath = "//input[@id='fromCity']")
    WebElement enterFromCity;

    @FindBy(xpath = "//p[text()='Mumbai, India']")
    WebElement fromCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement enterToCity;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div/div/div[1]/ul/li/div")
    WebElement toCity;

    @FindBy(xpath = "//span[text()='DEPARTURE']")
    WebElement selectDate;

    @FindBy(xpath = "//div[@aria-label='Fri Jun 18 2021']")
    WebElement departureDate;

    @FindBy(xpath = "//div[@aria-label='Fri Jun 25 2021']")
    WebElement returnDate;

    @FindBy(xpath = "//a[text()='Search']")
    WebElement searchButton;

    @FindBy(className = "listingCard")
    List<WebElement> flightList;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div[3]/div/div[1]/div/label[2]/div/span[1]/span/span")
    WebElement oneStopCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div[3]/div/div[1]/div/label[1]/div/span[1]/span/span")
    WebElement nonStopCheckbox;

    @FindBy(className = "listingCard")
    List<WebElement> oneStopFlightList;

    @FindBy(className = "listingCard")
    List<WebElement> nonStopFlightList;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]")
    List<WebElement> departureFlightList;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[2]")
    List<WebElement> returnFlightList;

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

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //method to search and print flights for round trip
    public void searchFlight() throws InterruptedException {
        homePage.click();
        flightModule.click();
        roundTripRadioButton.click();
        enterFromCity.sendKeys("Mumbai");
        Thread.sleep(500);
        fromCity.click();
        enterToCity.sendKeys("Bengaluru");
        Thread.sleep(500);
        toCity.click();
        selectDate.click();
        departureDate.click();
        returnDate.click();
        searchButton.click();
        Iterator<WebElement> flightItr = flightList.iterator();
        int flightNo = 0;
        while (flightItr.hasNext()) {
            flights.add(flightItr.next().getText());
            flightNo++;
        }
//        flights.forEach(element -> {
//            System.out.println(element);
//            System.out.println(" ");
//        });
//        System.out.println("Total no of Flight : " + flightNo);
    }

    //method to search and print one stop flights for round trip
    public void printOneStopFlights() {
        if (!oneStopCheckbox.isSelected()) {
            oneStopCheckbox.click();
        }
        Iterator itrOneStop = oneStopFlightList.iterator();
        while (itrOneStop.hasNext()) {
            String oneStop = itrOneStop.next().toString();
            oneStopFlights.add(oneStop);
        }
//        System.out.println("\n*****************************************\nOne Stop Flight List");
//        oneStopFlights.forEach(element -> {
//            System.out.println(element);
//            System.out.println(" ");
//        });
//        System.out.println("Total no of one stop flight : " + oneStopFlights.size());
    }

    //method to search and print non stop flights for round trip
    public void printNonStopFlights(WebDriver webdriver) {
        if (!nonStopCheckbox.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) webdriver;
            js.executeScript("arguments[0].click()", nonStopCheckbox);
        }
        Iterator itrOneStop = nonStopFlightList.iterator();
        while (itrOneStop.hasNext()) {
            String oneStop = itrOneStop.next().toString();
            nonStopFlights.add(oneStop);
        }
//        System.out.println("\n*****************************************\nNon Stop Flight List");
//        nonStopFlights.forEach(element -> {
//            System.out.println(element);
//            System.out.println(" ");
//        });
//        System.out.println("Total no of non stop flight : " + nonStopFlights.size());
    }
}
