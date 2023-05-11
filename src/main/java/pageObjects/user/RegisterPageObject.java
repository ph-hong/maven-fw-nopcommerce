package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TXTBOX, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TXTBOX, lastName);
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TXTBOX, email);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TXTBOX, password);
	}

	public void inputConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TXTBOX, confirmPassword);
	}

	public String getFirstNameRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
	}

	public String getLastNameRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
	}

	public String getEmailErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getPasswordErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_REQUIRED_ERROR_MSG);
	}

	public String getConfirmPasswordErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
	}

	public void clickRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}

	public String getVaidationErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.VALIDATION_ERROR_MSG);
	}
	
	public String getSuccessRegisterMsg() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_REGISTER_MSG);
		return getElementText(driver, RegisterPageUI.SUCCESS_REGISTER_MSG);
	}

}
