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

    /*@Test(description = "TC-01 | Verify Page Name | Login Test case", priority = 1)
    public void Testcase1() throws Exception {

        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.urlVerifyText, "SPECX"), "User not able to verify url.");

    }

    @Test(description = "TC-02 | Click on login button without enter anything | Login Test case", priority = 2)
    public void Testcase2() throws Exception {

        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able to click on login button.");
        WebDriverWait driverWait = new WebDriverWait(driver, 30);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(loginPo.emailBlankValidation));
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.emailBlankValidation, "Please enter email."), "User not able to verify email field validation message.");
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.blankPasswordValidation, "Please enter password."), "User not able to verify password field validation message.");
    }

    @Test(description = "TC-03 | Verify regex > enter email is valid or not | Login Test case", priority = 3)
    public void Testcase3() throws Exception {

        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        ArrayList emails = new ArrayList();
        //Valid email address list
        emails.add("test@test.com");
        emails.add("test.test.test.test@test.org");
        emails.add("t12A@ABC.in");
        emails.add("t-t-t.123@GMAIL.com");
        emails.add("test@test.com.com");
        //Invalid email address list
        emails.add("test");
        emails.add("test@");
        emails.add("test@test");
        emails.add("test....test@test.in");
        emails.add("test__test@test.com");
        emails.add("test._test@test.com");
        emails.add("test.com");
        emails.add("test@test@test.com");
        emails.add(".test@test.com");
        emails.add("test#test@test.com");
        emails.add("test@test#test.com");
        emails.add("test@test..com");
        emails.add("test@test.c");

        System.out.println(emails);

        for (int i = 0; i < emails.size(); i++) {
            System.out.println(i + " " + emails.get(i));
            String email = (String) emails.get(i);
            commonFunctions.verifyEmailRegex(loginPo.emailAddress, email, loginPo.invalidEmailValidation, "Email is invalid.", loginPo.login);
            Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress));
        }
    }

    @Test(description = "TC-04 | Verify password regex:- Password is valid or not | Login Test case", priority = 4)
    public void Testcase4() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.clear(loginPo.password), "User not able to clear password field.");
        ArrayList passwords = new ArrayList();
        //Valid password
        passwords.add("123456");
        passwords.add("ABC__123");
        passwords.add("ab....123");
        passwords.add("()@123456");
        //Invalid password
        passwords.add("123");
        passwords.add("123456789012345678");
        // passwords.add("123   test");
        //passwords.add("         ");
        System.out.println(passwords);

        for (int j = 0; j < passwords.size(); j++) {
            System.out.println(j + " " + passwords.get(j));
            String password = (String) passwords.get(j);
            commonFunctions.verifyPasswordRegex(loginPo.password, password, loginPo.login, loginPo.belowPasswordValidation, "Password must contain at least 6 characters.", loginPo.morePasswordValidation, "Password must contain at most 16 characters.", loginPo.blankPasswordValidation, "Password should not be accept blank space.");
            Assert.assertTrue(commonFunctions.clear(loginPo.password));
        }
    }

    @Test(description = "TC-05 | Enter email address and not enter password, click on login button | Login Test case", priority = 5)
    public void Testcase5() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.password));
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "test@test.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able to click on login button.");
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.blankPasswordValidation, "Please enter password."), "User not able to verify password validation message.");
    }

    @Test(description = "TC-06 | Enter password and not enter email address, click on login button | Login Test case", priority = 6)
    public void Testcase6() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "123456"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able to click on login button.");
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.emailBlankValidation, "Please enter email."), "User not able to verify email validation message.");
    }

    @Test(description = "TC-07 | Enter valid email and wrong password | Login Test case", priority = 7)
    public void Testcase7() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.clear(loginPo.password), "User not able to clear password field.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "priyam@mailinator.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "12354665"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login));
        Assert.assertTrue(commonFunctions.verifyDialogValidation(loginPo.incorrectPassword, "Password is incorrect."), "User not able to verify incorrect password validation message.");
    }

    @Test(description = "TC-08 | Enter wrong email and valid password | Login Test case", priority = 8)
    public void Testcase8() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.clear(loginPo.password), "User not able to clear password field.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "jay@mailinator.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "123456"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login));
        Assert.assertTrue(commonFunctions.verifyDialogValidation(loginPo.incorrectEmail, "This email is not registered."), "User not able to verify incorrect email validation message.");
    }


    @Test(description = "TC-9 | Click on forgot password button and verify forgot password screen and come back login screen. | Login Test case", priority = 9)
    public void Testcase9() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(loginPo.forgotPassword), "User not able to click on forgot password button.");
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.forgotPasswordPageVerify, "Reset Password"), "User not able to verify forgot password screen.");
        Assert.assertTrue(commonFunctions.click(loginPo.returnHome), "user not able to click on return home button.");
    }

    @Test(description = "TC-10 | Click on sign up button and verify sign up screen and come back login screen. | Login Test case", priority = 10)
    public void Testcase10() throws Exception {
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(loginPo.signUp), "User not able to click on sign up button.");
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.signUpPageVerify, "Get Started"), "User not able to verify sign up screen.");
        Thread.sleep(5000);
        Assert.assertTrue(commonFunctions.click(loginPo.retunLogin), "user not able to click on return login button.");
    }*/

    @Test(description = "TC-11 | Enter valid email and valid password | Login Test case", priority = 11)
    public void Testcase11(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Enter Valid Email and valid Password");
        ExtentTestManager.getTest().setDescription("Enter valid email and valid password");

        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "priyam@mailinator.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "123456"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able click on login button.");
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.dashboard, "Project Dashboard"), "User not able to verify dashboard page.");
    }

    @Test(description = "TC-12 | Click On New Requirement Button | Login Test case", priority = 12)
    public void Testcase12(Method method) throws Exception {

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

    @Test(testName = "TC-13 | Click On Edit Button | Screen Test case", priority = 13)
    public void Testcase13(Method method) throws Exception {


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
    @Test(testName = "TC-14 | Click On Delete Button | Screen Test case", priority = 14)
    public void Testcase14(Method method) throws Exception {


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

    @Test(description = "TC-15| Click On Browse Button | Login Test case", priority = 15)
    public void Testcase15(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Click on Browse Button");
        ExtentTestManager.getTest().setDescription(" Click On Browse Button");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.imageUpload(screenDetailPo.image);


    }

    @Test(testName = "TC-16 | Click On Comment Button | Screen Test case", priority = 16)
    public void Testcase16(Method method) throws Exception {


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

    @Test(testName = "TC-17 | Click On Comment Edit Button | Screen Test case", priority = 17)
    public void Testcase17(Method method) throws Exception {


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

    @Test(testName = "TC-18 | Click On Comment Delete Button | Screen Test case", priority = 18)
    public void Testcase18(Method method) throws Exception {


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

    @Test(testName = "TC-19 | Send Invitation | Send Invitations Test case", priority = 19)
    public void Testcase19(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(), "Invite");

        ExtentTestManager.getTest().getTest().setName("Send Invitation");
        ExtentTestManager.getTest().assignCategory("Comment Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.click(screenDetailPo.settingIcon);
        commonFunctions.sendInvitation(screenDetailPo.emailTextBox,screenDetailPo.sendInvitationButton,screenDetailPo.pleaseEnterEmailMessage,"Email is invalid.",screenDetailPo.emailIsInvalidMessage,"Please enter email.",screenDetailPo.sendInvitationSuccessDialog,"Project invitation link is sent successfully",screenDetailPo.closeButton);
    }

   /* @Test(testName = "TC-19 | Send Invitation | Send Invitations Test case", priority = 18)
    public void Testcase18(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(), "Invite");

        ExtentTestManager.getTest().getTest().setName("Send Invitation");
        ExtentTestManager.getTest().assignCategory("Comment Module");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.click(screenDetailPo.settingIcon);
        commonFunctions.sendInvitationToEmail(screenDetailPo.emailTextBox,screenDetailPo.sendInvitationButton,screenDetailPo.pleaseEnterEmailMessage,"Email is invalid.",screenDetailPo.emailIsInvalidMessage,"Please enter email.",screenDetailPo.sendInvitationSuccessDialog,"Project invitation link is sent successfully",screenDetailPo.closeButton,screenDetailPo.contributors,screenDetailPo.contributorCancelButton,screenDetailPo.contributorResendButton,screenDetailPo.cancelInvitationDialogText,screenDetailPo.cancelInvitationCancelButton,screenDetailPo.cancelInvitationOkButton,"Are you sure want to cancel this invitation?");
    }*/



}