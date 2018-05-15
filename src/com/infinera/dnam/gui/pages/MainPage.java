package com.infinera.dnam.gui.pages;

import java.net.URL;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	WebDriver driver;

	URL url;

	String browser;
	
	@FindBy(how=How.ID, using="main_logo")
	WebElement infineraImageLeftTop;
	@FindBy(how=How.ID, using="brandTextName")
	WebElement password;
	@FindBy(how=How.ID, using="notifications_a")
	WebElement notificationsTab;
	
	@FindBy(how=How.XPATH, using="//span[@class='alarmLinkText criticalTop']")
	WebElement alarmsCountTab;
	@FindBy(how=How.XPATH, using="//span[@class='saveLink']")
	WebElement saveTab;
	@FindBy(how=How.ID, using="logout_a")
	WebElement logoutButton;
	
	// Alarms and Events table
	
	@FindBy(how=How.ID, using="alarmsandevents_Alarms_Current")
	WebElement alarmsEventsTab_Alarms;
	@FindBy(how=How.ID, using="alarmsandevents_Events_log")
	WebElement alarmsEventsTab_Events;
	
	@FindBy(how=How.ID, using="logout_dialog")
	WebElement logoutDialog;
	@FindBy(how=How.ID, using="logout_dialog_saveRunning")
	WebElement saveConfig;
	@FindBy(how=How.ID, using="logout_dialog_logMeOut")
	WebElement logoutAnyway;
	@FindBy(how=How.ID, using="logout_dialog_cancelButton")
	WebElement cancel;
	
	
	//logout dialog
	
	
	
	public MainPage(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		// use PageFactory to effectively initialize the elements
		PageFactory.initElements(driver,this);

	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public String getUrl() {
		return driver.getCurrentUrl();
		
	}
	
	
	
	/*
	 * 
	 * 
	 * SERVICES OFFERED by the MAINPAGE
	 * 
	 * clickOnAlarmsCountTab()
	 * 
	 */
	
	public void clickOnAlarmsCountTab() {

		alarmsCountTab.click();
		
	}
	
	
	public void logoutAnyway() throws NoSuchElementException {
		logoutButton.click();
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(alert.getText());
		*/
		
	}
	
	
	
	
	
	
}
