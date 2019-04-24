package com.po.Loginpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPO {

    // Created public object for driver
    public WebDriver driver;

    // Created public parametrize constructor
    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    //Locators Using selenium "By" method.

    // Login page title name
    public By loginpagetitle = By.xpath("//h4[@class=\"text-center\"]");
    // Username field locators
    public By userName = By.name("login_user_id");
    // password field locators
    public By password = By.name("password");
    // login button locators
    public By loginButton = By.xpath("//button[@class='btn btn-primary']");
    // Username validation message
    public By userNameValidation = By.xpath("//span[text()='User ID is required.']");
    // Password validation message
    public By passwordValidation = By.xpath("//span[text()='Password is required.']");
    // Invalid username and password validation message
    public By invalidUserValidation = By.xpath("//span[text()='Invalid user id or password.']");
    // Forgot password link
    public By forgotPassword = By.xpath("//a[@href='#/forgot-password']");
    // Already have account link (forgot password screen.)
    public By alreadyHaveAccount = By.xpath("//a[@href='#/login']");
    // Home page verify
    public By homePageVerify = By.xpath("//span[@class='hidden-xs ng-binding']");


}
