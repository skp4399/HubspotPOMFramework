package com.hubspot.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hubspot.qa.pages.BasePage;
import com.hubspot.qa.pages.ContactPage;
import com.hubspot.qa.pages.HomePage;
import com.hubspot.qa.pages.LoginPage;
import com.hubspot.qa.util.TestUtil;

public class ContactsPageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homepage;
	public ContactPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.init();
		prop = basePage.init_properties();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		contactsPage=homepage.goToContactsPage();
		//driver.manage().window().maximize();
		
	}
	
	@DataProvider
	public Object[][] getContactsTestData(){
		return TestUtil.getTestData("contact");
	}
	
	
	@Test(dataProvider="getContactsTestData")
	public void createContactTest(String email, String firstName, String lastName, String jobTitle) {
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);
	}
		
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
