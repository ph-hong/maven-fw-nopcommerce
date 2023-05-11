package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

public class Account_02_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;

	String email, password;

	@Parameters({ "browser" })

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "hpatt@live.com";
		password = "hpattest";
	}

	@Test
	public void Login_TC01_Empty_Data() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail("");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getEmailErrorMsg(), "Please enter your email");
	}

	@Test
	public void Login_TC02_Incorrect_Email() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail("testEmail@123@66");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getEmailErrorMsg(), "Wrong email");
	}

	@Test
	public void Login_TC03_Unregistered_Email() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail("unregis@test.com");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getValidationErrorMsg(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void Login_TC04_Input_Valid_Email_And_Not_Input_Password() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getValidationErrorMsg(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void Login_TC05_Input_Valid_Email_And_Icorrect_Password() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword("123456");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getValidationErrorMsg(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void Login_TC06_Correct_Credentials() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
		loginPage.clickLoginBtn();

		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
