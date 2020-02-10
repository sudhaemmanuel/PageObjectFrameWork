package com.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.base.TestBase;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	public HomePageTest(){
	super();
	}
	
	@BeforeMethod
	public void setup() {
	initialization();
	loginPage = new LoginPage();
	homePage =loginPage.login(prop.getProperty("UN"), prop.getProperty("PW"));
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, " Home ~ Salesforce - Developer Edition");
	}
	
	@Test
	public void LogoutTest() {
		homePage.Logout();
	}
	
	@Test
	public void verifyPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	
	}
}
