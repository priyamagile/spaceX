package com.po.dashboardPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPO {
    public WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    //In dashboard no project fond locator
    public By noProject = By.xpath("//ul[@class='project-listing box-listing']/span");

    //New project button locator
    public By newProjectButton = By.xpath("//a[@class='custom-btn']");

    //New project blog verify locator
    public By newProjectBlog = By.xpath("//div[@class='project-detail-block']/h5");

    //Save button locator
    public By saveButton = By.xpath("//input[@name='submit']");

    //Verify placeholder name locator
    public By projectplaceholdername = By.xpath("//input[@placeholder='Project Name']");

    //Blank validation message verify locator
    public By blankValidation = By.xpath("//span[text()='Please enter project name.']");

    //Less number validation message locator
    public By lessCharacterValidation = By.xpath("//span[text()='Project name must contain atleast 3 charaters.']");

    //More number validation message locator
    public By moreCharacterValidation = By.xpath("//span[text()='Project name must contain atmost 30 charaters.']");

    //Project list locator
    public By projectListTitle = By.xpath("//div[@class='box-wrapper']/div/h4");

    //Add project success message locator.
    public By addProjectSuccessMessage = By.xpath("//div[text()='Project is created successfully']");

    //Edit project locator
    public By editButton = By.xpath("//i[@class='fa fa-pencil']");

    //Edit project success message locator.
    public By editProjectSuccessMessage = By.xpath("//div[text()='Project is updated successfully']");

    //Delete project list locator.
    public By deleteProject = By.xpath("//i[@class='fa fa-trash']");

    //Delete project popup text locator.
    public By deletePopup = By.xpath("//div[@class='rrt-message']");

    //Delete popup "Okay" button locator.
    public By deletePopupOkay = By.xpath("//button[@class='rrt-button rrt-ok-btn toastr-control']");

    //Delete popup "Cancel" button locator.
    public By deletePopupCancel = By.xpath("//button[@class='rrt-button rrt-cancel-btn toastr-control']");

    //Delete popup shadow locator.
    public By deletePopupShadow = By.xpath("//div[@class='shadow']");

    //Delete popup message locator.
    public By deleteMessage = By.xpath("//div[text()='Project is deleted successfully']");

    //Project list for click locator
    public By projectListClick = By.xpath("//ul[@class='project-listing box-listing']/li");



}
