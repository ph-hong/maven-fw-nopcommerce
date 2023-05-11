package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.user.LoginPageUI;
import pageUIs.user.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Customer Info
	 */
	public void clickCustomerInfo() {
		waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);
	}

	public void selectFemaleGender() {
		waitForElementClickable(driver, MyAccountPageUI.FEMALE_RADIO_BTN);
		clickToElement(driver, MyAccountPageUI.FEMALE_RADIO_BTN);
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FIRST_NAME_TXTBOX, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.LAST_NAME_TXTBOX, lastName);
	}

	public void inputCompanyName(String companyName) {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TXTBOX, companyName);
	}

	public void clickSaveBtn() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BTN);
		clickToElement(driver, MyAccountPageUI.SAVE_BTN);
	}

	public String getUpdateSuccessMsg() {
		waitForElementVisible(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
		return getElementText(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
	}

	/*
	 * Add Addresses
	 */

	public void clickAddressesLink() {
		waitForElementClickable(driver, MyAccountPageUI.ADDDRESSES_LINK);
		clickToElement(driver, MyAccountPageUI.ADDDRESSES_LINK);
	}

	public void clickAddNewBtn() {
		waitForElementClickable(driver, MyAccountPageUI.ADD_NEW_BTN);
		clickToElement(driver, MyAccountPageUI.ADD_NEW_BTN);
	}

	public void inputAddressFirstName(String addressFirstName) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TXTBOX, addressFirstName);
	}

	public void inputAddressLastName(String addressLastName) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TXTBOX, addressLastName);
	}

	public void inputAddressEmail(String addressEmail) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_EMAIL_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TXTBOX, addressEmail);
	}

	public void inputAddressCompany(String addressCompany) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COMPANY_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_COMPANY_TXTBOX, addressCompany);
	}

	public void inputCity(String city) {
		waitForElementVisible(driver, MyAccountPageUI.CITY_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.CITY_TXTBOX, city);
	}

	public void inputAddress1(String address1) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_1_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_1_TXTBOX, address1);
	}

	public void inputAddress2(String address2) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_2_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_2_TXTBOX, address2);
	}

	public void inputZipPostalCode(String zipPostalCode) {
		waitForElementVisible(driver, MyAccountPageUI.ZIP_POSTAL_CODE);
		sendKeyToElement(driver, MyAccountPageUI.ZIP_POSTAL_CODE, zipPostalCode);
	}

	public void inputPhoneNumer(String phoneNumber) {
		waitForElementVisible(driver, MyAccountPageUI.PHONE_NUMBER_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.PHONE_NUMBER_TXTBOX, phoneNumber);
	}

	public void inputFaxNumber(String faxNumber) {
		waitForElementVisible(driver, MyAccountPageUI.FAX_NUMBER_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FAX_NUMBER_TXTBOX, faxNumber);

	}

	public void clickSaveAddressBtn(String string) {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_ADDRESS_BTN);
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BTN);
	}

	public String getAddedAddressSuccessMsg() {
		waitForElementVisible(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
		return getElementText(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
	}

	/*
	 * Change password
	 */

	public void clickChangePasswordLink() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
	}

	public void inputOldPassword(String oldPassword) {
		waitForElementVisible(driver, MyAccountPageUI.OLD_PASSWPRD_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.OLD_PASSWPRD_TXTBOX, oldPassword);
	}

	public void inputNewPassword(String newPassword) {
		waitForElementVisible(driver, MyAccountPageUI.NEW_PASSWPRD_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.NEW_PASSWPRD_TXTBOX, newPassword);
	}

	public void inputConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_PASSWPRD_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.CONFIRM_PASSWPRD_TXTBOX, confirmPassword);
	}

	public void clickChangePasswordBtn() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_BTN);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BTN);
	}

	public String getChangePasswordSuccessMsg() {
		waitForElementVisible(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
		return getElementText(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
	}

	public void clickLogoutLink() {
		waitForElementClickable(driver, MyAccountPageUI.LOG_OUT_LINK);
		clickToElement(driver, MyAccountPageUI.LOG_OUT_LINK);
	}

	public void clickCloseBtnOnSuccessMsg() {
		waitForElementClickable(driver, MyAccountPageUI.CLOSE_BTN);
		clickToElement(driver, MyAccountPageUI.CLOSE_BTN);
	}
	
	public boolean isLogoutLinkDisplayed() {
		return isElementDisplayedInDOM(driver, LoginPageUI.LOGOUT_LINK);
	}

	public void clickMyProductReview() {
		waitForElementClickable(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
	}
	
	public boolean isProductReviewLinkDisplayed() {
		return isElementDisplayedInDOM(driver, MyAccountPageUI.MACBOOK_VIEW_LINK);

	}

}
