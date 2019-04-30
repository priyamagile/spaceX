package com.tc;

import com.base.BaseTest;
import com.extentreport.ExtentTestManager;
import com.po.ScreenDetailPo.ScreenDetailPo;
import com.po.loginPo.LoginPo;
import com.util.CommonFunctions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestCase extends BaseTest {
    private ScreenDetailPo screenDetailPo;
    private CommonFunctions commonFunctions;
    

    @Test(description = "TC-24 | Click On New Requirement Button | Login Test case", priority = 24)
    public void Testcase24(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Click on new Requirement Button");
        ExtentTestManager.getTest().setDescription(" Click On New Requirement Button");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        Assert.assertTrue(commonFunctions.allProject(screenDetailPo.allProjects), "User not be able to open project");
        Assert.assertTrue(commonFunctions.allScreens(screenDetailPo.allScreens), "User not able to open screen");
        Assert.assertTrue(commonFunctions.click(screenDetailPo.closeButton), "User not able click on Button");
        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
        } else {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
        }
    }

    @Test(testName = "TC-25 | Click On Edit Button | Screen Test case", priority = 25)
    public void Testcase25(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Edit Button");

        ExtentTestManager.getTest().getTest().setName("Click On Requirement Edit Button");
        ExtentTestManager.getTest().assignCategory("Requirement Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
        } else {
            commonFunctions.clickOnEditButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.",screenDetailPo.editButton,screenDetailPo.listOfRequirements);
        }
    }
    @Test(testName = "TC-26 | Click On Delete Button | Screen Test case", priority = 26)
    public void Testcase26(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Delete Button");

        ExtentTestManager.getTest().getTest().setName("Click On Requirement Delete Button");
        ExtentTestManager.getTest().assignCategory("Requirement Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
            commonFunctions.clickOnDeleteButton(screenDetailPo.deleteButton,screenDetailPo.listOfRequirements,screenDetailPo.deleteDialogText,"Are you sure want to delete this requirement?",screenDetailPo.clickOnOkButton,screenDetailPo.clickOnCancelButton,screenDetailPo.requirementDeletedSuccessfully,"Requirement deleted successfully",screenDetailPo.closeButton);
        } else {
            commonFunctions.clickOnDeleteButton(screenDetailPo.deleteButton,screenDetailPo.listOfRequirements,screenDetailPo.deleteDialogText,"Are you sure want to delete this requirement?",screenDetailPo.clickOnOkButton,screenDetailPo.clickOnCancelButton,screenDetailPo.requirementDeletedSuccessfully,"Requirement deleted successfully",screenDetailPo.closeButton);
        }
    }

    @Test(description = "TC-27| Click On Browse Button | Login Test case", priority = 27)
    public void Testcase27(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Click on Browse Button");
        ExtentTestManager.getTest().setDescription(" Click On Browse Button");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.imageUpload(screenDetailPo.image);


    }

    @Test(testName = "TC-28 | Click On Comment Button | Screen Test case", priority = 28)
    public void Testcase28(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(), "Comment Button");

        ExtentTestManager.getTest().getTest().setName("Click On Requirement Comment Button");
        ExtentTestManager.getTest().assignCategory("Requirement Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
            commonFunctions.clickOnCommentButton(screenDetailPo.commentButton,screenDetailPo.backButton,screenDetailPo.listOfRequirements,screenDetailPo.noCommentLabel,"No comments found for this requirement!",screenDetailPo.commentTextBox,screenDetailPo.sendButton,screenDetailPo.commentRequirement,screenDetailPo.commentsList,screenDetailPo.pleaseEnterComment,screenDetailPo.pleaseEnterLess2Char,"Please enter comment.","Comment must contain at least 2 characters.",screenDetailPo.commentAddedSuccessfullyDialog,"Comment is created successfully",screenDetailPo.closeButton);
        } else {
            commonFunctions.clickOnCommentButton(screenDetailPo.commentButton,screenDetailPo.backButton,screenDetailPo.listOfRequirements,screenDetailPo.noCommentLabel,"No comments found for this requirement!",screenDetailPo.commentTextBox,screenDetailPo.sendButton,screenDetailPo.commentRequirement,screenDetailPo.commentsList,screenDetailPo.pleaseEnterComment,screenDetailPo.pleaseEnterLess2Char,"Please enter comment.","Comment must contain at least 2 characters.",screenDetailPo.commentAddedSuccessfullyDialog,"Comment is created successfully",screenDetailPo.closeButton);
        }
    }

    @Test(testName = "TC-29 | Click On Comment Edit Button | Screen Test case", priority = 29)
    public void Testcase29(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(), "Edit Button In Comment Screen");

        ExtentTestManager.getTest().getTest().setName("Click On Comment Edit Button");
        ExtentTestManager.getTest().assignCategory("Comment Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
            commonFunctions.click(screenDetailPo.commentButton);
            boolean commentisPresent = commonFunctions.commentIsPresent(screenDetailPo.commentDeleteButton, screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton);
            if (commentisPresent || commentisPresent == false) {
                commonFunctions.clickOnCommentEditButton(screenDetailPo.commentEditButton, screenDetailPo.commentEditOkButton, screenDetailPo.commentEditCancelButton, screenDetailPo.commentEditTextBox, screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton, screenDetailPo.commentUpdatedSuccessfullyDialog, "Comment is updated successfully", screenDetailPo.closeButton);
            }
        } else {

            boolean commentisPresent = commonFunctions.commentIsPresent(screenDetailPo.commentDeleteButton, screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton);
            if (commentisPresent || commentisPresent == false) {
                commonFunctions.clickOnCommentEditButton(screenDetailPo.commentEditButton, screenDetailPo.commentEditOkButton, screenDetailPo.commentEditCancelButton, screenDetailPo.commentEditTextBox, screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton, screenDetailPo.commentUpdatedSuccessfullyDialog, "Comment is updated successfully", screenDetailPo.closeButton);
            }
        }
    }

    @Test(testName = "TC-30 | Click On Comment Delete Button | Screen Test case", priority = 30)
    public void Testcase30(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(), "Edit Button In Comment Screen");

        ExtentTestManager.getTest().getTest().setName("Click On Comment Edit Button");
        ExtentTestManager.getTest().assignCategory("Comment Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
            boolean commentisPresent = commonFunctions.commentIsPresent(screenDetailPo.commentDeleteButton, screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton);
            if (commentisPresent || commentisPresent == false) {
                commonFunctions.clickOnCommentDeleteButton(screenDetailPo.commentDeleteButton, screenDetailPo.commentDeleteOkButton, screenDetailPo.commentDeleteCancelButton, screenDetailPo.commentDeleteDialogText, "Are you sure want to delete this comment?", screenDetailPo.commentDeletedSuccessfullyDialog, "Comment is deleted successfully", screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton,screenDetailPo.closeButton);
            }
        } else {
            boolean commentisPresent = commonFunctions.commentIsPresent(screenDetailPo.commentDeleteButton, screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton);
            if (commentisPresent || commentisPresent == false) {
                commonFunctions.clickOnCommentDeleteButton(screenDetailPo.commentDeleteButton, screenDetailPo.commentDeleteOkButton, screenDetailPo.commentDeleteCancelButton, screenDetailPo.commentDeleteDialogText, "Are you sure want to delete this comment?", screenDetailPo.commentDeletedSuccessfullyDialog, "Comment is deleted successfully", screenDetailPo.commentMessageList, screenDetailPo.commentTextBox, screenDetailPo.sendButton,screenDetailPo.closeButton);
            }
        }
    }

    @Test(testName = "TC-31 | Send Invitation | Send Invitations Test case", priority = 31)
    public void Testcase31(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(), "Invite");

        ExtentTestManager.getTest().getTest().setName("Send Invitation");
        ExtentTestManager.getTest().assignCategory("Comment Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.click(screenDetailPo.settingIcon);
        commonFunctions.sendInvitation(screenDetailPo.emailTextBox,screenDetailPo.sendInvitationButton,screenDetailPo.pleaseEnterEmailMessage,"Email is invalid.",screenDetailPo.emailIsInvalidMessage,"Please enter email.",screenDetailPo.sendInvitationSuccessDialog,"Project invitation link is sent successfully",screenDetailPo.closeButton);
    }





}