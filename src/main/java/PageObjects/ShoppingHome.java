package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingHome extends BasePage{

	public ShoppingHome() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	
	By loginBtn = By.cssSelector("li:nth-of-type(4) > a");
	By featureItems = By.cssSelector(".features_items .title");
	By loggedInName = By.cssSelector("li:nth-of-type(10) > a");
	By deleteAcc = By.cssSelector("[href='\\/delete_account']");
	By cookie = By.cssSelector(".fc-dialog-container [role='dialog']:nth-of-type(1) [role='button']:nth-of-type(1) .fc-button-label");
	By productBtn = By.cssSelector("div:nth-of-type(2) > .product-image-wrapper > .choose > .nav.nav-justified.nav-pills  a");
			
			
	public WebElement getloginBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginBtn);
	}
	public WebElement getFeatureItems() throws IOException {
		this.driver = getDriver();
		return driver.findElement(featureItems);
		//text FEATURES ITEMS
	}
	public WebElement getLoggedInName() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loggedInName);
		//text Logged in as Apple@gmail.com
	}
	public WebElement getDeleteAcc() throws IOException {
		this.driver = getDriver();
		return driver.findElement(deleteAcc);
	}
	public WebElement getCookie() throws IOException {
		this.driver = getDriver();
		return driver.findElement(cookie);
	}
	public WebElement getProductBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(productBtn);
	}

}
