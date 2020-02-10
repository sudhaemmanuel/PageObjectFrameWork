package com.salesforce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.base.TestBase;

public class LoginPage extends TestBase {
	HomePage homePage;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath= "//input[@id='Login']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//div[@id = 'error']")
	WebElement errormess;
	
	@FindBy(id = "rememberUn")
	WebElement remembermebutton;
	
		
	public LoginPage() {
	PageFactory.initElements(driver,this);	
		
	}
	
	
	// Actions
	  public String ValidateLoginErrorMessage(String UN) {
	  username.sendKeys(UN);
	  password.clear();
	  loginbutton.click();
	  return errormess.getText().trim();
	   
	   }
	   
	  public HomePage login(String UN, String PW) {
	  username.sendKeys(UN);
	  password.sendKeys(PW);;
	  loginbutton.click();
	  return new HomePage();
	   }
	   
	  public void CheckRememberMe() {
	  if (remembermebutton.isDisplayed()) {
	  remembermebutton.click(); 
	    } 
	  }
	  
	  
	
	}

