package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ProductListPage extends BasePage{

	public ProductListPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	
	By productTitle = By.cssSelector(".product-information > h2");
	By firstProduct = By.cssSelector("[href='\\/product_details\\/1']");
	
	public WebElement getProductTitle() throws IOException {
		this.driver = getDriver();
		return driver.findElement(productTitle);
	}
	public WebElement getFirstProduct() throws IOException {
		this.driver = getDriver();
		return driver.findElement(firstProduct);
	}
	
	

}
