package com.po.Leftnavigationpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavigationPO {
    // Created public object for driver
    public WebDriver driver;

    // Created public parametrize constructor
    public LeftNavigationPO(WebDriver driver) {
        this.driver = driver;
    }

    //Locators Using selenium "By" method.

    //Open order management
    public By orderManagment = By.xpath("//div/ul[@id='sidebar']/li[8]/a/i");
    //Open create order page
    public By createOrderPage = By.xpath("//div/ul[@id='sidebar']/li[8]/ul/li/a[@href='#/create-order']");
}
