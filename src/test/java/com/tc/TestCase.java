package com.tc;

import com.base.BaseTest;
import com.po.CreateOrderPO.CreateOrderPO;
import com.po.Leftnavigationpo.LeftNavigationPO;
import com.po.Loginpo.LoginPO;
import com.util.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


// This class extends with basetest class (inheritance)
public class TestCase extends BaseTest {

    @Test(description = "TC-1 : Login page verify : Login Test Case")
    // Here we create one method name "Testcase1"
    public void Testcase1() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);
        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Using Assert method we find element and enter testdata and test testcases.
        Assert.assertTrue(functions.titleVerify(loginPO.loginpagetitle, "Log in to get started"), "Login page not verify.");

    }

    @Test(description = "TC-2 : Without fill anything click on login button : Login Test Case")
    public void Testcase2() throws Exception {

        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);

        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Created precondition using Testcase1 method.
        Testcase1();
        Assert.assertTrue(functions.click(loginPO.loginButton), "User not able to click on login button.");
        Thread.sleep(5000);
    }

    @Test(description = "TC-3 : Not enter anything in password field : Login Test Case")
    public void Testcase3() throws Exception {

        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);

        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // User name field
        Assert.assertTrue(functions.inputData(loginPO.userName, "0719"), "User not able to enter username.");
        // Login button
        Assert.assertTrue(functions.click(loginPO.loginButton), "User not able to click on login button.");
        // Password validation message
        Assert.assertTrue(functions.validationVerify(loginPO.passwordValidation, "Password is required."), "User not able to see any validation message");
        //Clear Username field
        Assert.assertTrue(functions.clear(loginPO.userName), "User not able to clear username.");

    }

    @Test(description = "TC-4 : Not enter anything in username field : Login Test Case")
    public void Testcase4() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);

        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        //password field
        Assert.assertTrue(functions.inputData(loginPO.password, "Ab123456"), "User not able to enter password");
        // Login button
        Assert.assertTrue(functions.click(loginPO.loginButton), "User not able to click on login button.");
        // Username validation message
        Assert.assertTrue(functions.validationVerify(loginPO.userNameValidation, "User ID is required."), "User not able to see any validation message");
        // Clear password field
        Assert.assertTrue(functions.clear(loginPO.password), "User not able to clear password field.");

    }

    @Test(description = "TC-5 : Enter invalid username : Login Test Case")
    public void Testcase5() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);

        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Invalid Username
        Assert.assertTrue(functions.inputData(loginPO.userName, "1779"), "User not able to enter username.");
        //password field
        Assert.assertTrue(functions.inputData(loginPO.password, "Ab123456"), "User not able to enter password");
        // Login button
        Assert.assertTrue(functions.click(loginPO.loginButton), "User not able to click on login button.");
        // invalid username and password validation message
        Assert.assertTrue(functions.validationVerify(loginPO.invalidUserValidation, "Invalid user id or password."), "User not able to see any validation message");

    }

    @Test(description = "TC-6 : Enter invalid password : Login Test Case")
    public void Testcase6() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);

        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Username
        Assert.assertTrue(functions.inputData(loginPO.userName, "0719"), "User not able to enter username.");
        //Invalid password
        Assert.assertTrue(functions.inputData(loginPO.password, "123456"), "User not able to enter password");
        // Login button
        Assert.assertTrue(functions.click(loginPO.loginButton), "User not able to click on login button.");
        // invalid username and password validation message
        Assert.assertTrue(functions.validationVerify(loginPO.invalidUserValidation, "Invalid user id or password."), "User not able to see any validation message");

    }

    @Test(description = "TC-7 : Click on forgot password link : Login Test Case")
    public void Testcase7() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);

        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        //Click on forgot password link
        Assert.assertTrue(functions.click(loginPO.forgotPassword), "User not able to click on forgot password link");
        Thread.sleep(5000);

        // Click on already have account link
        Assert.assertTrue(functions.click(loginPO.alreadyHaveAccount), "User not able to click on already have account link");
        Thread.sleep(5000);
    }

    // We use test annotation, in test annotation we write all test cases.
    // here we use one more annotation name "description" because just we need to define description regarding test case.
    @Test(description = "TC-8:Enter valid username and password : Login Test Case")
    // Here we create one method name "Testcase1"
    // Here we throw exception because In "inputData" method have exceptions.
    public void Testcase8() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);
        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Using Assert method we find element and enter testdata and test testcases.
        //User name
        Assert.assertTrue(functions.inputData(loginPO.userName, "0719"), "User not able to enter User Name");
        //Password
        Assert.assertTrue(functions.inputData(loginPO.password, "Ab123456"), "User not able to enter Password");
        //Login button
        Assert.assertTrue(functions.click(loginPO.loginButton), "User not able to login");

        Thread.sleep(5000);
        // Get all current active windowId.
        Set<String> set = driver.getWindowHandles();
        // Print how many windows opened.
        System.out.println("Opened window size" + set.size());
        //Capture windowId from set collection
        Iterator<String> it = set.iterator();
        //Parent window Id.
        String parentId = it.next();
        //child window Id.
        String childId = it.next();
        // Pass driver control to child window.
        driver.switchTo().window(childId);
        // Close child window.
        driver.close();
        // Pass driver control to parent window.
        driver.switchTo().window(parentId);

    }

    @Test(description = "TC-9: Verify Home screen : Login Test Case")
    public void Testcase9() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);
        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Home page title or company name
        Assert.assertTrue(functions.titleVerify(loginPO.homePageVerify, "Melbourne Furniture Works Pvt. Ltd.sb"), "Home page not verify/ Company name looking different.");

    }

    // min max limit verification
    /*@Test
    public void Testcase10() throws Exception {
        // Created object of "LoginPO" constructor with parameters
        LoginPO loginPO = new LoginPO(driver);
        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        Assert.assertTrue(functions.minMaxLimit(loginPO.userName,"t","",loginPO.userNameValidation),"User not able to enter username.");
    }*/

    // Create order
    @Test(description = "TC-11 : Open create order page : Create Order")
    public void Testcase90() throws Exception {
        // Create object of "LeftNavigationPO" constructor with parameters
        LeftNavigationPO leftNavigationPO = new LeftNavigationPO(driver);
        // Create object of "CreateorderPO" constructor with parameters
        CreateOrderPO createOrderPO = new CreateOrderPO(driver);
        // Created object of "CommonFunctions" constructor with parameters
        CommonFunctions functions = new CommonFunctions(driver);

        // Open order management dropdown.
        Assert.assertTrue(functions.click(leftNavigationPO.orderManagment),"User not able to open order management dropdown.");
        // Open create order page.
        Assert.assertTrue(functions.click(leftNavigationPO.createOrderPage),"User not able to click on create order page.");
        Thread.sleep(5000);
        // Select value from dropdown.
        Assert.assertTrue(functions.dropDown(createOrderPO.originDropDown,"654654"),"User not able to select origin dropdown.");
        Thread.sleep(5000);
        // Check billing to dropdown is selected or not, if dropdown not selected then enter value in dropdown.
        Assert.assertTrue(functions.billingto(createOrderPO.billingToDropDown,"aaa1"),"User not able to select billing to dropdown.");
        Assert.assertTrue(functions.order(createOrderPO.orderNo,"1008"),"User not able to enter order#.");
        Thread.sleep(5000);

    }
}
