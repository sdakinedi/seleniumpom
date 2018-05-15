package main.java;

import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumUtils {

	WebDriver driver;
	
	
	
	public WebDriver launchBrowser(String browser) throws Exception {

		try {
			switch(browser.toUpperCase()) {
			case "FIREFOX" : {
				
				String userDirectory = System.getProperty("user.dir");
				

				System.setProperty("webdriver.gecko.driver", userDirectory + "\\lib"+"\\geckodriver.exe");
				
				
			//	System.setProperty("webdriver.gecko.driver","/SeleniumWebDr_POM_Beta/lib/geckodriver.exe");

				DesiredCapabilities cap = DesiredCapabilities.firefox();

				FirefoxProfile firefoxProfile = new FirefoxProfile();

				firefoxProfile.setAcceptUntrustedCertificates(true);
				firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false); 
				firefoxProfile.setPreference("browser.download.dir", "C:\\downloads"); 
				firefoxProfile.setPreference("browser.download.downloadDir","C:\\downloads"); 
				firefoxProfile.setPreference("browser.download.defaultFolder","C:\\downloads"); 
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/anytext ,text/plain,text/html,application/plain,text/xml" );
				cap = DesiredCapabilities.firefox();
				cap.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

				cap.setCapability("marionette", firefoxProfile);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				this.driver = new FirefoxDriver();


			}; break;
			case "IE" : {

				

		//		System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer.exe");

				String userDirectory = System.getProperty("user.dir");
		
System.out.println("IE Driver .exe path is: " + userDirectory + "\\lib"+"\\IEDriverServer.exe");				
				
				System.setProperty("webdriver.ie.driver", userDirectory + "\\lib"+"\\IEDriverServer.exe");

				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();	
				cap.setCapability("ignoreZoomSetting", true);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				cap.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 10000);
				cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				

				this.driver = new InternetExplorerDriver(cap);


			}; break;
			case "CHROME" : {

			

				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");

				String dowloadFilePath = "C:\\downloads";


				Map<String, Object> preferences = new Hashtable<String, Object>();
				preferences.put("profile.default_content_settings.popups", 0);
				preferences.put("download.prompt_for_download", "false");
				preferences.put("download.default_directory", dowloadFilePath);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", preferences);

				DesiredCapabilities cap = DesiredCapabilities.chrome();	
				//	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				cap.setCapability(CapabilityType.SUPPORTS_ALERTS, true);

				cap.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, true);

				this.driver = new ChromeDriver(cap);

			}; break;
			default : 
				System.out.println(" Please provide valid list of browsers FIREFOX | IE | CHROME");

			}
		} catch(Exception e) {
			System.out.println(" launching browser has failed with exception: " + e.getMessage());
			//	takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw new Exception(e);
		} finally {

		}
		return this.driver;
	}

	
	
	
	
	
}