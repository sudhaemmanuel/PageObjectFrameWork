package com.salesforce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//li[@id='home_Tab']")
	WebElement hometablabel;
	
	@FindBy(id = "userNav")
	WebElement userNavButton;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	public HomePage(){
	PageFactory.initElements(driver, this);	
	
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	  }
	
	public void Logout() {
		userNavButton.click();
	    logout.click();
		
	}
}
