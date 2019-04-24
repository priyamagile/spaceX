package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    // Created public object for driver
    public WebDriver driver;
    //  Created public object for wait
    public WebDriverWait wait;

    // Created public default constructor
    public BaseTest() {
    }

    //Here we taken parameters annotation because of we want to enter dynamic value or we need to open dynamic browser/Dynamic grid/ Dynamic URL.
    @Parameters({"browserName", "selGrid", "url"})
    //Hete we taken beforeclass annotation because we need to run this code before the classes methods run.
    // Here we taken one more annotation "alwaysRun" because this method run anyhow if any exception is coming then also this method run.
    @BeforeClass(alwaysRun = true)
    // We created one method name "beforeClass", because we check test case is run in local browser or remote browser.
    //Here we taken one annotation name "Optional" because if we did not get value from parameters then string taken that optional value.
    public void beforeClass(@Optional("chrome") String browserName, @Optional("false") String selGrid, @Optional("https://www.google.com") String url) throws Exception {
        //first we check grid is passing true or false, if grid passing true then else part run and if grid passing false then if block run.
        if (selGrid.equalsIgnoreCase("false")) {
            //We redirect driver --> getLocalDriver method with browser name.
            driver = getLocalDriver(browserName);
            System.out.println("grid false");
        } else {
            System.out.println("grid true");
            // Driver pass RemoteWebDriver
            //driver = new RemoteWebDriver()
        }
        // Get url link
        driver.get(url);
        Thread.sleep(5000);
    }

    //We create one new method name "getLocalDriver" , because we need to check passing value is chrome browser of firefox browser or any other browser.
    public WebDriver getLocalDriver(String browserName) {
        // Driver passing null.
        WebDriver driver = null;
        // here we check passing driver value is chrome or firefox driver,
        // if passing value is "chrome" then if block run,
        // if passing value is "firefox" then  else block run.
        if (browserName.equalsIgnoreCase("chrome")) {
            // Set chrome driver location
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
            // Open a new chrome driver.
            driver = new ChromeDriver();
            // Here again we check passing driver is firefox or any other.
            // if passing driver is "firefox" then run if block.
            // if pass block any other browser then it's go out of if block.
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Set firefox driver location
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
            // Open new firefox driver.
            driver = new FirefoxDriver();
        }
        // we open browser in full screen.
        driver.manage().window().maximize();
        //Set implicit wait till the browser is open.
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        // return driver.
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
