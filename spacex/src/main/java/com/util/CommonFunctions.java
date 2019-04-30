package com.util;


import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.mail.util.PropUtil;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.mail.*;
import javax.mail.search.SubjectTerm;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctions {

    public WebDriver driver;
    public WebDriverWait wait;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    // click method
    public boolean click(By element) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            webElement.click();

            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    // clear method
    public boolean clear(By element) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    //Verify dialog validation message method
    public boolean verifyDialogValidation(By element, String validation) throws Exception {
        try {
            List<WebElement> webElements = driver.findElements(element);
            boolean isDialogPresents = webElements.size() > 0;
            String text = webElements.get(0).getText();
            System.out.println(text);
            if (isDialogPresents) {
                System.out.println("Dialog is present.");
                if (text.equals(validation)) {
                    System.out.println("Dialog validation message verify successfully.");
                    return true;
                } else {
                    System.out.println("Dialog message not verify.");
                    return false;
                }
            } else {
                System.out.println("Dialog is not present.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean allProject(By element) throws Exception {

        try {
            List<WebElement> allProjects = driver.findElements(element);
            allProjects.get(0).click();
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    public boolean allScreens(By element) throws Exception {
        try {
            List<WebElement> allScreens = driver.findElements(element);
            allScreens.get(0).click();
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    public boolean noReqLabelisPresent(By noRequirementFoundLabel, String s) throws Exception {

        try {
            Thread.sleep(2000);
            if (isElementPresent(noRequirementFoundLabel)) {
                System.out.println("No Requirement Found!");

                WebElement labelNoReq = driver.findElement(noRequirementFoundLabel);

                String label = labelNoReq.getText();
                if (label.equals(s)) {
                    System.out.println("Label --:> No requirements found for this screen! is Verify");
                } else {
                    System.out.println("Label --:> No requirements found for this screen! is Not Verify");
                }
                return true;
            } else {
                System.out.println("Requirement List Found!");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void clickOnNewReqButton(By newReuqirementBtn, By requirementTextBox, By saveButton, By cancelButton, By successfullyAddedDialog, By lessThenFiveChar, String lessThenFiveCharValidation, By pleaseEnterRequirement, String enterRequirementText) throws Exception {
        try {
            ArrayList<String> getData = new ArrayList<String>();
            getData.add("test");
            getData.add("     ");
            Random random = new Random();

            int randromNumber = random.nextInt(1000);
            getData.add("hello this is new requirement test@#$%^&" + randromNumber);

            for (int i = 0; i < getData.size(); i++) {

                //find New Requirement Button Here!
                WebElement newRequirementButton = wait.until(ExpectedConditions.visibilityOfElementLocated(newReuqirementBtn));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", newRequirementButton);
                //clicked on new Requirement Button!
                newRequirementButton.click();

                //requirement textbox
                WebElement requirementTxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(requirementTextBox));

                //entered text!
                requirementTxtBox.sendKeys(getData.get(i));

                String main = "^(?=.*[0-9a-zA-Z@#$%^&+=])(?=\\S).{5,}$";
                String blank = "^\\s+$";

                Pattern mainPattern = Pattern.compile(main);

                Matcher mainmMtcher = mainPattern.matcher(getData.get(i));

                Pattern blankPattern = Pattern.compile(blank);

                Matcher blankMatcher = blankPattern.matcher(getData.get(i));

                if (mainmMtcher.matches()) {
                    System.out.println("\nPattern is Matched and Verify With Entered Text!");

                    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
                    saveBtn.click();

                    verifyDialogValidation(successfullyAddedDialog, getData.get(i));
                } else if (getData.get(i).length() < 5) {
                    System.out.println("\nRequirement Text is less Then 5 Character!");

                    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
                    saveBtn.click();

                    if (driver.findElement(lessThenFiveChar).getText().equals(lessThenFiveCharValidation)) {
                        System.out.println(lessThenFiveCharValidation + " : is Verified.");
                    } else {
                        System.out.println(lessThenFiveCharValidation + " : is Not Verified");
                    }

                    WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
                    cancelBtn.click();
                } else if (blankMatcher.matches()) {
                    System.out.println("\nBlank Space Doesn't Allow!");

                    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
                    saveBtn.click();

                    if (driver.findElement(pleaseEnterRequirement).getText().equals(enterRequirementText)) {
                        System.out.println(enterRequirementText + " : is verified");
                    } else {
                        System.out.println(enterRequirementText + " : is not verified");
                    }

                    WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
                    cancelBtn.click();
                } else {
                    WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
                    cancelBtn.click();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void clickOnEditButton(By newReuqirementBtn, By requirementTextBox, By saveButton, By cancelButton, By successfullyAddedDialog, By lessThenFiveChar, String s, By pleaseEnterRequirement, String s1, By editButton, By listOfRequirements) throws Exception {

        try {
            List<WebElement> elements = driver.findElements(editButton);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements.get(0));

            elements.get(0).click();

            WebElement requirementTb = wait.until(ExpectedConditions.visibilityOfElementLocated(requirementTextBox));

            String requirementTbText = requirementTb.getText();


            System.out.println(requirementTbText);

            WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));

            saveBtn.click();

            List<WebElement> requirementList = driver.findElements(listOfRequirements);

            String requirementListText = requirementList.get(0).getText();

            if (requirementListText.equals(requirementTbText)) {
                System.out.println("Requirement Text is Matched");
            } else {
                System.out.println("Requirement Text is Not Matched!");
            }

            WebElement editButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));

            List<WebElement> editElements = driver.findElements(editButton);
            Thread.sleep(500);

            editElements.get(0).click();

            WebElement requirementTextbox2 = driver.findElement(requirementTextBox);

            String text = requirementTextbox2.getText();
            requirementTextbox2.clear();

            requirementTextbox2.sendKeys(text + " This is Edited Text");

            String editedRequirementText = requirementTextbox2.getText();


            WebElement cancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));

            cancelBtn.click();

            if (text.equals(editedRequirementText)) {
                System.out.println("After Edit --> Requirement Text is Matched");
            } else {
                System.out.println("After Edit --> Requirement Text is Not Matched!");
            }
        } catch (Exception e) {
            throw e;
        }


    }

    public void clickOnDeleteButton(By deleteButton, By listOfRequirements, By deleteDialogText, String deleteRequirementDialogBoxText, By clickOnOkButton, By clickOnCancelButton, By requirementDeletedSuccessfully, String requirement_deleted_successfully, By closeButton) throws Exception {

        try {

            List<WebElement> listsOfReq = driver.findElements(listOfRequirements);

            String requirementTextBeforeDelete = listsOfReq.get(0).getText();

            System.out.println("Requirement Before Delete --> " + requirementTextBeforeDelete);

            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));

            List<WebElement> deleteBtn = driver.findElements(deleteButton);

            deleteBtn.get(0).click();

            WebElement deleteDialogTxt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteDialogText));

            System.out.println(deleteDialogTxt1.getText());

            if (deleteDialogTxt1.getText().equals(deleteRequirementDialogBoxText)) {
                System.out.println("Dialog Text --> Successfully Verify");
            } else {
                System.out.println("Dialog Text --> Not Verify");
            }

            WebElement clickOnCancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCancelButton));

            clickOnCancelBtn.click();

            String requirementtextAfterCancelButton = listsOfReq.get(0).getText();

            System.out.println("Requirement Text After Cancel --> " + requirementtextAfterCancelButton);

            if (requirementTextBeforeDelete.equals(requirementtextAfterCancelButton)) {
                System.out.println("Click On Cancel Button --> Data is Present in The Requirement List.");
            } else {
                System.out.println("Click On Cancel Button --> Data is Not Present in The Requirement List.");
            }

            Thread.sleep(2000);
            deleteBtn.get(0).click();


            WebElement deleteDialogTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteDialogText));

            System.out.println(deleteDialogTxt.getText());


            if (deleteDialogTxt.getText().equals(deleteRequirementDialogBoxText)) {

                System.out.println("Dialog Text --> SuccessFully Verify");

                WebElement clickOnOkBtn = driver.findElement(clickOnOkButton);

                clickOnOkBtn.click();

                String requirementtextAfterOkButton = listsOfReq.get(0).getText();

                System.out.println("Requirement Text After Click On Ok Button --> " + requirementtextAfterOkButton);

                if (requirementTextBeforeDelete.equalsIgnoreCase(requirementtextAfterOkButton)) {
                    System.out.println("Click On Ok Button --> Data is Successfully Deleted.");

                    WebElement requrementDeletedSuccessDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(requirementDeletedSuccessfully));

                    if (requrementDeletedSuccessDialog.getText().equals(requirement_deleted_successfully)) {

                        System.out.println("After Delete --> Requirement Delete Dialog Successfully Verify.");

                        WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));

                        closeBtn.click();
                    } else {
                        System.out.println("After Delete --> Dialog is Not Present.");
                    }

                } else {
                    System.out.println("Click On Ok Button --> Data is Present in The Requirement List.");
                }
            } else {
                System.out.println("Dialog Text --> Text Not Verify, Dialog is not Present.");
            }


        } catch (Exception e) {
            throw e;
        }

    }

    public void clickOnCommentButton(By commentButton, By backButton, By listOfRequirements, By noCommentLabel, String noCommentsfoundText, By commentTextBox, By sendButton, By commentRequirement, By commentsList, By pleaseEnterComment, By pleaseEnterLess2Char, String pleaseEnterCommmentText, String pleaseEnterLess2CharText, By commentAddedSuccessfullyDialog, String commentAddedSuccessfullyText, By closeButton) throws Exception {


        try {
            ArrayList<String> textForComments = new ArrayList<String>();

            Random random = new Random();

            // Generate random integers in range 0 to 999
            int randomNumber = random.nextInt(1000);

            textForComments.add("       ");
            textForComments.add("a");
            textForComments.add("Hello, this is First Comment!" + randomNumber);


            List<WebElement> requirementListInMainScreen = driver.findElements(listOfRequirements);

            String requirementTextMainScreen = requirementListInMainScreen.get(0).getText();

            System.out.println("Requirement Text In Main Screen --> " + requirementTextMainScreen);

            wait.until(ExpectedConditions.visibilityOfElementLocated(commentButton));

            List<WebElement> commentBtn1 = driver.findElements(commentButton);

            commentBtn1.get(0).click();

            System.out.println("SuccessFully Clicked on comment button");

            wait.until(ExpectedConditions.visibilityOfElementLocated(backButton));

            List<WebElement> backBtn = driver.findElements(backButton);

            backBtn.get(0).click();

            System.out.println("SuccessFully Clicked on back button");

            List<WebElement> commentBtn2 = driver.findElements(commentButton);

            commentBtn2.get(0).click();

            WebElement requirement = wait.until(ExpectedConditions.visibilityOfElementLocated(commentRequirement));

            String requirementTextInCommentScreen = requirement.getText();

            System.out.println("Requirement Text In Comment Screen --> " + requirementTextInCommentScreen);

            if (requirementTextInCommentScreen.equals(requirementTextMainScreen)) {
                System.out.println("Requirement Text --> Requirement text is matched in Comment Screen.");

               /* if (driver.findElements(commentButton).size()!=0) {
                    System.out.println("Comment Button is Showing in the Comment Screen.");
                }
                else{
                    System.out.println("Comment Button is Not Showing is the Comment Screen.");
                }*/


                if (isElementPresent(noCommentLabel)) {
                    System.out.println("Comments --> No Comments Label is Present.");
                    if (driver.findElement(noCommentLabel).getText().equals(noCommentsfoundText)) {
                        System.out.println("Comments --> No Comments Label Text is Matched!");
                    } else {
                        System.out.println("Comments --> No Comments label Text is Not Matched!");
                    }
                } else {
                    System.out.println("Comments --> Comments are Found!.");
                }
                WebElement commentTb = wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextBox));

                if (commentTb.isDisplayed()) {
                    System.out.println("Comments --> Comment TextBox is Visible.");

                    WebElement sendBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(sendButton));

                    if (sendBtn.isDisplayed()) {
                        System.out.println("Comments --> Send Button is Visible.");

                        for (int i = 0; i < textForComments.size(); i++) {
                            String textForComm = textForComments.get(i);

                            commentTb.sendKeys(textForComm);

                            String main = "^(?=.*[0-9a-zA-Z@#$%^&+=])(?=\\S).{2,}$";
                            String blank = "^\\s+$";

                            Pattern patternBlank = Pattern.compile(blank);
                            Matcher matcherBlank = patternBlank.matcher(textForComm);

                            Pattern patternMain = Pattern.compile(main);
                            Matcher matcherMain = patternMain.matcher(textForComm);

                            if (matcherBlank.matches()) {
                                System.out.println("Comment Text --> Text is Blank");
                                sendBtn.click();
                                commentTb.clear();

                                WebElement pleaseEnterComm = driver.findElement(pleaseEnterComment);

                                if (pleaseEnterComm.isDisplayed()) {
                                    System.out.println("Comment Text --> Please Enter Comment Validation Error Message is Visible.");
                                    if (pleaseEnterComm.getText().equals(pleaseEnterCommmentText)) {
                                        System.out.println("Comment Text --> Please Enter Comment is Verified.");
                                    } else {
                                        System.out.println("Comment Text --> Please Enter Comment is Not Verified.");
                                    }
                                } else {
                                    System.out.println("Please Enter Comment Validation Error Message is Not Visible.");
                                }
                            } else if (textForComm.length() < 2) {
                                System.out.println("Comment Text --> Text is Less Then 2 Character.");
                                sendBtn.click();
                                commentTb.clear();


                                WebElement pleaseEnterLess2 = driver.findElement(pleaseEnterLess2Char);

                                if (pleaseEnterLess2.isDisplayed()) {
                                    System.out.println("Comment Text --> Please Enter Less Then 2 Character Validation Error Message is Visible.");
                                    if (pleaseEnterLess2.getText().equals(pleaseEnterLess2CharText)) {
                                        System.out.println("Comment Text --> Please Enter Less Then 2 Char is Verified.");
                                    } else {
                                        System.out.println("Comment Text --> Please Enter Less Then 2 Char is Not Verified.");
                                    }
                                } else {
                                    System.out.println("Please Enter Less Then 2 Char Validation Error Message is Not Visible.");
                                }
                            } else if (matcherMain.matches()) {
                                System.out.println("Comment Text --> Text is Valid.");
                                sendBtn.click();
                                commentTb.clear();

                                WebElement commentAddedDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(commentAddedSuccessfullyDialog));

                                String commentAddedText = commentAddedDialog.getText();
                                System.out.println(commentAddedText);

                                if (commentAddedText.equals(commentAddedSuccessfullyText)) {
                                    System.out.println("Comment --> Comment Created Successfully Dialog Verify Successfully");
                                    WebElement closeBtn = driver.findElement(closeButton);
                                    closeBtn.click();

                                    List<WebElement> commentList = driver.findElements(commentsList);

                                    WebElement webElement = commentList.get(commentList.size() - 1);

                                    String recentComment = webElement.getText();

                                    System.out.println(textForComm);
                                    System.out.println(recentComment);

                                    if (textForComm.equals(recentComment)) {
                                        System.out.println("Comment --> Comment is added successfully.");

                                    } else {
                                        System.out.println("Comment --> Comment is Not Added.");
                                    }
                                } else {
                                    System.out.println("Comment --> Comment Created Successfully Dialog is Not Visible");
                                }
                            }
                        }
                    } else {
                        System.out.println("Comments --> Send Button is Not Visible.");
                    }
                } else {
                    System.out.println("Comments --> Comment TextBox is Not Visible.");
                }
            } else {
                System.out.println("Requirement Text --> Requirement text is not matched in Comment Screen.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void clickOnCommentEditButton(By commentEditButton, By commentEditOkButton, By commentEditCancelButton, By commentEditTextBox, By commentMessageList, By commentTextBox, By sendButton, By commentUpdatedSuccessfullyDialog, String comment_is_updated_successfully, By closeButton) throws Exception {
        try {
            String newComment = "Hello, This is New Comment";

            ArrayList<String> editCommentText = new ArrayList<String>();
            editCommentText.add("         ");
            editCommentText.add("");
            editCommentText.add("aksdjladjkljldljkakj");


            List<WebElement> commentList = driver.findElements(commentMessageList);


            System.out.println("Comments List --> Comments List is Present");
            String commentTextBeforeClickOnEdit = commentList.get(0).getText();
            System.out.println("Before Click --> " + commentTextBeforeClickOnEdit);

            List<WebElement> commentEditBtn = driver.findElements(commentEditButton);

            commentEditBtn.get(0).click();

            WebElement commentEditTb = wait.until(ExpectedConditions.visibilityOfElementLocated(commentEditTextBox));

            String commentTextAfterClickOnEdit = commentEditTb.getAttribute("value");
            System.out.println("After Click --> " + commentTextAfterClickOnEdit);
            if (commentTextBeforeClickOnEdit.equalsIgnoreCase(commentTextAfterClickOnEdit)) {
                System.out.println("Comment List --> Comment Text Are Matched.");

                WebElement commentEditCancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(commentEditCancelButton));
                commentEditTb.clear();
                commentEditTb.sendKeys(commentTextAfterClickOnEdit + " abc");

                commentEditCancelBtn.click();

                List<WebElement> commentList1 = driver.findElements(commentMessageList);

                String commentTextAfterCancel = commentList1.get(0).getText();

                System.out.println("After Click on Cancel --> " + commentTextAfterCancel);

                if (commentTextAfterCancel.equalsIgnoreCase(commentTextAfterClickOnEdit)) {
                    System.out.println("Comment Text --> Text is Matched After Clicked on Cancel.");


                    for (int i = 0; i < editCommentText.size(); i++) {
                        commentEditBtn.get(0).click();
                        WebElement commentEditCancelBtn2 = driver.findElement(commentEditCancelButton);
                        String editCommentTxt = editCommentText.get(i);
                        WebElement commentEditTb2 = driver.findElement(commentEditTextBox);
                        commentEditTb2.clear();
                        commentEditTb2.sendKeys(editCommentTxt);

                        String main = "^(?=.*[0-9a-zA-Z@#$%^&+=])(?=\\S).{2,}$";
                        String blank = "^\\s+$";

                        Pattern patternMain = Pattern.compile(main);
                        Matcher matcherMain = patternMain.matcher(editCommentTxt);

                        Pattern patterBlank = Pattern.compile(blank);
                        Matcher matcherBlank = patterBlank.matcher(editCommentTxt);

                        if (matcherBlank.matches()) {
                            System.out.println("Comment Text --> Text is Blank.");
                            WebElement commentEditOkBtn = driver.findElement(commentEditOkButton);
                            commentEditOkBtn.click();
                            Thread.sleep(1000);

                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            String alertText = (String) js.executeScript("return arguments[0].validationMessage;", commentEditTb2);
                            System.out.println("Showing JavaScript Alert --> " + alertText);
                            commentEditCancelBtn2.click();
                        } else if (editCommentTxt.equalsIgnoreCase("")) {
                            System.out.println("Comment Text --> Text is Mot Entered.");
                            WebElement commentEditOkBtn = driver.findElement(commentEditOkButton);
                            commentEditOkBtn.click();
                            Thread.sleep(1000);

                            JavascriptExecutor js = (JavascriptExecutor) driver;
                            String alertText = (String) js.executeScript("return arguments[0].validationMessage;", commentEditTb2);
                            System.out.println("Showing JavaScript Alert --> " + alertText);

                            commentEditTb2.clear();

                            commentEditCancelBtn2.click();
                        } else if (matcherMain.matches()) {
                            System.out.println("Comment Text --> Text is Valid.");
                            WebElement commentEditOkBtn = driver.findElement(commentEditOkButton);
                            commentEditOkBtn.click();

                            WebElement commentUpdatedSuuccfullyDg = driver.findElement(commentUpdatedSuccessfullyDialog);
                            String commentUpdatedSuuccfullyDgText = commentUpdatedSuuccfullyDg.getText();

                            if (comment_is_updated_successfully.equalsIgnoreCase(commentUpdatedSuuccfullyDgText)) {

                                System.out.println("Comment Update --> Dialog is Successfully Verified.");

                                driver.findElement(closeButton).click();

                            } else {
                                System.out.println("Comment Update --> Dialog is Not Verified");
                            }
                        }
                    }
                } else {
                    System.out.println("Comment Text --> Text is Not Matched After Clicked on Cancel");
                }
            } else {
                System.out.println("Comment List --> Comment Text Are Not Matched.");
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void clickOnCommentDeleteButton(By commentDeleteButton, By commentDeleteOkButton, By commentDeleteCancelButton, By commentDeleteDialogText, String comment_delete_dialog_text, By commentDeletedSuccessfullyDialog, String comment_is_deleted_successfully, By commentMessageList, By commentTextBox, By sendButton, By closeButton) throws Exception {

        try {


            wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeleteButton));

            List<WebElement> commentList = driver.findElements(commentMessageList);

            String commentMessageBeforeCancel = commentList.get(0).getText();

            List<WebElement> commentDeleteBtn = driver.findElements(commentDeleteButton);

            commentDeleteBtn.get(0).click();

            WebElement cancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeleteCancelButton));

            cancelBtn.click();

            String commentMessageAfterCancel = commentList.get(0).getText();


            if (commentMessageAfterCancel.equalsIgnoreCase(commentMessageBeforeCancel)) {
                System.out.println("Cancel Button --> Comment is Present, Cancel Button is working Properly.");
            } else {
                System.out.println("Cancel Button --> Comment is Deleted, Cancel Button is Not working Properly.");
            }

            Thread.sleep(1000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeleteButton));

            List<WebElement> commentDeleteBtn2 = driver.findElements(commentDeleteButton);

            commentDeleteBtn2.get(0).click();

            WebElement commentDeleteDialogTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeleteDialogText));

            if (comment_delete_dialog_text.equalsIgnoreCase(commentDeleteDialogTxt.getText())) {
                System.out.println("Comment Delete --> Delete Dialog is Appear.");

                String commentMessageBeforeOkButton = commentList.get(0).getText();

                int beforeDelete = commentList.size();

                WebElement okBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeleteOkButton));

                okBtn.click();

                if (commentMessageBeforeCancel.equalsIgnoreCase(commentMessageBeforeOkButton) || commentList.size() != beforeDelete) {
                    System.out.println("Comment Delete --> Comment Deleted Successfully.");

                    WebElement commentDeletedSuccessfullyText = wait.until(ExpectedConditions.visibilityOfElementLocated(commentDeletedSuccessfullyDialog));

                    if (comment_is_deleted_successfully.equalsIgnoreCase(commentDeletedSuccessfullyText.getText())) {
                        System.out.println("Comment Delete --> Comment Deleted Successfully Dialog is Verified.");

                        WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
                        closeBtn.click();
                    } else {
                        System.out.println("Comment Delete --> Comment Deleted Successfully Dialog not is Verified.");
                    }

                } else {
                    System.out.println("Comment Delete --> Comment is Not Successfully.");
                }

            } else {
                System.out.println("Comment Delete --> Delete Dialog is Not Appear.");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public boolean commentIsPresent(By commentDeleteButton, By commentMessageList, By commentTextBox, By sendButton) throws Exception {

        try {

            String newComment = "Hello, This is New Comment";

            List<WebElement> commentList = driver.findElements(commentMessageList);

            if (commentList.size() == 0) {

                System.out.println("Comments List --> Comments List is Not Present, send new Comment");
                WebElement commentTb = driver.findElement(commentTextBox);
                commentTb.sendKeys(newComment);
                WebElement sendBtn = driver.findElement(sendButton);
                sendBtn.click();
                return true;
            } else {
                System.out.println("Comments List --> Comments List is Present");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }


    public void sendInvitation(By emailTextBox, By sendInvitationButton, By pleaseEnterEmailMessage, String please_enter_email, By emailIsInvalidMessage, String email_is_invalid, By sendInvitationSuccessDialog, String send_invitation_success_dialog_text, By closeButton) throws Exception {

        try {

            ArrayList<String> emails = new ArrayList<String>();
            String emailRegex = "^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$";

            Random random = new Random();
            int randomNumber = random.nextInt(1000);

            //valid
            emails.add("test@test.com");
            emails.add("test.test.test.test@test.org");
            emails.add("t12A@ABC.in");
            emails.add("t-t-t.123@GMAIL.com");
            emails.add("test@test.com.com");

            //invalid
            emails.add("test");
            emails.add("test@");
            emails.add("test@test");

            Pattern pattern = Pattern.compile(emailRegex);

            for (int i = 0; i < emails.size(); i++) {
                WebElement emailTb = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
                Matcher matcher = pattern.matcher(emails.get(i));

                if (matcher.matches()) {
                    System.out.println("Email is valid");
                    emailTb.sendKeys(emails.get(i));

                    WebElement sendInvitationBtn = driver.findElement(sendInvitationButton);
                    sendInvitationBtn.click();

                    WebElement sendInvitationSuccessDlg = wait.until(ExpectedConditions.visibilityOfElementLocated(sendInvitationSuccessDialog));

                    if (sendInvitationSuccessDlg.getText().equalsIgnoreCase(send_invitation_success_dialog_text)) {
                        System.out.println("Send Invitation Successfully Dialog is Verify");
                        WebElement element = driver.findElement(closeButton);
                        element.click();
                    } else {
                        System.out.println("Send Invitation Successfully Dialog is not Verify");
                    }

                    if (isElementPresent(emailIsInvalidMessage)) {
                        List<WebElement> emailIsInvalidValidationMsg = driver.findElements(emailIsInvalidMessage);
                        System.out.println("Email is Invalid In Regex, Validation Message found.");

                        if (emailIsInvalidValidationMsg.get(0).getText().equalsIgnoreCase(email_is_invalid)) {
                            System.out.println("Validation Message Verify.");
                        } else {
                            System.out.println("Validation massage is not verify.");
                        }
                    }
                    driver.manage().timeouts().implicitlyWait(Integer.parseInt("5"), TimeUnit.SECONDS);
                } else {
                    System.out.println("Email is Invalid.");

                    emailTb.sendKeys(emails.get(i));
                    WebElement sendInvitationBtn = driver.findElement(sendInvitationButton);
                    sendInvitationBtn.click();
                    emailTb.clear();


                    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailIsInvalidMessage));

                    String emailIsInvalidTextMsg = element.getText();
                    System.out.println(emailIsInvalidTextMsg);

                    if (emailIsInvalidTextMsg.equalsIgnoreCase(email_is_invalid)) {

                        System.out.println("Email is Invalid Validation Message is Verify.");
                    } else {
                        System.out.println("Email is Invalid Validation Message is Not Verify.");
                    }
                    if (element.isDisplayed()) {
                        System.out.println("Email is Invalid Regex, Validation Message found.");

                        if (element.getText().equalsIgnoreCase(email_is_invalid)) {
                            System.out.println("Validation Message Verify.");
                        } else {
                            System.out.println("Validation massage is not verify.");
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void sendInvitationToEmail(By emailTextBox, By sendInvitationButton, By pleaseEnterEmailMessage, String s, By emailIsInvalidMessage, String s1, By sendInvitationSuccessDialog, String s2, By closeButton, By contributors, By contributorCancelButton, By contributorResendButton, By cancelInvitationDialogText, By cancelInvitationCancelButton, By cancelInvitationOkButton, String invitation_cancel_dialog_text) throws Exception {

        try {

            String email = "jatush.lashkari@agileinfoways.com";

            WebElement emailTb = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
            emailTb.sendKeys(email);

            driver.findElement(sendInvitationButton).click();
            Thread.sleep(5000);


            /*wait.until(ExpectedConditions.visibilityOfElementLocated(contributors));

            List<WebElement> contributor = driver.findElements(contributors);

            String contributorText = contributor.get(contributor.size() - 1).getText();

            if (contributorText.equalsIgnoreCase(email)){
                System.out.println("Invitation is sent!");

                List<WebElement> cancelBtn = driver.findElements(contributorCancelButton);

                String cancelButtonText = cancelBtn.get(cancelBtn.size() - 1).getText();

                if (cancelButtonText.equalsIgnoreCase("Cancel")){
                    System.out.println("Invitation is not Canceled.");
                    cancelBtn.get(cancelBtn.size()-1).click();

                    WebElement cancelInvitationDialogTxt = driver.findElement(cancelInvitationDialogText);

                    if (cancelInvitationDialogTxt.getText().equalsIgnoreCase(invitation_cancel_dialog_text)) {
                        System.out.println("Dialog Text is Verify Successfully.");

                        driver.findElement(cancelInvitationCancelButton).click();

                        List<WebElement> aftercancelBtn = driver.findElements(contributorCancelButton);

                        String aftercancelButtonText = aftercancelBtn.get(aftercancelBtn.size() - 1).getText();

                        if (aftercancelButtonText.equalsIgnoreCase("Canceled")) {
                            System.out.println("Successfully Verified");
                        }
                        else{
                            System.out.println("It Canceled The Invitation When Click on cancel button on Dialog box.");
                        }
                    }
                    else{
                        System.out.println("Dialog Text is Not Verify.");
                    }
                    System.out.println("Invitation is Canceled.");
                }
                else {
                    System.out.println("Invitation is Canceled.");
                }
            }*/
        } catch (Exception e) {
            throw e;
        }

    }

    public void imageUpload(By image) throws Exception {

        try {

            driver.findElement(image).click();

            Thread.sleep(3000);

            Runtime.getRuntime().exec("E:\\Jatush\\project\\spacex\\src\\main\\resources\\ImageUploadScript.exe");
        }catch (Exception e){
            throw e;
        }
    }

    public boolean isElementPresent(By element){
        try {
            driver.findElement(element);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}




