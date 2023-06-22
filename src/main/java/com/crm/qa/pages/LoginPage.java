package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

		//Page Factory - OR:
		@FindBy(name ="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//font[contains(text(),'crm')]")
		//@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
		WebElement crmLogo;
		
		@FindBy(xpath = "//span[contains(text(),'Log In')]")
		//@FindBy(xpath = "//a[contains(text(),'Login')]")
		WebElement loginButton;
		
		
		//Actions:
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateCRMImage() {
			return crmLogo.isDisplayed();
}
		
		public HomePage login(String un, String pwd) throws IOException, InterruptedException {
			Thread.sleep(1000);
			loginButton.click();
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();
		}
		
	}