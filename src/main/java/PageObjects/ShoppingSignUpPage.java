package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingSignUpPage extends BasePage{

	public ShoppingSignUpPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	
	By enterInfo = By.cssSelector(".login-form > .text-center.title > b");
	By mrTitle = By.cssSelector("div:nth-of-type(1) > .top");
	By mrsTitle = By.cssSelector("div:nth-of-type(2) > .top");
	By name = By.cssSelector("input#name");
	By email = By.cssSelector("input#email");
	By password = By.cssSelector("input#password");
	By day = By.cssSelector("select#days");
	By month = By.cssSelector("select#months");
	By year = By.cssSelector("select#years");
	By newsLetter = By.cssSelector("[for='newsletter']");
	By specialOffer = By.cssSelector("[for='optin']");
	By firstName = By.cssSelector("input#first_name");
	By lastName = By.cssSelector("input#last_name");
	By company = By.cssSelector("input#last_name");
	By address1 = By.cssSelector("input[name='address1']");
	By address2 = By.cssSelector("input[name='address2']");
	By country = By.cssSelector("select#country");
	By state = By.cssSelector("input#state");
	By city = By.cssSelector("input#city");
	By zipCode = By.cssSelector("input#zipcode");
	By mobile = By.cssSelector("input#mobile_number");
	By createAcc = By.cssSelector("section#form > .container form[method='post'] > .btn.btn-default");
	
	public WebElement getEnterInfo() throws IOException {
		this.driver = getDriver();
		return driver.findElement(enterInfo);
	}
	public WebElement getMrTitle() throws IOException {
		this.driver = getDriver();
		return driver.findElement(mrTitle);
	}
	public WebElement getMrsTitle() throws IOException {
		this.driver = getDriver();
		return driver.findElement(mrsTitle);
	}
	public WebElement getName() throws IOException {
		this.driver = getDriver();
		return driver.findElement(name);
	}
	public WebElement getEmail() throws IOException {
		this.driver = getDriver();
		return driver.findElement(email);
	}
	public WebElement getPassword() throws IOException {
		this.driver = getDriver();
		return driver.findElement(password);
	}
	public WebElement getDay() throws IOException {
		this.driver = getDriver();
		return driver.findElement(day);
	}
	public WebElement getMonth() throws IOException {
		this.driver = getDriver();
		return driver.findElement(month);
	}
	public WebElement getYear() throws IOException {
		this.driver = getDriver();
		return driver.findElement(year);
	}
	public WebElement getNewsLetter() throws IOException {
		this.driver = getDriver();
		return driver.findElement(newsLetter);
	}
	public WebElement getSpecialOffer() throws IOException {
		this.driver = getDriver();
		return driver.findElement(specialOffer);
	}
	public WebElement getFirstName() throws IOException {
		this.driver = getDriver();
		return driver.findElement(firstName);
	}
	public WebElement getLastName() throws IOException {
		this.driver = getDriver();
		return driver.findElement(lastName);
	}
	public WebElement getCompany() throws IOException {
		this.driver = getDriver();
		return driver.findElement(company);
	}
	public WebElement getAddress1() throws IOException {
		this.driver = getDriver();
		return driver.findElement(address1);
	}
	public WebElement getAddress2() throws IOException {
		this.driver = getDriver();
		return driver.findElement(address2);
	}
	public WebElement getCountry() throws IOException {
		this.driver = getDriver();
		return driver.findElement(country);
	}
	public WebElement getState() throws IOException {
		this.driver = getDriver();
		return driver.findElement(state);
	}
	public WebElement getZipCode() throws IOException {
		this.driver = getDriver();
		return driver.findElement(zipCode);
	}
	public WebElement getMobile() throws IOException {
		this.driver = getDriver();
		return driver.findElement(mobile);
	}
	public WebElement getCreateAcc() throws IOException {
		this.driver = getDriver();
		return driver.findElement(createAcc);
	}
	public WebElement getCity() throws IOException {
		this.driver = getDriver();
		return driver.findElement(city);
	}
	
}
