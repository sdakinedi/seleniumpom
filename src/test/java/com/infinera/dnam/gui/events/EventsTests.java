package test.java.com.infinera.dnam.gui.events;

import static org.testng.Reporter.log;

import java.io.IOException;

import org.sikuli.basics.Settings;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import main.java.CommonUtils;
;

@Listeners({ com.infinera.dnam.gui.reports.CustomListener.class, com.infinera.dnam.gui.reports.CustomListener2.class})
@Test(groups= {"Events"})

public class EventsTests {

	CommonUtils utils = new CommonUtils();

	@Test
	public void test21_Verify_EventsReportingAndFilters_ForOCM8P_Network_Context() throws IOException, FindFailed, InterruptedException {


		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());

			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");


			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Network");	
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"NetworkDomain.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Event Log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Alarms Log
			s2.type(Keys.RIGHT);
			s2.type(Keys.ENTER);

			log("Step 3. Launch the  Event Log from Network context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(3 * 1000);
			log("click on the event in the event log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

			log("Step 5. Verify below filters are available.\n" + 
					"     Node , Unit , Event,  User");
			//s2.hover(libDir+"Event_Filters_Node_Unit_User.png");

			log("Step 6. Verify filter functionality is proper with respect to OCM8P, Verify the date filters also works properly.");

			s2.find(libDir+"Event_Filters_Last_30_Days.png");
			s2.click();
			Thread.sleep(1 * 1000);
			s2.find(libDir+"Event_Filters_From.png");
			s2.click();
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Event_Filters_From_Enter_Date.png","01/01/18");
			Thread.sleep(3 * 1000);
			s2.find(libDir+"Event_Filters_Interval_From.png");
			s2.click();

			s2.find(libDir+"Event_Filters_Hide_Filters.png");
			s2.click();

			s2.click(libDir+"Event_Filters_Show_Filters.png");

			s2.type(libDir+"Event_Refresh_Rate.png","1000");

			s2.click(libDir+"RefreshButton.png");

			Thread.sleep(1 * 1000);

			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());

			throw new AssertionError(e);
		} 
	}


	@Test(enabled=false)
	public void test22_Verify_ExportOfEvents_ForOCM8P_Network_Context() throws IOException, FindFailed, InterruptedException {



		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			//Region s2 = new Screen();


			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Network");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"NetworkDomain.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Event Log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Alarms Log
			s2.type(Keys.RIGHT);
			s2.type(Keys.ENTER);

			log("Step 3. Launch the  Event Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the event in the event log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

			log("Step 5. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Events Log");

			s2.click(libDir+"Button_ok.png");

			Thread.sleep( 2 * 1000);
			try {
				s2.find(libDir+"Util_File_Already_Exists.png");
				Thread.sleep(3 * 1000);
				s2.click(libDir+"Button_yes.png");
			} catch(FindFailed ff) {
				System.out.println("No Previous Entries of TSV file present. So Saving a new copy...");
			}

			Thread.sleep(1 * 1000);
			s2.click(libDir+"Close_Window_X.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			App.focus("Event Log");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			throw new AssertionError(e);
		} 
	}


	@Test(enabled=false)
	public void test15_Verify_EventsReportingAndFilters_ForOCM8P_Subnet_Context() throws IOException, FindFailed, InterruptedException {

		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			String libDir = dir + "\\lib\\";

			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Subnet1");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Event logy By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			log("Step 3. Launch the  Event Log from Network context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the event in the event log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

			log("Step 5. Verify below filters are available.\n" + 
					"     Node , Unit , Event,  User");
			//s2.hover(libDir+"Event_Filters_Node_Unit_User.png");

			log("Step 6. Verify filter functionality is proper with respect to OCM8P, Verify the date filters also works properly.");

			s2.find(libDir+"Event_Filters_Last_30_Days.png");
			s2.click();
			Thread.sleep(1 * 1000);
			s2.find(libDir+"Event_Filters_From.png");
			s2.click();
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Event_Filters_From_Enter_Date.png","01/01/18");
			Thread.sleep(3 * 1000);
			s2.find(libDir+"Event_Filters_Interval_From.png");
			s2.click();

			s2.find(libDir+"Event_Filters_Hide_Filters.png");
			s2.click();

			s2.click(libDir+"Event_Filters_Show_Filters.png");

			s2.type(libDir+"Event_Refresh_Rate.png","1000");

			s2.click(libDir+"RefreshButton.png");

			Thread.sleep(1 * 1000);

			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());

			throw new AssertionError(e);
		} 
	}


	@Test(enabled=false)
	public void test16_Verify_ExportOfEvents_ForOCM8P_Subnet_Context() throws IOException, FindFailed, InterruptedException {


		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			// right click on Naveen subnetwork
			//	s2.find(libDir+"nodeIp_10_210_130_170.png");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Subnet1");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Event log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);
			log("Step 3. Launch the  Event Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the event in the event log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

			log("Step 5. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Events Log");

			s2.click(libDir+"Button_ok.png");

			Thread.sleep( 2 * 1000);
			try {
				s2.find(libDir+"Util_File_Already_Exists.png");
				Thread.sleep(3 * 1000);
				s2.click(libDir+"Button_yes.png");
			} catch(FindFailed ff) {
				System.out.println("No Previous Entries of TSV file present. So Saving a new copy...");
			}


			Thread.sleep(1 * 1000);
			s2.click(libDir+"Close_Window_X.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			App.focus("Event Log");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());

			throw new AssertionError(e);
		} 
	}


	@Test(enabled=false)
	public void test07_Verify_EventsReportingAndFilters_ForOCM8P_NE_Context() throws IOException, FindFailed, InterruptedException {

		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);
			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();
			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"10.210.130.171");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"nodeIp_10_210_130_171_Name.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Event Log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			// click on Alarm & Event log
			s2.type(Keys.DOWN);
			s2.type(Keys.ENTER);
			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Event Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the event in the event log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

			log("Step 5. Verify below filters are available.\n" + 
					"     Node , Unit , Event,  User");
			//		s2.hover(libDir+"Event_Filters_Node_Unit_User.png");

			log("Step 6. Verify filter functionality is proper with respect to OCM8P, Verify the date filters also works properly.");

			s2.find(libDir+"Event_Filters_Last_30_Days.png");
			s2.click();
			Thread.sleep(1 * 1000);
			s2.find(libDir+"Event_Filters_From.png");
			s2.click();
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Event_Filters_From_Enter_Date.png","01/01/18");
			Thread.sleep(3 * 1000);
			s2.find(libDir+"Event_Filters_Interval_From.png");
			s2.click();

			s2.find(libDir+"Event_Filters_Hide_Filters.png");
			s2.click();

			s2.click(libDir+"Event_Filters_Show_Filters.png");

			s2.type(libDir+"Event_Refresh_Rate.png","1000");

			s2.click(libDir+"RefreshButton.png");

			Thread.sleep(1 * 1000);

			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			
			throw new AssertionError(e);
		} 
	}



	@Test(enabled=false)
	public void test08_Verify_ExportOfEvents_ForOCM8P_NE_Context() throws IOException, FindFailed, InterruptedException {


		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");


			System.out.println(dir);

			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			//Region s2 = new Screen();

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			// right click on Naveen subnetwork
			//	s2.find(libDir+"nodeIp_10_210_130_170.png");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"10.210.130.171");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"nodeIp_10_210_130_171_Name.png");
			s2.rightClick();
			s2.hover();
			
			log(" Go to the Event Log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			// click on Alarm & Event log

			s2.type(Keys.DOWN);
			s2.type(Keys.ENTER);
			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Event Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the event in the event log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

			log("Step 5. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Events Log");

			s2.click(libDir+"Button_ok.png");

			Thread.sleep( 2 * 1000);
			try {
				s2.find(libDir+"Util_File_Already_Exists.png");
				Thread.sleep(3 * 1000);
				s2.click(libDir+"Button_yes.png");
			} catch(FindFailed ff) {
				System.out.println("No Previous Entries of TSV file present. So Saving a new copy...");
			}

			Thread.sleep(1 * 1000);
			s2.click(libDir+"Close_Window_X.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			App.focus("Event Log");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			
			throw new AssertionError(e);
		} 
	}



}
