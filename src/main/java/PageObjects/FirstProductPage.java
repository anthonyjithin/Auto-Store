package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class FirstProductPage extends BasePage{

	public FirstProductPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	
	By productName = By.cssSelector(".product-information > h2");
	By category = By.cssSelector(".product-information > p:nth-of-type(1)");
	By price = By.cssSelector(".product-information span:nth-child(5) span");
	By availability = By.cssSelector(".product-information > p:nth-of-type(2)");
	
	
	public WebElement getProductName() throws IOException {
		this.driver = getDriver();
		return driver.findElement(productName);
	}
	public WebElement getCategory() throws IOException {
		this.driver = getDriver();
		return driver.findElement(category);
	}
	public WebElement getPrice() throws IOException {
		this.driver = getDriver();
		return driver.findElement(price);
	}
	public WebElement getAvailability() throws IOException {
		this.driver = getDriver();
		return driver.findElement(availability);
	}

}
