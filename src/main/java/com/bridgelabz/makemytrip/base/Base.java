/**
 * purpose : To create setup to run before and after test cases
 * Author : Samiksha Shende
 * Date : 09/06/21020
 */

package com.bridgelabz.makemytrip.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver webdriver;
    public static ExtentTest test;
    static ExtentReports report;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    //method to launch browser
    @BeforeTest
    @Parameters("browserName")
    public static void setUp(String browserName) {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webdriver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webdriver = new FirefoxDriver();
        }
        threadLocal.set(webdriver);
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            URL url = new URL("https://www.makemytrip.com/");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            // launch application
            webdriver.get("https://www.makemytrip.com/");
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    //method to close the session open by driver
    @AfterTest
    public void tearDown() {
        webdriver.close();
    }

    //method to run before class to generate extent report
    @BeforeClass
    public static void startTest() {
        report = new ExtentReports("C:\\Users\\kalam\\IdeaProjects\\MakeMyTripAutomation\\src\\main\\resources\\ExtentReport\\" + "ExtentReportResults.html");
        test = report.startTest("Bookswagon Extent Report");
    }

    //method to run after class to generate extent report
    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }
}
