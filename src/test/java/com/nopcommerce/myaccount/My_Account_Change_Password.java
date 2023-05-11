package com.nopcommerce.myaccount;

import java.util.Random;

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
import pageObjects.user.MyAccountPageObject;

public class My_Account_Change_Password extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	MyAccountPageObject myAccountPage;
	LoginPageObject loginPage;

	String email, password;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "hpattest09@live.com";
		password = "newPass194861";

		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
		loginPage.clickLoginBtn();

		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());

		myAccountPage = homePage.clickMyAccountLink();
	}

	@Test
	public void My_Account_TC03_Change_Password() {
		String oldPassword = password;
		String newPassword = "newPass" + randomNumber();

		myAccountPage.clickChangePasswordLink();
		myAccountPage.inputOldPassword(oldPassword);
		myAccountPage.inputNewPassword(newPassword);
		myAccountPage.inputConfirmPassword(newPassword);
		myAccountPage.clickChangePasswordBtn();

		System.out.println("New Password: " + newPassword);

		Assert.assertEquals(myAccountPage.getChangePasswordSuccessMsg(), "Password was changed");

		myAccountPage.clickCloseBtnOnSuccessMsg();
		sleepInsecond(3);
		myAccountPage.clickLogoutLink();

		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword(newPassword);
		loginPage.clickLoginBtn();

		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	public void sleepInsecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
