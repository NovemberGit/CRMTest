package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	public ContactsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//span[contains(@class,'selectable')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//th[contains(text(),'Category')]")
	WebElement categoryLabel;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement firstName;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[1]/div[2]/div[1]/div[1]/input[1]")
	WebElement lastName;
	
	
	@FindBy(xpath =  "//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement company;
	
	
	@FindBy(xpath=  "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	Actions actions = new Actions(driver);

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName() throws InterruptedException{
		actions.moveToElement(categoryLabel).build().perform();
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='ui fitted read-only checkbox']"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public void createNewContact(String ftName, String ltName, String comp) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}

}
