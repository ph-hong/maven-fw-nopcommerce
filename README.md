# maven-fw-nopcommerce
This is a demo framework for E-Commerce domain based on nopCommerce which is an open-source eCommerce platform.

MAVEN FRAMEWORK - NOPCOMMERCE
===================

**I. Pre-requisites**
---------------------
*   CHECK LIST

**Link:** [https://tinyurl.com/nopcommercechecklist](https://tinyurl.com/nopcommercechecklist)

### 1\. For development

*   JDK 11

_Download link_: [https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html]( https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

*   Eclipse IDEA

_Download link_: [https://www.eclipse.org]( https://www.eclipse.org)

*   Maven 3.6.3

_Download link_: [https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/](https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/)

### 2\. For running tests only

*   JDK 11
*   Maven 3.6.3

**II. Repository**
------------------

**Link:** [https://github.com/ph-hong/maven-fw-nopcommerce](https://github.com/ph-hong/maven-fw-nopcommerce)

### 1\. For development

*   branch: _master_

### 2\. For running tests only

*   branch: _master_

**III. Project structure**
--------------------------

### 1\. src

*   _main/java_
    *   _common_
        *   _BasePage.java_
            > Store wrapper methods of Selenium API
            * click/type/select
            * isEnabled/isDisplayed
            * getText/getTitle

        *   _BaseTest.java_
            > Store common methods for the testcases layer
            * open browser
            * closer browser
            * random number

        *   _GlobalConstants.java_
            > Store Constants variables and Global variables

        *   _PageGeneratorManager_
            > used to generate page object.

    *   _pageObjects_
        > Store Page Objects
        *   _HomePageObject_
        *   _LoginPageObject_
        *   _RegisterPageObject_
        *   _***PageObject_
    *   _pageUIs_
        > Store Page UI where element locators are defined
        *   _HomePageUI_
        *   _LoginPageUI_
        *   _RegisterPageUI_
        *   _***PageUI_

*   _test_
    *   _java_
        *   __<_class's name_\>.java__
        > Each class/file is a test suite. Each suite includes many tests

    *   _resources_
        *   _runNopCommerceTestcases.xml_
        > Settings of TestNG for tests

### 2\. testdata
> Each json file is data for a test.

### 3\. .gitignore
> List of files/folder to be ignored for commit/push to repository

### 4\. pom.xml
> List of essential libraries of the project

**IV. How to set up a run**
---------------------------

1.  Open src/test/resources/runNopCommerceTestcases.xml>
2.  Add the class name of tests to run
3.  Comment class name of tests not to run with `` `<!-- -->   ` ``

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite parallel="false" name="Nop Commerce">
	<!-- <parameter name="URL" value="https://demo.nopcommerce.com/" /> -->

	<test name="Run on Firefox browser">
		<parameter name="browser" value="chrome" />
		<classes>
			<class name="com.nopcommerce.account.Account_01_Register" />
<!-- 			<class name="com.nopcommerce.account.Account_02_Login" /> -->
		</classes>
	</test>
</suite> 
```

**V. How to run**
-----------------

### 1\. For development

*   **Run in IDE:**

    *1. Open Eclipse IDE*
    
    *2. Right click on the 'src/test/resources/runNopCommerceTestcases.xml' file, move the cursor down to Run As and then click on the 1 TestNG Suite.*


*   **Run in CLI:**

    *1. By default, it will run 'src/test/resources/runNopCommerceTestcases.xml'*

        `mvn clean test`

    *2. Paste a name of TestNG file to run, it will run the specified one*

        `cd path/to/project-folder`

        `mvn clean test -Dtestng.file=<name of a TestNG file>`

        `Ex: mvn clean test -Dtestng.file=runNopCommerceTestcases.xml`


*   **view report:**

    `(update soon)`

### 2\. For running tests only

*   **in CLI:**

    `git clone path/to/repository`

    `cd path/to/project-folder`

    `mvn clean test -Dtestng.file=<name of a TestNG file to run test cases>`

**VI. Sample test**
-------------------

```xml
public class Account_02_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;

	String email, password;

	@Parameters({ "browser" })

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "hpatt@live.com";
		password = "hpattest";
	}

	@Test
	public void Login_TC01_Empty_Data() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail("");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getEmailErrorMsg(), "Please enter your email");
	}

	@Test
	public void Login_TC02_Incorrect_Email() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail("testEmail@123@66");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getEmailErrorMsg(), "Wrong email");
	}

	@Test
	public void Login_TC03_Unregistered_Email() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail("unregis@test.com");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();

		Assert.assertEquals(loginPage.getValidationErrorMsg(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void Login_TC06_Correct_Credentials() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
		loginPage.clickLoginBtn();

		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

```
`@Parameters()`
> define 'browser' to run based on the browser parameter in *.xml file

`@BeforeClass()`
> runs before all the test methods.

`@Test`
> the actual test case

`Assert.*`
> verify expected results

`@AfterClass()`
> the quit browser test case

**VII. Note**
-------------------
_This framework is developing._
