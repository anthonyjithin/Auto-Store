package uk.co.automationtesting;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.ShoppingAccDelete;
import PageObjects.ShoppingHome;
import PageObjects.ShoppingLoginPage;
import base.ExtentManager;
import base.Hooks;

@Listeners(resources.Listeners.class)

public class LoginUserTest extends Hooks {

	public LoginUserTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void loginUserTest() throws IOException {
		ExtentManager.log("Starting ShopLoginTest...");

		ShoppingHome home = new ShoppingHome();
		home.getCookie().click();
		ExtentManager.pass("Cookie closed");

		waitForElementVisible(home.getloginBtn(), Duration.ofMillis(7000));
		home.getloginBtn().click();
		ExtentManager.pass("Login button clicked");

		ShoppingLoginPage login = new ShoppingLoginPage();
		try {
			Assert.assertEquals(login.getLoginAccText().getText(), "Login to your account");
			ExtentManager.pass("Login Page sucessfully loaded");
		} catch (AssertionError e) {
			Assert.fail("Login Page not loaded");
			ExtentManager.fail("Login Page not loaded");
		}

		FileInputStream workbookLocation = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\credentials.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(workbookLocation);
		XSSFSheet sheet = workbook.getSheetAt(0);

		/****************************************************************************
		 * Excel Spreadsheet Layout Reminder (teaching purposes only)
		 * 
		 * |Row=0 -->| Email Address (Cell 0) Password (Cell 1) *
		 * -------------------------------------------------------------------- |Row=1
		 * -->| Apple1@gmail.com (Cell 0) Apple1 (Cell 1) |Row=2 -->|
		 * john.smith@test.com (Cell 0) test123 (Cell 1) |Row=3 -->| lucy.jones@test.com
		 * (Cell 0) catlover1 (Cell 1) |Row=4 -->| martin.brian@test.com (Cell 0)
		 * ilovepasta5 (Cell 1)
		 ****************************************************************************/

		Row row1 = sheet.getRow(1);
		Cell cellR1C0 = row1.getCell(0);
		Cell cellR1C1 = row1.getCell(1);

		String emailRow1 = cellR1C0.toString();
		String passwordRow1 = cellR1C1.toString();

		login.getLoginEmail().sendKeys(emailRow1);
		ExtentManager.pass("Email input");
		login.getLoginPwd().sendKeys(passwordRow1);
		ExtentManager.pass("Password input");

		login.getLoginBtn().click();
		ExtentManager.pass("Login Successfull");

		try {
			Assert.assertEquals(home.getLoggedInName().getText(), "Logged in as Apple1");
			ExtentManager.pass("Login name sucessfully loaded");
		} catch (AssertionError e) {
			Assert.fail("Login Page not loaded");
			ExtentManager.fail("Login Page not loaded");
		}

		home.getDeleteAcc().click();
		ExtentManager.pass("Delete button clicked");

		ShoppingAccDelete delete = new ShoppingAccDelete();
		try {
			Assert.assertEquals(delete.getDeleteText().getText(), "ACCOUNT DELETED!");
			ExtentManager.pass("Account deleted successfully");
		} catch (AssertionError e) {
			Assert.fail("Failed to delete");
			ExtentManager.fail("Failed to delete");
		}

		delete.getContinueBtn().click();
		ExtentManager.pass("Test case completed");

	}

}
