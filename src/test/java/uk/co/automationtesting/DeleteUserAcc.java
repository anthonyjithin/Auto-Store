package uk.co.automationtesting;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.ShoppingAccDelete;
import PageObjects.ShoppingHome;
import PageObjects.ShoppingLoginPage;
import base.BasePage;
import base.ExtentManager;
import base.Hooks;
@Listeners(resources.Listeners.class)

public class DeleteUserAcc extends Hooks{

	public DeleteUserAcc() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test 
	public void deleteUser() throws IOException {
		ExtentManager.log("Starting deleteUser Test...");
		ShoppingHome home = new ShoppingHome();
		home.getCookie().click();
		
		home.getloginBtn().click();
		
		ShoppingLoginPage loginPage = new ShoppingLoginPage();
		loginPage.getLoginEmail().sendKeys("Apple1@gmail.com");
		loginPage.getLoginPwd().sendKeys("Apple1");
		loginPage.getLoginBtn().click();
		JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
		jse1.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
		
		home.getDeleteAcc().click();
		ExtentManager.pass("Account deleted successfully");
		ShoppingAccDelete delete = new ShoppingAccDelete();
		
		try {
			Assert.assertEquals(delete.getDeleteText().getText(), "ACCOUNT DELETED!");
			ExtentManager.pass("Account deleted successfully");
		}catch (AssertionError e) {
			Assert.fail("Failed to delete");
			ExtentManager.fail("Failed to delete");
		}
		delete.getContinueBtn().click();
		ExtentManager.pass("Test case completed");
		
		
		
	}
}
