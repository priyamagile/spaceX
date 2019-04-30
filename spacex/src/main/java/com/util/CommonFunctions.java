package com.util;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.EclipseInterface;

import javax.swing.*;
import java.util.List;
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

    //Verify page name method
    public boolean verifyPageTitle(By element, String title) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            if (webElement.getText().equals(title)) {
                System.out.println("Login page title:-Page title verify successfully.");
                return true;
            } else {
                System.out.println("Login page title:-Page title not verify successfully.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Verify validation message method
    public boolean verifyValidation(By element, String validation) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            if (webElement.getText().equals(validation)) {
                System.out.println("Validation message verify successfully.");
                return true;
            } else {
                System.out.println("Validation message not verify successfully.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
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

    // inputData method
    public boolean inputData(By element, String testData) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.sendKeys(testData);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    // Verify regex > email is valid or not method
    public boolean verifyEmailRegex(By element, String emailData, By element2, String validation, By element3) throws Exception {
        try {
            String regex = "^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(emailData);
            boolean isPatten = matcher.matches();
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.sendKeys(emailData);
            WebElement webElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element3));
            webElement1.click();
            if (isPatten == true) {
                List<WebElement> elements = driver.findElements(element2);
                boolean isPresent = elements.size() > 0;
                if (isPresent) {
                    System.out.println("System not accept email address.");
                    WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element2));
                    if (element1.getText().equals(validation)) {
                        System.out.println("Email :- Email validation message verify successfully.");
                    } else {
                        System.out.println("Email:- Email validation message not verify successfully.");
                    }
                    return false;
                } else {
                    System.out.println("Enter email is correct.");
                    return true;
                }
            } else {
                System.out.println("Email pattern not verify with regex, Please enter valid email.");
                List<WebElement> elements = driver.findElements(element2);
                boolean isPresent = elements.size() > 0;
                if (isPresent) {
                    WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element2));
                    if (element1.getText().equals(validation)) {
                        System.out.println("Email:- Email validation message verify successfully.");
                    } else {
                        System.out.println("Email:- Email validation message not verify successfully.");
                    }
                    return true;
                } else {
                    System.out.println("Validation message not looking and system accept email.");
                    return false;
                }
            }
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

    //Verify Password regex
    public boolean verifyPasswordRegex(By element, String passwordData, By element1, By element2, String validationMessage, By element3, String validationMessage2, By element4, String validationMessage3) throws Exception {
        try {
            String regex = "^(?=.*[0-9a-zA-Z@#$%^&+=])(?=\\S+$).{6,16}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(passwordData);
            boolean isPassword = matcher.matches();
            String blankpasswordRegex = "^(\\s+$)$";
            Pattern pattern1 = Pattern.compile(blankpasswordRegex);
            Matcher matcher1 = pattern1.matcher(passwordData);
            boolean isPasswordBlank = matcher1.matches();

            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.sendKeys(passwordData);
            WebElement webElement1 = wait.until(ExpectedConditions.elementToBeClickable(element1));
            webElement1.click();
            if (isPassword) {
                System.out.println("You enter valid password.");
                return true;
            } else if (passwordData.length() < 6) {
                System.out.println("Password:- Less than 6 characters.");
                WebElement webElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(element2));
                if (webElement2.getText().equals(validationMessage)) {
                    System.out.println("Less number password validation:- Validation message is correct.");
                    return true;
                } else {
                    System.out.println("Less number password validation:- Validation message is wrong.");
                    return false;
                }
            } else if (passwordData.length() > 16) {
                System.out.println("Password:- More than 16 characters.");
                WebElement webElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(element3));
                if (webElement3.getText().equals(validationMessage2)) {
                    System.out.println("More number password validation:- Validation message is correct.");
                    return true;
                } else {
                    System.out.println("More number password validation:- Validation message is wrong.");
                    return false;
                }
            } else if (isPasswordBlank) {
                System.out.println("Password:- password should not be blank space.");
                WebElement webElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(element4));
                if (webElement4.getText().equals(validationMessage3)) {
                    System.out.println("Blank password validation:- Validation message is correct.");
                    return true;
                } else {
                    System.out.println("Blank password validation:- Validation message is wrong.");
                    return false;
                }
            } else {
                System.out.println("Password:- password field not accept blank space.");
                WebElement webElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(element4));
                if (webElement4.getText().equals(validationMessage3)) {
                    System.out.println("Blank password validation:- Validation message is correct.");
                    return true;
                } else {
                    System.out.println("Blank password validation:- Validation message is wrong.");
                    return false;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Verify dialog validation message method
    public boolean verifyDialogValidation(By element, String validation) throws Exception {
        try {
            List<WebElement> webElements = driver.findElements(element);
            boolean isDialogPresents = webElements.size() > 0;
            if (isDialogPresents) {
                String text = webElements.get(0).getText();
                System.out.println(text);
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

    //Add project method.
    public boolean addProject(By element, By element2, String addProjectTitle, By element3, String textData, By verifyNameElement, By element4, By dialogElement, By element5, String lessValidation, By element6, String moreValidation, By element7, String blankValidation) throws Exception {
        try {
            List<WebElement> webElement2 = driver.findElements(element2);
            boolean b = webElement2.size() > 0;
            if (b) {
                if (webElement2.get(0).getText().equals(addProjectTitle)) {
                    System.out.println("Add/Edit project title:- Add/Edit project title verify successfully.");
                } else {
                    System.out.println("Add/Edit project title:- Add/Edit project title not verify.");
                }
            } else {
                System.out.println("Add/Edit project title :- element not found.");
                WebElement webElement1 = wait.until(ExpectedConditions.elementToBeClickable(element));
                webElement1.click();
            }
            String projectNameRegex = "^(?=.*[0-9a-zA-Z@#$%^&+=])(?=\\S).{3,30}$";
            Pattern projectPatten = Pattern.compile(projectNameRegex);
            Matcher projectMatcher = projectPatten.matcher(textData);
            boolean isProject = projectMatcher.matches();
            String blankProjectNameRegex = "^(\\s+$)$";
            Pattern projectPatten1 = Pattern.compile(blankProjectNameRegex);
            Matcher projectMatcher1 = projectPatten1.matcher(textData);
            boolean isProjectBlank = projectMatcher1.matches();
            WebElement webElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(element3));
            webElement3.clear();
            webElement3.sendKeys(textData);
            WebElement webElement4 = wait.until(ExpectedConditions.elementToBeClickable(element4));
            webElement4.click();
            if (isProject) {
                System.out.println("You enter valid project name.");
                verifyDialogValidation(dialogElement, "Project is created successfully.");
                verifyProjectList(verifyNameElement, textData);
                return true;
            } else if (textData.length() < 3) {
                System.out.println("Project Name:- Project name less thane 3 characters.");
                WebElement webElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(element5));
                if (webElement5.getText().equals(lessValidation)) {
                    System.out.println("Project Name:- Less characters validation message verify successfully.");
                    webElement3.clear();
                    return true;
                } else {
                    System.out.println("Project name:- Less characters validation message not verify.");
                    webElement3.clear();
                    return false;
                }
            } else if (textData.length() > 30) {
                System.out.println("Project Name:- Project name more thane 30 characters.");
                WebElement webElement6 = wait.until(ExpectedConditions.visibilityOfElementLocated(element6));
                if (webElement6.getText().equals(moreValidation)) {
                    System.out.println("Project Name:- More characters validation message verify successfully.");
                    webElement3.clear();
                    return true;
                } else {
                    System.out.println("Project name:- More characters validation message not verify.");
                    webElement3.clear();
                    return false;
                }
            } else if (isProjectBlank) {
                System.out.println("Project Name:- Project name should not be with blank space.");
                WebElement webElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(element7));
                if (webElement7.getText().equals(blankValidation)) {
                    System.out.println("Blank project name validation:- Validation message is correct.");
                    webElement3.clear();
                    return true;
                } else {
                    System.out.println("Blank project name validation:- Validation message is wrong.");
                    webElement3.clear();
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    //Verify project ia available or not method.
    public boolean verifyProject(By element, String title) throws Exception {
        try {
            List<WebElement> elements = driver.findElements(element);
            boolean b = elements.size() > 0;
            if (b) {
                if (elements.get(0).getText().equals(title)) {
                    System.out.println("Project:- No project found title verify.");
                    return true;
                } else {
                    System.out.println("Project:- No project found title not verify.");
                    return false;
                }
            } else {
                System.out.println("Project title element not found.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Verify project list method.
    public boolean verifyProjectList(By element, String projectTitle) throws Exception {
        try {
            List<WebElement> elements = driver.findElements(element);
            int size = elements.size();
            String str = elements.get(size - 1).getText();
            String str2 = elements.get(0).getText();
            System.out.println(str);
            if (str.equals(projectTitle)) {
                System.out.println("Project list name:- Project name verify successfully.");
                return true;
            } else if (str2.equals(projectTitle)) {
                System.out.println("Project list name:- Project name verify Successfully.");
                return true;
            } else {
                System.out.println("Project list name:- Project name not verify.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Edit project button method.
    public boolean editProjectClick(By element) throws Exception {
        try {
            List<WebElement> webElements = driver.findElements(element);
            webElements.get(0).click();
            System.out.println("Project edit button click successfully.");
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    //Delete project method.
    public boolean deleteProject(By element, By element3, String projectName, By element0, By element1, String deletePopupTitle, By shadow, By element2, By element4, By element5, String deletedSuccessMessage) throws Exception {
        try {
            //Project is available or not.
            Thread.sleep(2000);
            List<WebElement> webElements = driver.findElements(element);
            boolean b = webElements.size() > 0;
            if (b) {
                System.out.println("No project found!!");
                return false;
            } else {
                System.out.println("Project list available");
                //Get list of projects.
                List<WebElement> elements = driver.findElements(element3);
                String str = elements.get(0).getText();
                //Click on delete button in any one project out of list of projects.
                List<WebElement> webElements1 = driver.findElements(element0);
                webElements1.get(0).click();
                //Verify delete popup.
                WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
                if (webElement.getText().equals(deletePopupTitle)) {
                    System.out.println("Delete popup title verify successfully.");
                    //Click on out side of delete popup.
                    WebElement webElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(shadow));
                    webElement1.click();
                    if (webElement.getText().equals(deletePopupTitle)) {
                        System.out.println("Outside popup click and popup not close.");
                        //Click on cancel button.
                        WebElement webElement2 = wait.until(ExpectedConditions.elementToBeClickable(element2));
                        webElement2.click();
                        driver.navigate().refresh();
                        System.out.println("Click on cancel button.");
                        //Verify delete popup is open or close.
                        List<WebElement> webElements2 = driver.findElements(element1);
                        boolean p = webElements2.size() > 0;
                        if (p) {
                            System.out.println("After click on cancel button delete popup not close.");
                        } else {
                            System.out.println("After click on cancel button delete popup close.");
                            //Verify project is delete or not not after click on cancel button.
                            if (str.equals(projectName)) {
                                System.out.println("Project not deleted and project name verify.");
                            } else {
                                System.out.println("Project not deleted and project name not verify.");
                            }
                        }
                        //Again click on delete button in any one project.
                        List<WebElement> webElements3 = driver.findElements(element0);
                        webElements3.get(0).click();
                        WebElement webElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
                        if (webElement3.getText().equals(deletePopupTitle)) {
                            System.out.println("Delete popup title verify successfully.");
                            //Click on okay button
                            WebElement webElement4 = wait.until(ExpectedConditions.elementToBeClickable(element4));
                            webElement4.click();
                            //Verify success dialog.
                            verifyDialogValidation(element5, deletedSuccessMessage);
                        } else {
                            System.out.println("Delete popup title not verify successfully.");
                        }
                    } else {
                        System.out.println("Outside popup click and popup is close.");
                    }
                } else {
                    System.out.println("Delete popup title not verify.");
                }
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Click on project any one project method.
    public boolean projectClick(By element, By element0, By element1) throws Exception {
        try {
            List<WebElement> webElements = driver.findElements(element);
            boolean x = webElements.size() > 0;
            if (x) {
                System.out.println("No project list found..!!");
                return false;
            } else {
                System.out.println("Project list found.!!");
                List<WebElement> webElements1 = driver.findElements(element0);
                String text = webElements1.get(0).getText();
                webElements1.get(0).click();
                WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
                String text1 = webElement.getText();
                if (text1.equals(text)) {
                    System.out.println("Project details:- Project title verify successfully.");
                    return true;
                } else {
                    System.out.println("Project details:- Project title not verify.");
                    return false;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Verify folder or screens available or not.
    public boolean verifyFolderScreen(By element, String title) throws Exception {
        try {
            List<WebElement> elements = driver.findElements(element);
            boolean b = elements.size() > 0;
            if (b) {
                if (elements.get(0).getText().equals(title)) {
                    System.out.println("Project details:- Folders or Screens Not Found! title verify successfully.");
                    return true;
                } else {
                    System.out.println("Project details:- Folders or Screens Not Found! title not verify.");
                    return false;
                }
            } else {
                System.out.println("Folder or Screens title element not found.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Click on new folder button and verify popup is available or not method.
    public boolean newFolderNewScreen(By element, By element0) throws Exception {
        try {
            List<WebElement> webElements = driver.findElements(element);
            webElements.get(0).click();
            System.out.println("Click on new folder button.");
            List<WebElement> webElements1 = driver.findElements(element0);
            if (webElements1.size() > 0) {
                System.out.println("New folder popup looking successfully.");
                return true;
            } else {
                System.out.println("New folder popup not looking.");
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //Click on cancel button popup and check popup is open or not.
    public boolean clickOnCancelButton (By element, By element0, By element1,By element2) throws Exception {
        try {
            List<WebElement> webElements = driver.findElements(element);
            if (webElements.size() > 0) {
                System.out.println("New folder popup looking successfully.");
            } else {
                System.out.println("New folder popup not looking.");
                List<WebElement> webElements1 = driver.findElements(element0);
                webElements1.get(0).click();
            }
            List<WebElement> elements = driver.findElements(element1);
            elements.get(0).click();
            List<WebElement> webElements1 = driver.findElements(element2);
            if (webElements1.size() > 0) {
                System.out.println("Popup is visible");
                return false;
            }else {
                System.out.println("Popup is not visible");
                return true;
            }
        }catch (Exception e){
            throw e;
        }
    }

    // Add folder method
    public boolean addFolder(By element, By element2, By element3, String textData, By verifyFolderName, By element4, By dialogElement, By element5, String lessValidation, By element6, String moreValidation, By element7, String blankValidation) throws Exception {
        try {
            List<WebElement> webElement2 = driver.findElements(element);
            boolean b = webElement2.size() > 0;
            if (b) {
                System.out.println("New folder popup is looking.");
            } else {
                System.out.println("New folder popup is not looking.");
                List<WebElement> webElements1 = driver.findElements(element2);
                webElements1.get(0).click();
            }
            String projectNameRegex = "^(?=.*[0-9a-zA-Z@#$%^&+=])(?=\\S).{3,30}$";
            Pattern projectPatten = Pattern.compile(projectNameRegex);
            Matcher projectMatcher = projectPatten.matcher(textData);
            boolean isProject = projectMatcher.matches();
            String blankProjectNameRegex = "^(\\s+$)$";
            Pattern projectPatten1 = Pattern.compile(blankProjectNameRegex);
            Matcher projectMatcher1 = projectPatten1.matcher(textData);
            boolean isProjectBlank = projectMatcher1.matches();
            WebElement webElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(element3));
            webElement3.clear();
            webElement3.sendKeys(textData);
            List<WebElement> webElements = driver.findElements(element4);
            webElements.get(1).click();
            if (isProject) {
                System.out.println("You enter valid folder name.");
                verifyDialogValidation(dialogElement, "Folder is created successfully.");
                verifyProjectList(verifyFolderName, textData);
                return true;
            } else if (textData.length() < 3) {
                System.out.println("Folder Name:- Folder name less thane 3 characters.");
                WebElement webElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(element5));
                if (webElement5.getText().equals(lessValidation)) {
                    System.out.println("Folder Name:- Less characters validation message verify successfully.");
                    webElement3.clear();
                    return true;
                } else {
                    System.out.println("Folder name:- Less characters validation message not verify.");
                    webElement3.clear();
                    return false;
                }
            } else if (textData.length() > 30) {
                System.out.println("Folder Name:- Folder name more thane 30 characters.");
                WebElement webElement6 = wait.until(ExpectedConditions.visibilityOfElementLocated(element6));
                if (webElement6.getText().equals(moreValidation)) {
                    System.out.println("Folder Name:- More characters validation message verify successfully.");
                    webElement3.clear();
                    return true;
                } else {
                    System.out.println("Folder name:- More characters validation message not verify.");
                    webElement3.clear();
                    return false;
                }
            } else if (isProjectBlank) {
                System.out.println("Folder Name:- Folder name should not be with blank space.");
                WebElement webElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(element7));
                if (webElement7.getText().equals(blankValidation)) {
                    System.out.println("Blank folder name validation:- Validation message is correct.");
                    webElement3.clear();
                    return true;
                } else {
                    System.out.println("Blank folder name validation:- Validation message is wrong.");
                    webElement3.clear();
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    //Screen add
    public boolean addScreen(By element) throws Exception {
        try {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            webElement.click();
            Thread.sleep(5000);
            Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIT\\image1.exe");
        }catch (Exception e){
            throw e;
        }
        return true;
    }
}
