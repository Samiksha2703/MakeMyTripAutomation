/**
 * purpose : To perform test to check functionality of different features of MakeMyTrip Application
 * Author : Samiksha Shende
 * Date : 09/06/21020
 */

package com.bridgelabz.makemytrip.test;

import com.bridgelabz.makemytrip.base.Base;
import com.bridgelabz.makemytrip.pages.BookFlight;
import com.bridgelabz.makemytrip.pages.Login;
import com.bridgelabz.makemytrip.pages.Search;
import com.bridgelabz.makemytrip.utility.TestNgListener;
import com.bridgelabz.makemytrip.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(TestNgListener.class)
public class MakeMyTripTest extends Base {
    public Search search;
    public Login login;
    public BookFlight book;

    //test to check functionality of search feature
    @Test(priority = 1)

    public void search_Flight() throws InterruptedException, IOException {
        search = new Search(webdriver);
        try {
            search.searchFlight();
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("searchFlightPage")));
        } catch (InterruptedException e) {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("searchFlightPage")));
            e.printStackTrace();
        }
    }

    //test to check functionality of search feature with one stop filter
    @Test(priority = 2)
    public void whenOneStopFilterApplied_ShouldPrintOneStopFLights() throws IOException {
        search = new Search(webdriver);
        try {
            search.printOneStopFlights();
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("OneStopFlight")));
        } catch (IOException e) {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("OneStopFlight")));
            e.printStackTrace();
        }
    }

    //test to check functionality of search feature with non stop filter
    @Test(priority = 3)
    public void whenNonStopFilterApplied_ShouldPrintNonStopFLights() throws IOException {
        search = new Search(webdriver);
        try {
            search.printNonStopFlights(webdriver);
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("NonStopFlight")));
        } catch (IOException e) {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("NonStopFlight")));
            e.printStackTrace();
        }

    }

    //test to check functionality of book feature
    @Test(priority = 4)
    public void whenGivenListOfFlight_ShouldBookFlight() throws IOException {
        book = new BookFlight(webdriver);
        try {
            book.bookFlight();
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("BookFlight")));
        } catch (IOException e) {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("BookFlight")));
            e.printStackTrace();
        }
    }
}
