package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.user.ProductViewPageUI;

public class ProductViewPageObject extends BasePage{
	WebDriver driver;
	public ProductViewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public ProductReviewPageObject clickAddYourReviewLink() {
		waitForElementClickable(driver, ProductViewPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, ProductViewPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewPage(driver);
	}
}
