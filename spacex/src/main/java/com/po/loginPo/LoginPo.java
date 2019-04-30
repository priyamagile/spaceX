package com.po.loginPo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPo {

    public WebDriver driver;

    public LoginPo(WebDriver driver) {
        this.driver = driver;
    }

    //Website name locator.
    public By urlVerifyText = By.xpath("//div[@class='inner-block']/h2[text()='SPECX']");

    //Email field locator.
    public By emailAddress = By.name("email");

    //Blank email field validation message locator.
    public By emailBlankValidation = By.xpath("//span[text()='Please enter email.']");

    //Invalid email field validation message locator.
    public By invalidEmailValidation = By.xpath("//span[text()='Email is invalid.']");

    //Password field locator.
    public By password = By.name("password");

    //Blank password field validation message locator.
    public By blankPasswordValidation = By.xpath("//span[text()='Please enter password.']");

    //Enter below 6 characters password field validation message locator.
    public By belowPasswordValidation = By.xpath("//span[text()='Password must contain atleast 6 charaters.']");

    //Enter more than 16 characters password field validation message locator.
    public By morePasswordValidation = By.xpath("//span[text()='Password must contain atmost 16 charaters.']");

    //Login button locator.
    public By login = By.xpath("//input[@type='submit']");

    //Enter incorrect email and correct password - validation message locator.
    public By incorrectEmail = By.xpath("//div[text()='This email is not registered.']");

    //Enter correct email and wrong password - validation message locator.
    public By incorrectPassword = By.xpath("//div[text()='Password is incorrect.']");

    //Don't have account sign up button locator.
    public By signUp = By.xpath("//a[@class='custom-btn']");

    //Verify sign up page locator.
    public By signUpPageVerify = By.xpath("//h2[text()='Get Started']");

    //Already have account login button locator.
    public By retunLogin = By.xpath("//a[text()='Login']");

    //Forgot password link locator.
    public By forgotPassword = By.xpath("//a[@class='reset-password link-text']");

    //Verify forgot password page locator.
    public By forgotPasswordPageVerify = By.xpath("//h5[text()='Reset Password']");

    //Return home button locator.
    public By returnHome = By.xpath("//a[text()='Return Home']");

    //Dashboard page verify locator.
    public By dashboard = By.xpath("//h3[text()='Project Dashboard']");

    //Blank space in login password validation locator.
    public By blankSpace = By.xpath("//span[text() = 'Please enter email.']");


}
