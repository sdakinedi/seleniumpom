package main.java;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.sikuli.hotkey.Keys;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class CommonUtils {


	String dir = System.getProperty("user.dir");
	String libDir = dir + "\\lib\\";

	
	Properties prop = new Properties();

	public void loadProperties() throws IOException {
	
		String userDirectory = System.getProperty("user.dir");
		
		
		String propFileName = userDirectory + "\\properties\\" + "sys.properties";
		
		FileReader reader= new FileReader(propFileName);
	
	
		prop.load(reader);
		
		
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key) ;
	}
	
	
	public void logout() throws FindFailed {

		try {
			Region s2 = new Screen();

			s2.find(libDir+"FileMenu.png");
			s2.click();
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.ENTER);

			s2.click(libDir+"Close_Window.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void login() throws FindFailed, InterruptedException {

		Region s2 = new Screen();

		App.focus("Infinera DNA-M Client");




		try {
			s2.find(libDir+"loginWindow_Title.png");
			System.out.println("Login Window Found...");

			App.focus("Login to the Server");

			s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type(Keys.ENTER);

			Thread.sleep(15 * 1000);

		} catch (Exception e) {
			s2.click(libDir+"FileMenu.png");
			s2.type(Keys.DOWN);
			s2.type(Keys.ENTER);
			this.login();
		}
	}


}
