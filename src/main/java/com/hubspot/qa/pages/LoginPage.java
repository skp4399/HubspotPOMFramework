package com.hubspot.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	// 1.webelements-- (in the form of pagefactory)
	// 2.Actions or Methods

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "loginBtn")
	WebElement loginButton;

	// Need to create a LoginPage constructor. Pagefactory is used to initialize the
	// webElemts of this class and
	// register all the elements with the driver.
	// we had declared the webelements and locate the elements with find by but need
	// to register with driver as well.

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// now all the webelements are registered with the driver.
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String username, String pwd) {
		userName.sendKeys(username);
		Password.sendKeys(pwd);
		loginButton.click();

		return new HomePage(driver);
	}
}
