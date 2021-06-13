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
import org.testng.annotations.Test;

public class MakeMyTripTest extends Base {
    public Search search;
    public Login login;
    public BookFlight book;
//    @Test
//    public void login_Into_Account() throws InterruptedException {
//        login = new Login(webdriver);
//        login.loginToAccount();
//    }

    //test to check functionality of search feature
    @Test(priority = 1)

    public void search_Flight() throws InterruptedException {
        search = new Search(webdriver);
        search.searchFlight();
    }

    //test to check functionality of search feature with one stop filter
    @Test(priority = 2)
    public void whenOneStopFilterApplied_ShouldPrintOneStopFLights() {
        search = new Search(webdriver);
        search.printOneStopFlights();
    }

    //test to check functionality of search feature with non stop filter
    @Test(priority = 3)
    public void whenNonStopFilterApplied_ShouldPrintNonStopFLights() {
        search = new Search(webdriver);
        search.printNonStopFlights(webdriver);
    }

    @Test(priority = 4)
    public void whenGivenListOfFlight_ShouldBookFlight() {
        book = new BookFlight(webdriver);
        book.bookFlight();
    }
}
