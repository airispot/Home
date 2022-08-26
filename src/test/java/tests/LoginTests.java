package tests;


import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {



    @Test (groups = {"Smoke","Regression"}, invocationCount = 3, threadPoolSize = 3)

    public void positiveLoginTests() {

        loginPage.setUserNameInputValue("standard_user");
        loginPage.setPasswordInputValue("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(productPage.isHeaderContainerDisplayed());

    }

    @Test(dataProvider = "login-test-data", groups = {"Negative"} )
    public void negativeTestWithoutLogin() {

        loginPage.setUserNameInputValue("");
        loginPage.setPasswordInputValue("secret_sauce");
        loginPage.clickLoginButton();
        String expectedErrorMessageText = "Epic sadface: Username is required";
        Assert.assertTrue(loginPage.isErrorMassageContainerDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessageText);

    }

    @Test(dataProvider = "login-test-data", groups = {"Negative"} )
    public void negativeTestWithoutLoginAndPass() {
        loginPage.setUserNameInputValue("");
        loginPage.setPasswordInputValue("");
        loginPage.clickLoginButton();
        String expectedErrorMessageText = "Epic sadface: Username is required";
        Assert.assertTrue(loginPage.isErrorMassageContainerDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessageText);

    }
    @Test(dataProvider = "login-test-data", groups = {"Negative", "Regression"} )
    public void negativeTestUnauthorizedUser(){
        loginPage.setUserNameInputValue("Ann");
        loginPage.setPasswordInputValue("Smith");
        loginPage.clickLoginButton();
        String expectedErrorMessageText = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue(loginPage.isErrorMassageContainerDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessageText);
    }

    @DataProvider(name = "login-test-data")
    public Object[][] getNegativeLoginTestData(){
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                { "standard_user", "", "Epic sadface: Password is required"},
                { "", "", "Epic sadface: Username is required"},
        };
    }
}