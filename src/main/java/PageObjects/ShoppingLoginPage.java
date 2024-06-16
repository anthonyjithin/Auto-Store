package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingLoginPage extends BasePage {

	public ShoppingLoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;

	By name = By.cssSelector("form[method='post'] > input[name='name']");
	By email = By.cssSelector(".signup-form > form[method='post'] > input[name='email']");
	By singUpBtn = By.cssSelector(".signup-form > form[method='post'] > .btn.btn-default");
	By newSignUp = By.cssSelector(".signup-form > h2");
	By loginEmail = By.cssSelector(".login-form > form[method='post'] > input[name='email']");
	By loginPwd = By.cssSelector("form[method='post'] > input[name='password']");
	By loginBtn = By.cssSelector(".login-form > form[method='post'] > .btn.btn-default");
	By loginAccText = By.cssSelector(".login-form > h2");
	By loginIncorrect = By.cssSelector(".login-form > form[method='post'] > p");
	By logoutBtn = By.cssSelector("[href='\\/logout']");

	public WebElement getName() throws IOException {
		this.driver = getDriver();
		return driver.findElement(name);
	}

	public WebElement getEmail() throws IOException {
		this.driver = getDriver();
		return driver.findElement(email);
	}

	public WebElement getSignUpBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(singUpBtn);
	}

	public WebElement getLoginEmail() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginEmail);

	}

	public WebElement getLoginPwd() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginPwd);
	}

	public WebElement getLoginBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginBtn);
	}

	public WebElement getNewSignUp() throws IOException {
		this.driver = getDriver();
		return driver.findElement(newSignUp);
	}

	public WebElement getLoginAccText() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginAccText);
	}

	public WebElement getLoginIncorrect() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginIncorrect);
	}
	public WebElement getLogoutBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(logoutBtn);
	}
}
