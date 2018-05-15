package com.infinera.dnam.gui.pages;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.CommonUtils;


public class LoginPage {

	WebDriver driver;

	URL url;

	String browser;


	{
		CommonUtils utils = new CommonUtils();

		try {
			utils.loadProperties();

			browser = utils.getProperty("browser");

			String hostname = utils.getProperty("ipORlocalhost");

			url = new URL("https://" + hostname);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@FindBy(how=How.ID, using="userName")
	WebElement userName;
	@FindBy(how=How.ID, using="password")
	WebElement password;
	@FindBy(how=How.ID, using="loginButton")
	WebElement loginButton;

	public LoginPage(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		driver.get(url.toString());
		Thread.sleep(2000);
		
		if("IE".equalsIgnoreCase(browser)) {
			driver.findElement(By.id("overridelink")).click();
			Thread.sleep(1 * 1000);
		}

		// use PageFactory to effectively initialize the elements
		PageFactory.initElements(driver,this);
		Thread.sleep(1 * 1000);
	}


	/*
	 * 
	 * 
	 * SERVICES OFFERED by the LOGINPAGE
	 * login() -> to Login to the page with credentials
	 * 
	 */


	public void login() throws StaleElementReferenceException {

		userName.sendKeys("root");
		password.sendKeys("root");
		loginButton.click();
	}

	
	public void dynamicLogin(String uname, String pswd) {
		WebElement userName = new WebDriverWait(this.driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
		WebElement password = new WebDriverWait(this.driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		WebElement loginButton = new WebDriverWait(this.driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("loginButton")));
		
		userName.sendKeys(uname);
		password.sendKeys(pswd);
		loginButton.click();
		
		
		
	}
	
	
}
