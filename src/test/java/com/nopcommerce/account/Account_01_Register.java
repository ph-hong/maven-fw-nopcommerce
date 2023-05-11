package com.nopcommerce.account;

import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	String email;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "hpTest" + randomNumber() + "@live.com";
	}

	@Test
	public void Register_TC01_Empty_Data() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("");
		registerPage.inputLastName("");
		registerPage.inputEmail("");
		registerPage.inputPassword("");
		registerPage.inputConfirmPassword("");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameRequiredErrorMsg(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameRequiredErrorMsg(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMsg(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMsg(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "Password is required.");
	}

	@Test
	public void Register_TC02_Email_Incorrect() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("test First Name");
		registerPage.inputLastName("test Last Name");
		registerPage.inputEmail("testEmail@123@66");
		registerPage.inputPassword("pass12345");
		registerPage.inputConfirmPassword("pass12345");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMsg(), "Wrong email");
	}

	@Test
	public void Register_TC03_Password_Fewer_Than_6_Chars() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("test First Name");
		registerPage.inputLastName("test Last Name");
		registerPage.inputEmail("atTestMail01@gmail.com");
		registerPage.inputPassword("12345");
		registerPage.inputConfirmPassword("12345");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMsg(),
				"Password must meet the following rules:\n" + "must have at least 6 characters");
	}

	@Test
	public void Register_TC04_Password_And_Confirm_Password_Not_Match() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name");
		registerPage.inputLastName("HP Last Name");
		registerPage.inputEmail("atTestMail01@gmail.com");
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123457");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_TC05_Valid_Data() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name");
		registerPage.inputLastName("HP Last Name");
		registerPage.inputEmail(email);
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getSuccessRegisterMsg(), "Your registration completed");
	}

	@Test
	public void Register_TC06_Existed_Email() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name");
		registerPage.inputLastName("HP Last Name");
		registerPage.inputEmail(email);
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.clickRegisterButton();

		String emailValid = email;
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name 06");
		registerPage.inputLastName("HP Last Name 06");
		registerPage.inputEmail(emailValid);
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getVaidationErrorMsg(), "The specified email already exists");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
}
