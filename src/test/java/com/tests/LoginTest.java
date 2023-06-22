package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;

public class LoginTest {
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Work\\Project\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("launching browseer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		log.info("entering application URL");
		log.warn("This is just a warning");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	@Test(priority=1)
	public void freeCrmTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is ---> " +title);
		Assert.assertEquals(title, "#1 Free CRM App for every business customer relationship management cloud");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean b = driver.findElement(By.xpath("//font[contains(text(),'crm')]")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
	
	
	}
}
