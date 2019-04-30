package com.base;

import com.extentreport.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    @Parameters({"browserName", "selGrid", "url"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(@Optional("chrome") String browserName, @Optional("false") String selGrid, @Optional("http://202.131.117.92:7023/#/login") String url, Method method) {
        if (selGrid.equalsIgnoreCase("false")) {
            driver = getLocalDriver(browserName);
            System.out.println("grid false");
        } else {
            System.out.println("grid true");
            /*driver = new RemoteWebDriver()*/
        }
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);


    }

    public WebDriver getLocalDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void down() {
        driver.quit();
    }
}
