package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingAccDelete extends BasePage{

	public ShoppingAccDelete() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	 
	By deleteText = By.cssSelector(".text-center.title > b");
	// text ACCOUNT DELETED!
	By continueBtn = By.cssSelector(".btn.btn-primary");
	
	public WebElement getDeleteText() throws IOException {
		this.driver = getDriver();
		return driver.findElement(deleteText);
	}
	public WebElement getContinueBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(continueBtn);
	}
}
