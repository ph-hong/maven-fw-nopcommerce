package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.user.MyAccountPageUI;

public class BasePage {

	/* Web Browser */

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String castRestParameter(String locator, String... dynamicLocator) {
		locator = String.format(locator, (Object[]) dynamicLocator);
		return locator;

	}

	/* Web element */

	private By getByLocator(String locator) {
		By by = null;
		if (locator.startsWith("ID=")) {
			by = By.id(locator.substring(3));
		} else if (locator.startsWith("CLASS=")) {
			by = By.className(locator.substring(6));
		} else if (locator.startsWith("NAME=")) {
			by = By.name(locator.substring(5));
		} else if (locator.startsWith("CSS=")) {
			by = By.cssSelector(locator.substring(4));
		} else if (locator.startsWith("XPATH=")) {
			by = By.xpath(locator.substring(6));
		} else {
			throw new RuntimeException("Locator is not valid!");
		}

		return by;
	}

	private WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String valueToInput) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(valueToInput);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}

	public boolean isElementDisplayedInDOM(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}

	public void tselectItemInCustomDropdown(WebDriver driver, String parentElemenInDropdown,
			String childElementInDropdown, String expectedItem) {
		getWebElement(driver, parentElemenInDropdown).click();
		sleepInsecond(2);

		List<WebElement> childItems = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childElementInDropdown)));
		for (WebElement tempElement : childItems) {
			if (tempElement.getText().trim().equals(expectedItem)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", tempElement);
				sleepInsecond(1);
				tempElement.click();
				sleepInsecond(1);
				break;
			}

		}

	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText,
			String... dynamicLocator) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, dynamicLocator)));
		select.selectByVisibleText(itemText);
	}

	public void selectDropdownByName(WebDriver driver, String dropdownName, String dropdownItem) {
		waitForElementClickable(driver, MyAccountPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, MyAccountPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownItem, dropdownName);
	}

	public void sleepInsecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/* Wait */

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... dynamicLocator) {
		new WebDriverWait(driver, longTimeout).until(
				ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, dynamicLocator))));
	}

	private long longTimeout = 20;
}
