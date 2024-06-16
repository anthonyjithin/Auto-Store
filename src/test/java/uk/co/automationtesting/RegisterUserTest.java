package uk.co.automationtesting;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.ShoppingAccCreated;
import PageObjects.ShoppingAccDelete;
import PageObjects.ShoppingHome;
import PageObjects.ShoppingLoginPage;
import PageObjects.ShoppingSignUpPage;
import base.ExtentManager;
import base.Hooks;

@Listeners(resources.Listeners.class)

public class RegisterUserTest extends Hooks {

	public RegisterUserTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void registerUser() throws IOException, InterruptedException {
		ExtentManager.log("Starting registerUser Testt...");

		ShoppingHome home = new ShoppingHome();
		home.getCookie().click();

		Assert.assertEquals(home.getFeatureItems().getText(), "FEATURES ITEMS");
		try {
			Assert.assertEquals(home.getFeatureItems().getText(), "FEATURES ITEMS");
			ExtentManager.pass("Homepage successfully loaded");
		} catch (AssertionError e) {
			Assert.fail("Homepage not loaded");
			ExtentManager.fail("Homepage not loaded");
		}

		home.getloginBtn().click();
		ExtentManager.pass("Login Button clicked");

		ShoppingLoginPage login = new ShoppingLoginPage();
		try {
			Assert.assertEquals(login.getNewSignUp().getText(), "New User Signup!");
			ExtentManager.pass("Login Page sucessfully loaded");
		} catch (AssertionError e) {
			Assert.fail("Login Page not loaded");
			ExtentManager.fail("Login Page not loaded");
		}

		login.getName().sendKeys("Apple1");
		login.getEmail().sendKeys("Apple1@gmail.com");
		ExtentManager.log("Name and Email input success");
		login.getSignUpBtn().click();

		ShoppingSignUpPage signup = new ShoppingSignUpPage();
		signup.getMrTitle().click();
		ExtentManager.log("Title selected");

		signup.getName().sendKeys("Apple1");
		ExtentManager.pass("Name pass");
		// signup.getEmail().sendKeys("Apple1@gmail.com");
		// ExtentManager.pass("Email Pass");
		ExtentManager.log("Name and Email input success");

		signup.getPassword().sendKeys("Apple1");
		ExtentManager.log("Password input success");
		// signup.getDay().click();
		Select day = new Select(signup.getDay());
		day.selectByVisibleText("12");
		ExtentManager.pass("Day selected");

		Select month = new Select(signup.getMonth());
		month.selectByVisibleText("June");
		ExtentManager.pass("Month selected");

		Select year = new Select(signup.getYear());
		year.selectByVisibleText("1992");
		ExtentManager.pass("Year selected");

		// signup.getNewsLetter().click();
		// signup.getPassword().click();

		ExtentManager.log("Starting address info");
		signup.getFirstName().sendKeys("Apple1");
		signup.getLastName().sendKeys("Apple");

		signup.getCompany().sendKeys("Apple");
		signup.getAddress1().sendKeys("Apple1");
		signup.getAddress2().sendKeys("Apple2");

		Select country = new Select(signup.getCountry());
		country.selectByVisibleText("India");

		signup.getState().sendKeys("Kerala");
		signup.getCity().sendKeys("Kottayam");
		signup.getZipCode().sendKeys("686525");
		signup.getMobile().sendKeys("8281199952");
		ExtentManager.log("All data input success");

		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].scrollIntoView()", signup.getCreateAcc());
		signup.getCreateAcc().click();
		ExtentManager.pass("Create account button clicked");

		ShoppingAccCreated acc = new ShoppingAccCreated();

		try {
			Assert.assertEquals(acc.getAccCreated().getText(), "ACCOUNT CREATED!");
			ExtentManager.pass("Account created successfully");
		} catch (AssertionError e) {
			Assert.fail("Failed to create account");
			ExtentManager.fail("Account failed to create");
		}

		acc.getContinueBtn().click();
		ExtentManager.pass("Continue button clicked");
		acc.getHomeLink().click();
		ExtentManager.pass("Home button clicked");

		// Thread.sleep(1000);
		waitForElementVisible(home.getloginBtn(), Duration.ofMillis(7000));
		home.getloginBtn().click();
		ExtentManager.pass("Login button clicked");

		login.getLoginEmail().sendKeys("Apple1@gmail.com");
		ExtentManager.pass("Login email input");

		login.getLoginPwd().sendKeys("Apple1");
		ExtentManager.pass("Login password input");

		login.getLoginBtn().click();
		ExtentManager.pass("Login button clicked");

		try {
			Assert.assertEquals(home.getLoggedInName().getText(), "Logged in as Apple1Apple1");
			ExtentManager.pass("Account login successfully");

		} catch (AssertionError e) {
			Assert.fail("Failed to login");
			ExtentManager.fail("Failed to login");
		}
		//home.getDeleteAcc().click();
		//ExtentManager.pass("Delete button clicked");

		//ShoppingAccDelete delete = new ShoppingAccDelete();
		//try {
		//	Assert.assertEquals(delete.getDeleteText().getText(), "ACCOUNT DELETED!");
	//		ExtentManager.pass("Account deleted successfully");
		//} catch (AssertionError e) {
		//	Assert.fail("Failed to delete");
		//	ExtentManager.fail("Failed to delete");
		//}
		//delete.getContinueBtn().click();
		ExtentManager.pass("Test case completed");

	}

}
