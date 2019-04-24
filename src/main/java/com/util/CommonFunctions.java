package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {

    // Created public object for driver
    public WebDriver driver;
    //  Created public object for wait
    public WebDriverWait wait;

    // Created public parametrize constructor
    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        // Explicit wait.
        wait = new WebDriverWait(driver, 30);
    }

    // created one method name "click"
    // In this method we call "By" method
    public boolean click(By element) throws Exception {
        try {
            // pass the locator "By" --> "webElement" using wait till the button is enable.
            WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            // Click button.
            webElement.click();
            return true;
        } catch (Exception e) {
            // Exception throw
            throw e;
        }
    }

    // created one method name "inputData"
    // In this method we call "By" method and
    public boolean inputData(By element, String testData) throws Exception {
        try {
            // pass the locator "By" --> "webElement" using wait till the fields are visible.
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            //Pass the test data using "testData" parameter and enter in locators place.
            webElement.sendKeys(testData);
            return true;
        } catch (Exception e) {
            // Exception throw
            throw e;
        }
    }

    public boolean titleVerify(By element, String title) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.equals(title);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean validationVerify(By element, String validation) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.equals(validation);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean clear(By element) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.clear();
            return true;
        } catch (Exception e) {
            throw e;
        }

    }

    public boolean dropDown(By element,String dropDownValue) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
           Select dropValue =new Select(webElement);
            dropValue.selectByVisibleText(dropDownValue);
            return true;
        }catch (Exception e){
            throw e;
        }
    }

    public boolean billingto(By element, String billingToValue) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            if (webElement.isDisplayed()){
                System.out.println("Billing to selected.");
            }else {
                System.out.println("Billing to not selected.");
                Select billingValue = new Select(webElement);
                billingValue.selectByVisibleText(billingToValue);
            }
            return true;
        }catch (Exception e){
            throw e;
        }
    }

    public boolean order(By element, String orderValue) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            if (webElement.isDisplayed()){
                System.out.println("Order number is visible.");
            }else {
                System.out.println("Order number not visible.");
                webElement.sendKeys(orderValue);
            }
            return true;
        }catch (Exception e){
            throw e;
        }
    }

    public boolean minMaxLimit(By element, String editBoxValue, String validation , By element1) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.sendKeys(editBoxValue);
            Thread.sleep(5000);
            //To get text from text box.
            String str = webElement.getAttribute("value");
            // Convert text into count and match.
            if(str.length() < 2){
                WebElement webElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
                webElement1.equals(validation);
                System.out.println("Less than 2 characters.");
            }else {
                System.out.println("More than 2 or equal 2 characters.");
            }
            return true;
        } catch (Exception e) {
            throw e;
        }

    }
}
