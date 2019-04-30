package com.tc;

import com.ExtentReports.ExtentTestManager;
import com.base.BaseTest;
import com.po.ScreenDetailPo.ScreenDetailPo;
import com.po.dashboardPO.DashboardPO;
import com.po.loginPo.LoginPo;
import com.po.projectDetailsPO.ProjectDetailsPo;
import com.util.CommonFunctions;

import org.omg.PortableServer.AdapterActivator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class TestCase extends BaseTest {

    private ScreenDetailPo screenDetailPo;
    private CommonFunctions commonFunctions;

    @Test(description = "TC-01 | Verify Page Name | Login Test case", priority = 1)
    public void Testcase1(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify page name");
        ExtentTestManager.getTest().getTest().setName("TC-01:- Verify page name");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.urlVerifyText, "SPECX"), "User not able to verify url.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-02 | Click on login button without enter anything | Login Test case", priority = 2)
    public void Testcase2(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Click on login button without enter anything");
        ExtentTestManager.getTest().getTest().setName("TC-02:- Click on login button without enter anything");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able to click on login button.");
        WebDriverWait driverWait = new WebDriverWait(driver, 30);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(loginPo.emailBlankValidation));
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.emailBlankValidation, "Please enter email."), "User not able to verify email field validation message.");
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.blankPasswordValidation, "Please enter password."), "User not able to verify password field validation message.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-03 | Verify regex > enter email is valid or not | Login Test case", priority = 3)
    public void Testcase3(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify regex > enter email is valid or not");
        ExtentTestManager.getTest().getTest().setName("TC-03:- Verify email field");
        ExtentTestManager.getTest().assignCategory("Login test case");
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
            Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress),"User mot able to clear email text box.");
        }
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-04 | Verify password regex:- Password is valid or not | Login Test case", priority = 4)
    public void Testcase4(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify password regex:- Password is valid or not");
        ExtentTestManager.getTest().getTest().setName("TC-04:- Verify password field");
        ExtentTestManager.getTest().assignCategory("Login test case");
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
            Assert.assertTrue(commonFunctions.clear(loginPo.password),"User not able to clear password text box.");
        }
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-05 | Enter email address and not enter password, click on login button | Login Test case", priority = 5)
    public void Testcase5(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Enter email address and not enter password, click on login button");
        ExtentTestManager.getTest().getTest().setName("TC-05:- Enter email address and not enter password");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.password));
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "test@test.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able to click on login button.");
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.blankPasswordValidation, "Please enter password."), "User not able to verify password validation message.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-06 | Enter password and not enter email address, click on login button | Login Test case", priority = 6)
    public void Testcase6(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Enter password and not enter email address, click on login button");
        ExtentTestManager.getTest().getTest().setName("TC-06:- Enter password and not enter email address");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "123456"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able to click on login button.");
        Assert.assertTrue(commonFunctions.verifyValidation(loginPo.emailBlankValidation, "Please enter email."), "User not able to verify email validation message.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-07 | Enter valid email and wrong password | Login Test case", priority = 7)
    public void Testcase7(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Enter valid email and wrong password, click on login button");
        ExtentTestManager.getTest().getTest().setName("TC-07:- Enter valid email and wrong password");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.clear(loginPo.password), "User not able to clear password field.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "priyam@mailinator.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "12354665"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login),"User not able to click on login button.");
        Assert.assertTrue(commonFunctions.verifyDialogValidation(loginPo.incorrectPassword, "Password is incorrect."), "User not able to verify incorrect password validation message.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-08 | Enter wrong email and valid password | Login Test case", priority = 8)
    public void Testcase8(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Enter wrong email and valid password, click on login button");
        ExtentTestManager.getTest().getTest().setName("TC-08:- Enter wrong email and valid password");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clear(loginPo.emailAddress), "User not able to clear email address field.");
        Assert.assertTrue(commonFunctions.clear(loginPo.password), "User not able to clear password field.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "jay@mailinator.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "123456"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login),"User not able to click on login button.");
        Assert.assertTrue(commonFunctions.verifyDialogValidation(loginPo.incorrectEmail, "This email is not registered."), "User not able to verify incorrect email validation message.");
        ExtentTestManager.endTest();
    }


    @Test(description = "TC-9 | Click on forgot password button and verify forgot password screen and come back login screen. | Login Test case", priority = 9)
    public void Testcase9(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Click on forgot password button and verify forgot password screen and come back login screen.");
        ExtentTestManager.getTest().getTest().setName("TC-09:- Verify forgot password button");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(loginPo.forgotPassword), "User not able to click on forgot password button.");
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.forgotPasswordPageVerify, "Reset Password"), "User not able to verify forgot password screen.");
        Assert.assertTrue(commonFunctions.click(loginPo.returnHome), "user not able to click on return home button.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-10 | Click on sign up button and verify sign up screen and come back login screen. | Login Test case", priority = 10)
    public void Testcase10(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Click on sign up button and verify sign up screen and come back login screen.");
        ExtentTestManager.getTest().getTest().setName("TC-10:- Verify sign up button");
        ExtentTestManager.getTest().assignCategory("Login test case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(loginPo.signUp), "User not able to click on sign up button.");
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.signUpPageVerify, "Get Started"), "User not able to verify sign up screen.");
        Thread.sleep(5000);
        Assert.assertTrue(commonFunctions.click(loginPo.retunLogin), "user not able to click on return login button.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-11 | Enter valid email and valid password | Login Test case", priority = 11)
    public void Testcase11(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Enter valid email and valid password and verify dashboard page.");
        ExtentTestManager.getTest().getTest().setName("TC-11:- Enter valid email and valid password");
        ExtentTestManager.getTest().assignCategory("Login test Case");
        LoginPo loginPo = new LoginPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.inputData(loginPo.emailAddress, "t.one@mailinator.com"), "User not able to enter email address.");
        Assert.assertTrue(commonFunctions.inputData(loginPo.password, "123456"), "User not able to enter password.");
        Assert.assertTrue(commonFunctions.click(loginPo.login), "User not able click on login button.");
        Assert.assertTrue(commonFunctions.verifyPageTitle(loginPo.dashboard, "Project Dashboard"), "User not able to verify dashboard page.");
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-12 | Check there is project is available or not | Dashboard screen", priority = 12)
    public void Testcase12(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Check there is project is available or not");
        ExtentTestManager.getTest().getTest().setName("TC-12:- Check there is project is available or not");
        ExtentTestManager.getTest().assignCategory("Dashboard screen");
        DashboardPO dashboardPO = new DashboardPO(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        boolean b = commonFunctions.verifyProject(dashboardPO.noProject, "No Project Found!");
        if (b) {
            Assert.assertTrue(commonFunctions.click(dashboardPO.newProjectButton), "User not able to click on new project button.");
        } else {
            commonFunctions.verifyProjectList(dashboardPO.projectListTitle, "test");
        }
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-13 | Add project and verify project name field. | Dashboard screen", priority = 13)
    public void Testcase13(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Add project and verify project name field.");
        ExtentTestManager.getTest().getTest().setName("TC-13:- Add project and verify project name field.");
        ExtentTestManager.getTest().assignCategory("Dashboard screen");
        DashboardPO dashboardPO = new DashboardPO(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        ArrayList projectNameData = new ArrayList();
        //Valid project name
        projectNameData.add("test");
        projectNameData.add("123");
        projectNameData.add("12@3^&");
        projectNameData.add("test&*^12343");
        //Invalid project name
        projectNameData.add("d");
        projectNameData.add("testttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetete");
        projectNameData.add("        ");
        System.out.println(projectNameData);
        for (int k = 0; k < projectNameData.size(); k++) {
            System.out.println(k + " " + projectNameData.get(k));
            String projectName = (String) projectNameData.get(k);
            commonFunctions.addProject(dashboardPO.newProjectButton, dashboardPO.newProjectBlog, "Please enter your project's details.", dashboardPO.projectplaceholdername, projectName,dashboardPO.projectListTitle, dashboardPO.saveButton, dashboardPO.addProjectSuccessMessage, dashboardPO.lessCharacterValidation, "Project name must contain at least 3 characters.", dashboardPO.moreCharacterValidation, "Project name must contain al most 30 characters.", dashboardPO.blankValidation, "Please enter project name.");
        }
        driver.navigate().back();
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-14 | Click on edit project button AND click on browser back button with change any thing AND Click on browser forward button | > Edit project screen", priority = 14)
    public void Testcase14(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Click on edit project button AND click on browser back button with change any thing AND Click on browser forward button");
        ExtentTestManager.getTest().getTest().setName("TC-14:- Edit project screen");
        ExtentTestManager.getTest().assignCategory("Edit project screen");
        DashboardPO dashboardPO = new DashboardPO(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.editProjectClick(dashboardPO.editButton));
        driver.navigate().back();
        driver.navigate().forward();
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-15 | Click on save button without change any thing | Dashboard screen > Edit project screen", priority = 15)
    public void Testcase15(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Click on save button without change any thing");
        ExtentTestManager.getTest().getTest().setName("TC-15:- Edit project screen");
        ExtentTestManager.getTest().assignCategory("Edit project screen");
        DashboardPO dashboardPO = new DashboardPO(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.click(dashboardPO.saveButton));
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-16 | Verify project name and edit project name | Dashboard screen > Edit project screen", priority = 16)
    public void Testcase16(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify project name and edit project name");
        ExtentTestManager.getTest().getTest().setName("TC-16:- Edit project screen");
        ExtentTestManager.getTest().assignCategory("Edit project screen");
        DashboardPO dashboardPO = new DashboardPO(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        ArrayList projectNames = new ArrayList();
        //Valid project name
        projectNames.add("xyz");
        projectNames.add("321");
        projectNames.add("dfs");
        projectNames.add("xyz&*^12343");
        //Invalid project name
        projectNames.add("x");
        //  projectNames.add("testttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetete");
        projectNames.add("        ");
        System.out.println(projectNames);
        for (int l = 0; l < projectNames.size(); l++) {
            System.out.println(l + " " + projectNames.get(l));
            String projectName = (String) projectNames.get(l);
            driver.navigate().refresh();
            commonFunctions.addProject(dashboardPO.editButton, dashboardPO.newProjectBlog, "Please enter your project's details.", dashboardPO.projectplaceholdername, projectName,dashboardPO.projectListTitle, dashboardPO.saveButton, dashboardPO.editProjectSuccessMessage, dashboardPO.lessCharacterValidation, "Project name must contain at least 3 characters.", dashboardPO.moreCharacterValidation, "Project name must contain at most 100 characters.", dashboardPO.blankValidation, "Please enter project name.");
        }
        driver.navigate().back();
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-17 | Verify project name and Delete project | Dashboard screen > Delete project", priority = 17)
    public void Testcase17(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify project name and Delete project");
        ExtentTestManager.getTest().getTest().setName("TC-17:- Delete project");
        ExtentTestManager.getTest().assignCategory("Delete project");
        DashboardPO dashboardPO = new DashboardPO(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.deleteProject(dashboardPO.noProject,dashboardPO.projectListTitle,"test",dashboardPO.deleteProject,dashboardPO.deletePopup,"Are you sure want to delete this project?",dashboardPO.deletePopupShadow,dashboardPO.deletePopupCancel,dashboardPO.deletePopupOkay,dashboardPO.deleteMessage,"Project is deleted successfully."));
        ExtentTestManager.endTest();
    }


    @Test(description = "TC-18 | Click on any one project | Dashboard screen > Project", priority = 18)
    public void Testcase18(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify there is project available or not, if project is available there click on any one project. ");
        ExtentTestManager.getTest().getTest().setName("TC-18:- Click on any one project");
        ExtentTestManager.getTest().assignCategory("Project");
        DashboardPO dashboardPO = new DashboardPO(driver);
        ProjectDetailsPo projectDetailsPo = new ProjectDetailsPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.projectClick(dashboardPO.noProject, dashboardPO.projectListClick, projectDetailsPo.projectName));
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-19 | Verify there is any screens or folder are available or not | Project details screen", priority = 19)
    public void Testcase19(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Verify there is any folder or screens are available or not.");
        ExtentTestManager.getTest().getTest().setName("TC-19:- Verify there is any screens or folder are available or not");
        ExtentTestManager.getTest().assignCategory("Project details");
        ProjectDetailsPo projectDetailsPo = new ProjectDetailsPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.verifyFolderScreen(projectDetailsPo.noFolderScreens, "Folders or Screens Not Found!"));
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-20 | Click on new folder button and verify popup is looking or not | Project details screen", priority = 20)
    public void Testcase20(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Click on new folder button and verify new folder popup.");
        ExtentTestManager.getTest().getTest().setName("TC-20:- Click on new folder button and verify popup is looking or not");
        ExtentTestManager.getTest().assignCategory("Project details");
        ProjectDetailsPo projectDetailsPo = new ProjectDetailsPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.newFolderNewScreen(projectDetailsPo.newFolderNewScreen, projectDetailsPo.newFolderPopup));
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-21 | Click on cancel button in new folder popup and check popup is open or close. | Project details screen", priority = 21)
    public void Testcase21(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"If new folder popup is not open then first open new folder popup and Click on cancel button in new folder popup and check popup is open or close.");
        ExtentTestManager.getTest().getTest().setName("TC-21:- Click on cancel button in new folder popup and check popup is open or close.");
        ExtentTestManager.getTest().assignCategory("Project details > Add folder");
        ProjectDetailsPo projectDetailsPo = new ProjectDetailsPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.clickOnCancelButton(projectDetailsPo.newFolderPopup,projectDetailsPo.newFolderNewScreen,projectDetailsPo.newFolderPopupCancelCreate,projectDetailsPo.newFolderPopup));
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-22 | Add folder and verify folder name. | Project details screen > Add folder", priority = 22)
    public void Testcase22(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Add folder and verify folder name.");
        ExtentTestManager.getTest().getTest().setName("TC-22:- Add folder and verify folder name.");
        ExtentTestManager.getTest().assignCategory("Project details > Add folder");
        ProjectDetailsPo projectDetailsPo = new ProjectDetailsPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        ArrayList folderNameData = new ArrayList();
        //Valid project name
        folderNameData.add("test");
        folderNameData.add("123");
        folderNameData.add("12@3^&");
        folderNameData.add("test&*^12343");
        //Invalid project name
        folderNameData.add("d");
        folderNameData.add("testttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetetetestttetttsttetettetetete");
        folderNameData.add("        ");
        System.out.println(folderNameData);
        for (int fn = 0; fn < folderNameData.size(); fn++) {
            System.out.println(fn + " " + folderNameData.get(fn));
            String folderName = (String) folderNameData.get(fn);
            commonFunctions.addFolder(projectDetailsPo.newFolderPopup, projectDetailsPo.newFolderNewScreen, projectDetailsPo.folderName,folderName, projectDetailsPo.verifyFolderName,projectDetailsPo.newFolderPopupCancelCreate,projectDetailsPo.successMessageFolderName,projectDetailsPo.lessCharacterFolderName,"Name must contain at least 3 characters.",projectDetailsPo.moreCharactersFolderName,"Name must contain at most 30 characters.",projectDetailsPo.noOrBlankFolderName,"Please enter name.");
        }
        Assert.assertTrue(commonFunctions.click(projectDetailsPo.newFolderCancelButton));
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-23 | Add screen | Project details screen > Add screen", priority = 23)
    public void Testcase23(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"Add screens.");
        ExtentTestManager.getTest().getTest().setName("TC-23:- Add screens.");
        ExtentTestManager.getTest().assignCategory("Project details screen > Add screen");
        ProjectDetailsPo projectDetailsPo = new ProjectDetailsPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        Assert.assertTrue(commonFunctions.addScreen(projectDetailsPo.screenAdd),"User not able upload screen.");
        commonFunctions.verifyDialogValidation(projectDetailsPo.screenDialog,"Screen is created successfully.");
        ExtentTestManager.endTest();
    }


    @Test(description = "TC-24 | Click On New Requirement Button | Login Test case", priority = 24)
    public void Testcase24(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(),"Click On New Requirement Button");
        ExtentTestManager.getTest().getTest().setName("TC-24:- Click On New Requirement Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        Assert.assertTrue(commonFunctions.allScreens(screenDetailPo.allScreens), "User not able to open screen");
        Assert.assertTrue(commonFunctions.click(screenDetailPo.closeButton), "User not able click on Button");
        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
        } else {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
        }
        ExtentTestManager.endTest();
    }

    @Test(testName = "TC-25 | Click On Edit Requirement Button | Screen Test case", priority = 25)
    public void Testcase25(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Click On Edit Requirement Button");
        ExtentTestManager.getTest().getTest().setName("TC-25:- Click On Edit Requirement Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
        } else {
            commonFunctions.clickOnEditButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.",screenDetailPo.editButton,screenDetailPo.listOfRequirements);
        }
        ExtentTestManager.endTest();
    }
    @Test(testName = "TC-26 | Click On Delete Requirement Button | Screen Test case", priority = 26)
    public void Testcase26(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Click On Delete Requirement Button");
        ExtentTestManager.getTest().getTest().setName("TC-26:- Click On Delete Requirement Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
            commonFunctions.clickOnDeleteButton(screenDetailPo.deleteButton,screenDetailPo.listOfRequirements,screenDetailPo.deleteDialogText,"Are you sure want to delete this requirement?",screenDetailPo.clickOnOkButton,screenDetailPo.clickOnCancelButton,screenDetailPo.requirementDeletedSuccessfully,"Requirement deleted successfully",screenDetailPo.closeButton);
        } else {
            commonFunctions.clickOnDeleteButton(screenDetailPo.deleteButton,screenDetailPo.listOfRequirements,screenDetailPo.deleteDialogText,"Are you sure want to delete this requirement?",screenDetailPo.clickOnOkButton,screenDetailPo.clickOnCancelButton,screenDetailPo.requirementDeletedSuccessfully,"Requirement deleted successfully",screenDetailPo.closeButton);
        }
        ExtentTestManager.endTest();
    }

    @Test(description = "TC-27| Click On Browse Button | Login Test case", priority = 27)
    public void Testcase27(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(),"Click On Browse Button");
        ExtentTestManager.getTest().getTest().setName("TC-27:- Click On Browse Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.imageUpload(screenDetailPo.image);
        ExtentTestManager.endTest();

    }

    @Test(testName = "TC-28 | Click On Comment Button | Screen Test case", priority = 28)
    public void Testcase28(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Click On Comment Button");
        ExtentTestManager.getTest().getTest().setName("TC-28:- Click On Comment Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        boolean isPresent = commonFunctions.noReqLabelisPresent(screenDetailPo.noRequirementFoundLabel, "No requirements found for this screen!");

        if (isPresent) {
            commonFunctions.clickOnNewReqButton(screenDetailPo.newReuqirementBtn, screenDetailPo.requirementTextBox, screenDetailPo.saveButton, screenDetailPo.cancelButton, screenDetailPo.successfullyAddedDialog, screenDetailPo.lessThenFiveChar, "Requirement must contain at least 5 characters.", screenDetailPo.pleaseEnterRequirement, "Please enter requirement.");
            commonFunctions.clickOnCommentButton(screenDetailPo.commentButton,screenDetailPo.backButton,screenDetailPo.listOfRequirements,screenDetailPo.noCommentLabel,"No comments found for this requirement!",screenDetailPo.commentTextBox,screenDetailPo.sendButton,screenDetailPo.commentRequirement,screenDetailPo.commentsList,screenDetailPo.pleaseEnterComment,screenDetailPo.pleaseEnterLess2Char,"Please enter comment.","Comment must contain at least 2 characters.",screenDetailPo.commentAddedSuccessfullyDialog,"Comment is created successfully",screenDetailPo.closeButton);
        } else {
            commonFunctions.clickOnCommentButton(screenDetailPo.commentButton,screenDetailPo.backButton,screenDetailPo.listOfRequirements,screenDetailPo.noCommentLabel,"No comments found for this requirement!",screenDetailPo.commentTextBox,screenDetailPo.sendButton,screenDetailPo.commentRequirement,screenDetailPo.commentsList,screenDetailPo.pleaseEnterComment,screenDetailPo.pleaseEnterLess2Char,"Please enter comment.","Comment must contain at least 2 characters.",screenDetailPo.commentAddedSuccessfullyDialog,"Comment is created successfully",screenDetailPo.closeButton);
        }
        ExtentTestManager.endTest();
    }

    @Test(testName = "TC-29 | Click On Comment Edit Button | Screen Test case", priority = 29)
    public void Testcase29(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Click On Comment Edit Button");
        ExtentTestManager.getTest().getTest().setName("TC-29:- Click On Comment Edit Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

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
        ExtentTestManager.endTest();
    }

    @Test(testName = "TC-30 | Click On Comment Delete Button | Screen Test case", priority = 30)
    public void Testcase30(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Click On Comment Delete Button");
        ExtentTestManager.getTest().getTest().setName("TC-30:- Click On Comment Delete Button");
        ExtentTestManager.getTest().assignCategory("Screen details");

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
        ExtentTestManager.endTest();
    }

    @Test(testName = "TC-31 | Send Invitation | Send Invitations Test case", priority = 31)
    public void Testcase31(Method method) throws Exception {


        ExtentTestManager.startTest(method.getName(),"Send Invitation With Register or not Register.");
        ExtentTestManager.getTest().getTest().setName("TC-31:- Send Invitation With Register or not Register.");
        ExtentTestManager.getTest().assignCategory("Send Invitations");

        ScreenDetailPo screenDetailPo = new ScreenDetailPo(driver);
        CommonFunctions commonFunctions = new CommonFunctions(driver);

        commonFunctions.click(screenDetailPo.settingIcon);
        commonFunctions.sendInvitation(screenDetailPo.emailTextBox,screenDetailPo.sendInvitationButton,screenDetailPo.pleaseEnterEmailMessage,"Email is invalid.",screenDetailPo.emailIsInvalidMessage,"Please enter email.",screenDetailPo.sendInvitationSuccessDialog,"Project invitation link is sent successfully",screenDetailPo.closeButton);
        ExtentTestManager.endTest();
    }
}