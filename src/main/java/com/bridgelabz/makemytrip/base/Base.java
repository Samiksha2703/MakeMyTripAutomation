/**
 * purpose : To create setup to run before and after test cases
 * Author : Samiksha Shende
 * Date : 09/06/21020
 */

package com.bridgelabz.makemytrip.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver webdriver;

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
//    @AfterTest
//    public void tearDown() {
//        webdriver.close();
//    }
}
