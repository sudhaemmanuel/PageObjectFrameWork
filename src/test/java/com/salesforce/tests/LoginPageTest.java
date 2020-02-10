package com.salesforce.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.salesforce.base.TestBase;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage  homePage;
	
	public LoginPageTest(){
		super();
		
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority = 1)
	public void validateLoginErrorMessageTest() {
	String errmess =loginPage.ValidateLoginErrorMessage(prop.getProperty("UN"));
	Assert.assertEquals(errmess, "Please enter your password.");	
	}
	
	@Test(priority = 2)
	public void LoginTest() {
	homePage =loginPage.login(prop.getProperty("UN"), prop.getProperty("PW"));
	
	}
	@Test(priority =3)
	public void checkRememberMeTest() {
		loginPage.CheckRememberMe();
		LoginTest();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	
}
