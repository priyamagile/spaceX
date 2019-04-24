package com.po.CreateOrderPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateOrderPO {

    // Created public object for driver
    public WebDriver driver;

   public CreateOrderPO(WebDriver driver){this.driver =driver;}

    //Locators Using selenium "By" method.

    //Open origin dropdown.
    public By originDropDown = By.xpath("//select[@name='client_origin']");
   // billing to dropdown.
    public By billingToDropDown = By.xpath("//select[@name='client_billto']");
    // order#
    public By orderNo = By.xpath("//input[@name='client_order_no']");

}
