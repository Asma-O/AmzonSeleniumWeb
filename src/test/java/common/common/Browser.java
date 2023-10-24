package common.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class Browser {

    WebDriver driver;
    public Browser() {
    }

    /**
     * @return CHROME WebDriver
     */
    public static WebDriver createInstance() {
        return createInstance(null);
    }

    static Browser browser = new Browser();


    /**
     * @param browserName firefox, IE, Chrome, Safari, HTMLUnit or HTMLUnitJS
     * @return WebDriver
     */
    @Description("1- Step: Navigating to Amazon website")
    @BeforeClass
    public static WebDriver createInstance(String browserName){
        browserName = Constant.broswer;
        System.out.println("browser Name : " + browserName);
        System.out.println(System.getProperty("os.name"));
        browserName = (browserName != null) ? browserName : "CHROME";

        if (System.getProperty("os.name").toLowerCase().equals("mac os x") || System.getProperty("os.name").toLowerCase().contains("windows")){
            // Browsers.valueOf(browserName.toUpperCase())
            if ("FIREFOX".equals(browserName.toUpperCase())) {
                WebDriverManager.firefoxdriver().setup();
                browser.driver = new FirefoxDriver();
            }  else if ("CHROME".equals(browserName.toUpperCase())) {/**
             * here you can run chrome localy only on your machine by uncomment these 1st two commented lines and re comment the rest but don't forget to import (ChromeDriverManager and Chrome class)
             */

                browser.driver = new ChromeDriver();
            } else if ("SAFARI".equals(browserName.toUpperCase())) {
                browser.driver = new SafariDriver();
            } else {
                browser.driver = new ChromeDriver();
            }
        }else
        {
            System.out.println("Failed to lunch browser");

        }
        // maximize browser's window on start
        browser.driver.manage().window().maximize();
        browser.driver.manage().deleteAllCookies();
        browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        browser.driver.navigate().to(Constant.amazonSite);
        return browser.driver;
    }
}