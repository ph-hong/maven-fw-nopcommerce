package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.user.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TXTBOX, email);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXTBOX, password);
		
	}

	public void clickLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}

	public String getEmailErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MSG);
	}

	public String getValidationErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.VALIDATION_ERROR_MSG);
		return getElementText(driver, LoginPageUI.VALIDATION_ERROR_MSG);
	}

	public boolean isLogoutLinkDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplayedInDOM(driver, LoginPageUI.LOGOUT_LINK);
	}

}
