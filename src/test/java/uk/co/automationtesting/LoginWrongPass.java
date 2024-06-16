package uk.co.automationtesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.ShoppingHome;
import PageObjects.ShoppingLoginPage;
import base.ExtentManager;
import base.Hooks;
import junit.framework.Assert;

@Listeners(resources.Listeners.class)

public class LoginWrongPass extends Hooks {

	public LoginWrongPass() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Test
	public void loginWrongPass() throws IOException {
		ShoppingHome home = new ShoppingHome();
		home.getCookie().click();
		home.getloginBtn().click();

		ExtentManager.pass("Login page loaded successfully");
		ShoppingLoginPage login = new ShoppingLoginPage();

		try {
			Assert.assertEquals(login.getLoginAccText().getText(), "Login to your account");
			ExtentManager.pass("Login Page sucessfully loaded");
		} catch (AssertionError e) {
			Assert.fail("Login failed");
			ExtentManager.fail("Login Page not loaded");
		}

		/****************************************************************************
		 * Excel Spreadsheet Layout Reminder (teaching purposes only)
		 * 
		 * |Row=0 -->| Email Address (Cell 0) Password (Cell 1) *
		 * --------------------------------------------------------------------
		 * |Row=1-->| Apple1@gmail.com (Cell 0) Apple1 (Cell 1) |Row=2 -->|
		 * john.smith@test.com (Cell 0) test123 (Cell 1) |Row=3 -->| lucy.jones@test.com
		 * (Cell 0) catlover1 (Cell 1) |Row=4 -->| martin.brian@test.com (Cell 0)
		 * ilovepasta5 (Cell 1)
		 ****************************************************************************/

		FileInputStream workbookLocation = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\credentials.xlsx");

		XSSFWorkbook Workbook = new XSSFWorkbook(workbookLocation);
		XSSFSheet sheet = Workbook.getSheetAt(0);

		Row row2 = sheet.getRow(2);
		Cell cellR2C0 = row2.getCell(0);
		Cell cellR2C1 = row2.getCell(1);

		String emailRow2 = cellR2C0.toString();
		String passwordRow2 = cellR2C1.toString();
		
		System.out.println(emailRow2);
		System.out.println(passwordRow2);
		
		login.getLoginEmail().sendKeys(emailRow2);
		ExtentManager.pass("Email input");
		login.getLoginPwd().sendKeys(passwordRow2);
		ExtentManager.pass("Password input");

		login.getLoginBtn().click();

		waitForElementVisible(login.getLoginIncorrect(), Duration.ofMillis(7000));

		try {
			Assert.assertEquals(login.getLoginIncorrect().getText(), "Your email or password is incorrect!");
			ExtentManager.pass("Passowrd failed message showing successfully");
		} catch (AssertionError e) {
			Assert.fail("Error message not showing");
			ExtentManager.pass("Error message not showing");
		}
		ExtentManager.pass("Test case completed");

	}

}
