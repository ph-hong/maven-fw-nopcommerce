package pageUIs.user;

public class MyAccountPageUI {
	
	/*
	 * Common
	 */
	public static final String BAR_NOTIFICATION_SUCCESS = "CSS=div[class*='bar-notification success']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "XPATH=//select[@name='%s']";

	/*
	 * Customerinfo
	 */
	public static final String CUSTOMER_INFO_LINK = "XPATH=//a[text()='Customer info']";
	public static final String MALE_RADIO_BTN = "ID=gender-male";
	public static final String FEMALE_RADIO_BTN = "ID=gender-female";
	public static final String FIRST_NAME_TXTBOX = "ID=FirstName";
	public static final String LAST_NAME_TXTBOX = "ID=LastName";
	public static final String COMPANY_NAME_TXTBOX = "ID=Company";
	public static final String SAVE_BTN = "ID=save-info-button";
	
	/*
	 * Add Addresses
	 */

	public static final String ADDDRESSES_LINK = "XPATH=//a[text()='Addresses']";
	public static final String ADD_NEW_BTN = "XPATH=//button[text()='Add new']";
	public static final String ADDRESS_FIRST_NAME_TXTBOX = "ID=Address_FirstName";
	public static final String ADDRESS_LAST_NAME_TXTBOX = "ID=Address_LastName";
	public static final String ADDRESS_EMAIL_TXTBOX = "ID=Address_Email";
	public static final String ADDRESS_COMPANY_TXTBOX = "ID=Address_Company";
	public static final String CITY_TXTBOX = "ID=Address_City";
	public static final String ADDRESS_1_TXTBOX = "ID=Address_Address1";
	public static final String ADDRESS_2_TXTBOX = "ID=Address_Address2";
	public static final String ZIP_POSTAL_CODE = "ID=Address_ZipPostalCode";
	public static final String PHONE_NUMBER_TXTBOX = "ID=Address_PhoneNumber";
	public static final String FAX_NUMBER_TXTBOX = "ID=Address_FaxNumber";
	public static final String SAVE_ADDRESS_BTN = "XPATH=//button[text()='Save']";
	
	/*
	 * Change Password
	 */
	
	public static final String CHANGE_PASSWORD_LINK ="XPATH=//a[text()='Change password']";
	public static final String OLD_PASSWPRD_TXTBOX = "ID=OldPassword";
	public static final String NEW_PASSWPRD_TXTBOX = "ID=NewPassword";
	public static final String CONFIRM_PASSWPRD_TXTBOX = "ID=ConfirmNewPassword";
	public static final String CHANGE_PASSWORD_BTN = "XPATH=//button[text()='Change password']";

	public static final String LOG_OUT_LINK = "XPATH=//a[text()='Log out']";
	public static final String CLOSE_BTN = "XPATH=//span[@title='Close']";
	
	/*
	 * Product Review
	 */
	
	public static final String MY_PRODUCT_REVIEW_LINK = "//a[text()='My product reviews']";
	public static final String MACBOOK_VIEW_LINK = "//a[text()='Apple MacBook Pro 13-inch']";
	
	
	
}
