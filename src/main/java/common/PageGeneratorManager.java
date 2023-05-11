package common;

import org.openqa.selenium.WebDriver;

import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.ProductReviewPageObject;
import pageObjects.user.ProductViewPageObject;
import pageObjects.user.RegisterPageObject;

public class PageGeneratorManager {

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static ProductViewPageObject getProductViewPage(WebDriver driver) {
		return new ProductViewPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
}
