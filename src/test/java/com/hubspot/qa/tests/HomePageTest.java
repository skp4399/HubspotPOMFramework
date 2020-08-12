package com.hubspot.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.qa.pages.BasePage;
import com.hubspot.qa.pages.HomePage;
import com.hubspot.qa.pages.LoginPage;

public class HomePageTest {
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homepage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.init();
		prop = basePage.init_properties();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().window().maximize();
		
	}

	@Test(priority = 1)
	public void homePageTitleTest() throws InterruptedException {
		
		String title = homepage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Setup | HubSpot");
	}

	@Test(priority = 2)
	public void accountNameTest() throws InterruptedException {
		
		String AccountName = homepage.getLoggedInAccountname();
		System.out.println("LoggedIn User Name :" + AccountName);
		Assert.assertEquals(AccountName, prop.getProperty("accountname"));
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
