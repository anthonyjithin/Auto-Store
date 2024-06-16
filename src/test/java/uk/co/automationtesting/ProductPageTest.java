package uk.co.automationtesting;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.FirstProductPage;
import PageObjects.ProductListPage;
import PageObjects.ShoppingHome;
import base.ExtentManager;
import base.Hooks;

@Listeners(resources.Listeners.class)

public class ProductPageTest extends Hooks {

	public ProductPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void productPageTest() throws IOException {
		ExtentManager.log("Starting Product Page content test");
		ShoppingHome home = new ShoppingHome();
		home.getCookie().click();

		waitForElementVisible(home.getProductBtn(), Duration.ofMillis(7000));
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].scrollIntoView()", home.getProductBtn());
		home.getProductBtn().click();
		
		ExtentManager.pass("Product Button clicked");

		ProductListPage product = new ProductListPage();
		
		waitForElementVisible(product.getProductTitle(), Duration.ofMillis(7000));
		try {
			Assert.assertEquals(product.getProductTitle().getText(), "All Products");
			ExtentManager.pass("All product is showing on product list page");
		} catch (AssertionError e) {
			Assert.fail("Product list page not loaded");
		}

		product.getFirstProduct().click();
		ExtentManager.pass("First product clicked");

		FirstProductPage productPage = new FirstProductPage();

		try {
			Assert.assertEquals(productPage.getProductName().getText(), "Blue Top");
			ExtentManager.pass("All product is showing on product list page");
		} catch (AssertionError e) {
			Assert.fail("Totle list page not loaded");
		}
		
		try {
			Assert.assertEquals(productPage.getCategory(), "Category: Women > Tops");
			ExtentManager.pass("Category is showing on product list page");
		} catch (AssertionError e) {
			Assert.fail("Category list page not loaded");
		}
		
		try {
			Assert.assertEquals(productPage.getPrice(), "Rs. 500");
			ExtentManager.pass("Price is showing on product list page");
		} catch (AssertionError e) {
			Assert.fail("Price list page not loaded");
		}
		try {
			Assert.assertEquals(productPage.getAvailability().getText(), "Availability: In Stock");
			ExtentManager.pass("All product is showing on product list page");
		} catch (AssertionError e) {
			Assert.fail("Availability list page not loaded");
		}
		
		ExtentManager.pass("Test completed");

	}

}
