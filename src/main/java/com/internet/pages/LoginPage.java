package com.internet.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class LoginPage extends Page {

	private static final String PAGE_URL = "/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By usernameField = By.cssSelector("#username");
	private By passwordField = By.cssSelector("#password");
	private By login = By.cssSelector("button.radius");

	public void enterUsername(String username) {
		((Proxywrapper) driver).sendKeys(usernameField, username);
	}

	public void enterPassword(String password) {
		((Proxywrapper) driver).sendKeys(passwordField, password);
	}

	public SecureAreaPage clickSubmitBtn() {
		((Proxywrapper) driver).submit(login);
		return new SecureAreaPage(driver, true);
	}
	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(driver.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}

}
