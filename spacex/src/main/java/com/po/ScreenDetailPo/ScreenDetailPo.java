package com.po.ScreenDetailPo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScreenDetailPo {
    public WebDriver driver;

    public ScreenDetailPo(WebDriver driver) {
        this.driver = driver;
    }

    public By allProjects = By.xpath("//ul[@class='project-listing box-listing']/li");

    public By allScreens = By.xpath("//ul[@class='project-screens box-listing']/li");

    public By noRequirementFoundLabel = By.xpath("//p[contains(text(),'No requirements found for this screen!')]");

    public By newReuqirementBtn = By.xpath("//a[text()='New Requirement']");

    public By requirementTextBox = By.name("requirement");

    public By saveButton = By.xpath("//input[@value='Save']");

    public By cancelButton = By.xpath("//input[@value='Cancel']");

    public By closeButton = By.xpath("//button[@class='close-toastr toastr-control']");

    public By successfullyAddedDialog = By.xpath("//div[text()='Requirement is created successfully']");

    public By lessThenFiveChar = By.xpath("//span[contains(text(),'Requirement must contain atleast 5 charaters.')]");

    public By pleaseEnterRequirement = By.xpath("//span[contains(text(),'Please enter requirement.')]");




    // ------------------- For Edit Section ------------------------//


    public By editButton = By.xpath("//i[@class='fa fa-pencil']");

    public By listOfRequirements = By.xpath("//div[@class='todo-listing-wrapper']/pre");

    public By deleteButton = By.xpath("//i[@class='fa fa-trash']");

    public By deleteDialogText = By.xpath("//div[@class='rrt-message']");

    public By clickOnOkButton = By.xpath("//button[text()='ok']");

    public By clickOnCancelButton = By.xpath("//button[text()='cancel']");

    public By requirementDeletedSuccessfully = By.xpath("//div[text()='Requirement is deleted successfully']");


    // ----------------------- For Comment Section --------------------- //

    public By commentButton = By.xpath("//i[@class='fa fa-comments']");

    public By backButton = By.xpath("//a[@class='custom-btn back-btn']");

    public By noCommentLabel = By.xpath("//p[text()='No comments found for this requirement!']");

    public By commentTextBox = By.name("comment");

    public By sendButton = By.xpath("//input[@value='Send']");

    public By commentRequirement = By.xpath("//div[@class='todo-listing-wrapper']/pre");

    public By commentsList = By.xpath("//div[@class='chat-wrapper']/p");

    public By pleaseEnterComment = By.xpath("//span[text()='Please enter comment.']");

    public By pleaseEnterLess2Char = By.xpath("//span[text()='Comment must contain atleast 2 charaters.']");

    public By commentAddedSuccessfullyDialog = By.xpath("//div[text()='Comment is created successfully']");




    //------------------- For Comment Edit Section -----------------------//

    public By commentEditButton = By.xpath("//div[@class='chat-options']/a/i[@class='fa fa-pencil']");

    public By commentEditTextBox = By.name("name");

    public By commentEditOkButton = By.name("OK");

    public By commentEditCancelButton = By.name("Cancel");

    public By commentMessageList = By.xpath("//p[@class='chat-message']");

    public By commentUpdatedSuccessfullyDialog = By.xpath("//div[text()='Comment is updated successfully']");



    //----------------- For Comment Delete Section ------------------------//


    public By commentDeleteButton = By.xpath("//div[@class='chat-options']/a/i[@class='fa fa-trash']");

    public By commentDeleteDialogText = By.xpath("//div[@class='rrt-message']");

    public By commentDeleteOkButton = By.xpath("//button[text()='ok']");

    public By commentDeleteCancelButton = By.xpath("//button[text()='cancel']");

    public By commentDeletedSuccessfullyDialog = By.xpath("//div[text()='Comment is deleted successfully']");


    //---------------------- New Task Section -------------------------//

    public By newTaskButton = By.xpath("//a[text()='New Task']");

    public By newTaskTextBox = By.name("task");

    public By newTaskSaveButton = By.xpath("//input[@value='Save']");

    public By newTaskCancelButton = By.xpath("//input[@value='Cancel']");

    public By pleaseEnterTask = By.xpath("Please enter task.");

    //--------------------- Send Invitation Section ----------------------//

    public By settingIcon = By.xpath("//i[@class='fa fa-cog']");

    public By emailTextBox = By.name("email");

    public By sendInvitationButton = By.name("submit");

    public By pleaseEnterEmailMessage = By.xpath("//span[text()='Please enter email.']");

    public By emailIsInvalidMessage = By.xpath("//span[text()='Email is invalid.']");

    public By sendInvitationSuccessDialog = By.xpath("//div[text()='Project invitation link is sent successfully']");

    public By contributors = By.xpath("(//div[@class='contributors-listing'])[3]/table/tbody/tr/td[1]");

    public By contributorCancelButton = By.xpath("(//div[@class='contributors-listing'])[3]/table/tbody/tr/td[2]");

    public By contributorResendButton = By.xpath("(//div[@class='contributors-listing'])[3]/table/tbody/tr/td[3]");

    public By cancelInvitationDialogText = By.xpath("//div[tex()='Are you sure want to cancel this invitation?']");

    public By cancelInvitationOkButton = By.xpath("//button[text()='ok']");

    public By cancelInvitationCancelButton = By.xpath("//button[text()='cancel']");

    public By image = By.xpath("//span[@class='filepond--label-action']");


    

















}
