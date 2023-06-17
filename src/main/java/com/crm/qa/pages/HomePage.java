package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
		
	}

	//@FindBy(xpath = "//span[contains(text(),'Bhargav Bhayani')]")
	//@FindBy(xpath = "//div[contains(text(),'Contacts activity stream')]")
	//@FindBy(className = "user-display")
	@FindBy(css = ".right.menu>span:first-of-type")
	WebElement userNameLabel;
	
	@FindBy(css= ".users.icon")
	WebElement contactsLink;
	
	@FindBy(xpath= "//body/div[@id='ui']/div[@class='ui fluid container']/div[@id='main-nav']/div[3]/button[1]/i[1]")
	WebElement newContactLink;
	
	@FindBy(linkText = "Deals")
	WebElement dealsLink;
	
	@FindBy(linkText = "Tasks")
	WebElement tasksLink;
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyCorrectUserName() {
		
		String userNameText = userNameLabel.getText();
		System.out.println(userNameText);
		return userNameText;
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() throws IOException {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
		
}