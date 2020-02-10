package com.salesforce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\sudha\\eclipse-workspace2\\Java Session\\SalesForceTest\\src\\main\\java\\com\\salesforce\\config\\config.properties");
		prop.load(fs);
		
		}
	  catch (FileNotFoundException e) {
	  e.printStackTrace();
	}
	  catch (IOException e) {
	  e.printStackTrace();
	}
   }	
	
	public static void initialization() {
	String browsername = prop.getProperty("browser");	
	if (browsername.equals("chrome")) {		
		//System.setProperty("webdriver.chrome.driver", " C:\\Users\\sudha\\Common\\chromedriver.exe");
		driver= new ChromeDriver();	
	}
	if (browsername.equals("firefox")) {		
		System.setProperty("webdriver.chrome.driver", " C:\\Users\\sudha\\Common\\geckodriver.exe");
		driver= new FirefoxDriver();	
	}	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
  }

}
