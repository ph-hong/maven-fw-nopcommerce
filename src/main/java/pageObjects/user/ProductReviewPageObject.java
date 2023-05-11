package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.user.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage {
	WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputReviewTitle(String reviewTitle) {
		waitForElementClickable(driver, ProductReviewPageUI.REVIEW_TITLE);
		sendKeyToElement(driver, ProductReviewPageUI.REVIEW_TITLE, reviewTitle);
	}

	public void inputReviewText(String reviewText) {
		waitForElementClickable(driver, ProductReviewPageUI.REVIEW_TEXT);
		sendKeyToElement(driver, ProductReviewPageUI.REVIEW_TEXT, reviewText);
	}

	public void clickSubmitReview() {
		waitForElementClickable(driver, ProductReviewPageUI.SUBMIT_REVIEW_BTN);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BTN);
	}

	public void selectRatinng3() {
		waitForElementClickable(driver, ProductReviewPageUI.RATING_3);
		clickToElement(driver, ProductReviewPageUI.RATING_3);

	}

	public String getProductReviewSuccessMsg() {
		waitForElementVisible(driver, ProductReviewPageUI.ADD_REVIEW_SUCCESS_MSG);
		return getElementText(driver, ProductReviewPageUI.ADD_REVIEW_SUCCESS_MSG);
	}

	public MyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(driver, ProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, ProductReviewPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

}
