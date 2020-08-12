package com.hubspot.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactButton;

	@FindBy(xpath = "//input[@id='UIFormControl-31']")
	WebElement email;

	@FindBy(xpath = "//input[@id='UIFormControl-33']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='UIFormControl-37']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='UIFormControl-45']")
	WebElement jobTitle;

	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement createContactSecondButton;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String emailVal, String firstname, String lastname, String jobtitle) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createContactButton));
		createContactButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailVal);

		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstname);

		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastname);

		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobtitle);

		wait.until(ExpectedConditions.elementToBeClickable(createContactSecondButton));
		createContactSecondButton.click();
	}
}
