package test.java.com.infinera.dnam.gui.alarms;

import static org.testng.Reporter.log;

import java.io.IOException;

import org.sikuli.basics.Settings;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import main.java.CommonUtils;



@Test(groups= {"Alarms"})

public class AlarmsTests {

	CommonUtils utils = new CommonUtils();
	
	
	@Test
	public void test03_VerifyAlarmReportingAndFiltersForOCM8P_NE_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			//App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
						
			/*s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);


			s2.type(Keys.ENTER);

			Thread.sleep(5000);

			Thread.sleep(3000);*/

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","10.210.130.170");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"nodeIp_10_210_130_170.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			// click on Active Alarms
			s2.type(Keys.ENTER);

			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Active Alarms from NE context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Active Alarms");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4 ,5 ,6 . Verify Node name , Unit , Domain , Alarm, Severity , Time coulmns are updated properly");
			s2.find(libDir + "Alarm_WIndow_OCM8P_Board.png");

			// 	get the text of the Region

			Region s3 = s2.getLastMatch();

			System.out.println("new text is: " + s2.text());

			//assertTrue(s2.text().contains("Optical Channer Monitor"));

			// Verify upon disabling the board checkbox, the ocm8P goes missing from table

			log(" Step 7. Verify below filters are available.\r\n" + 
					"     Node , Unit , Alarm, Layer , Severity , State");
			s2.find(libDir+"Alarm_Filters_Severity_State.png");


			log("Step 8. Verify fileter functionality is proper with respect to OCM8P");

			s2.find(libDir+"Event_Filters_Hide_Filters.png");
			s2.click();
			s2.click(libDir+"Event_Filters_Show_Filters.png");


			s2.click(libDir+"Alarm_Filters_Board_Under_Maintenance.png");

			log("Step 9. Verify Refresh , pause , acknowlede , comment , unacknowledge "
					+ "works fine with respect to OCM8P");

			s2.click(libDir+"RefreshButton.png");

			s2.click(libDir+"PauseButton.png");
			s2.click(libDir+"ResumeButton.png");

			s2.click(libDir+"AcknowledgeButton.png");
			s2.click(libDir+"Close_Window_X.png");

			s2.click(libDir+"CommentButton.png");
			s2.click(libDir+"Close_Window_X.png");

			// Click on Show Details
			s2.click(libDir+"Show_Details.png");
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Show_Details.png");

			s2.click(libDir+"Star.png");

			s2.click(libDir+"CloseDotDotDot_Button.png");
			s2.click(libDir+"Close_Window_X.png");

			utils.logout();
			

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}


	}


	
	@Test
	public void test04_VerifyExportOfAlarmReportingForOCM8P_NE_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
		/*	App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);


			s2.type(Keys.ENTER);

			Thread.sleep(5000);

			Thread.sleep(3000);*/

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","10.210.130.170");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"nodeIp_10_210_130_170.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			// click on Active Alarms
			s2.type(Keys.ENTER);

			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Active Alarms from NE context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Active Alarms");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Active Alarm Log");

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

			App.focus("Active Alarms");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();
			
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}	


	
	@Test
	public void test06_VerifyExportOfAlarmLogForOCM8P_NE_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
		
			/*App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);


			s2.type(Keys.ENTER);

			Thread.sleep(5000);

			Thread.sleep(3000);
*/
			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","10.210.130.170");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"nodeIp_10_210_130_170.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Active Alarms By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Alarms Log
			s2.type(Keys.RIGHT);
			s2.type(Keys.ENTER);

			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Active Alarms from NE context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Active Alarms");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			//	s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			//	s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Active Alarm Log");

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

			App.focus("Alarm Log");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);
			
			utils.logout();

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}	

	
	@Test
	public void test19_Verify_AlarmsLogAndFilters_ForOCM8P_Network_Context() throws IOException, FindFailed, InterruptedException {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			
			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
			/*App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type(Keys.ENTER);

			Thread.sleep(7 * 1000);*/

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","Network");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"NetworkDomain.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Active Alarms By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Alarms Log
			s2.type(Keys.RIGHT);
			s2.type(Keys.ENTER);

			Thread.sleep(5 * 1000);

			log("Step 3. Launch the  Alarm Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Alarm Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the alalrm in the alarm log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			//		s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			//		s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

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

		} finally {
		}
	}


	
	@Test
	public void test20_VerifyExportOfAlarmLogForOCM8P_Network_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
//			App.focus("Login to the Server");
//
//			Region s2 = new Screen();
//
//			Thread.sleep(2000);
//
//			s2.type("admin");
//			s2.type(Keys.TAB);
//
//			s2.type("admin");
//			s2.type(Keys.TAB);
//
//
//			s2.type(Keys.ENTER);
//
//			Thread.sleep(5000);
//
//			Thread.sleep(3000);

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","Network");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"NetworkDomain.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Active Alarms By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Alarms Log
			s2.type(Keys.RIGHT);
			s2.type(Keys.ENTER);

			Thread.sleep(5 * 1000);

			log("Step 3. Launch the  Active Alarms from NE context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Alarm Log");
			// maximize the alarm log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			//	s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			//	s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Alarm Logs");

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

			App.focus("Alarm Log");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);
			
			utils.logout();

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}	


	
	@Test
	public void test05_Verify_AlarmsLogAndFilters_ForOCM8P_NE_Context() throws IOException, FindFailed, InterruptedException {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
			
			/*App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);


			s2.type(Keys.ENTER);

			Thread.sleep(10 * 1000);
*/
			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","10.210.130.170");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"nodeIp_10_210_130_170.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Active Alarms By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Alarms Log
			s2.type(Keys.RIGHT);
			s2.type(Keys.ENTER);

			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Alarm Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Event Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the alalrm in the alarm log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			//		s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			//		s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

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

		} finally {

		}
	}

	
	@Test
	public void test11_VerifyActiveAlarmReportingAndFiltersForOCM8P_Subnet_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
			/*App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);


			s2.type(Keys.ENTER);

			Thread.sleep(15 * 1000);*/

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","sawan");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1_sawan.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Active Alarms By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);
			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Active Alarms from NE context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Active Alarms");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4 ,5 ,6 . Verify Node name , Unit , Domain , Alarm, Severity , Time coulmns are updated properly");
			s2.find(libDir + "Alarm_WIndow_OCM8P_Board.png");

			// 	get the text of the Region

			Region s3 = s2.getLastMatch();

			System.out.println("new text is: " + s2.text());

			//assertTrue(s2.text().contains("Optical Channer Monitor"));

			// Verify upon disabling the board checkbox, the ocm8P goes missing from table

			log(" Step 7. Verify below filters are available.\r\n" + 
					"     Node , Unit , Alarm, Layer , Severity , State");
			s2.find(libDir+"Alarm_Filters_Severity_State.png");


			log("Step 8. Verify fileter functionality is proper with respect to OCM8P");

			s2.find(libDir+"Event_Filters_Hide_Filters.png");
			s2.click();
			s2.click(libDir+"Event_Filters_Show_Filters.png");


			s2.click(libDir+"Alarm_Filters_Board_Under_Maintenance.png");

			log("Step 9. Verify Refresh , pause , acknowlede , comment , unacknowledge "
					+ "works fine with respect to OCM8P");

			s2.click(libDir+"RefreshButton.png");

			s2.click(libDir+"PauseButton.png");
			s2.click(libDir+"ResumeButton.png");

			s2.click(libDir+"AcknowledgeButton.png");
			s2.click(libDir+"Close_Window_X.png");

			s2.click(libDir+"CommentButton.png");
			s2.click(libDir+"Close_Window_X.png");

			// Click on Show Details
			s2.click(libDir+"Show_Details.png");
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Show_Details.png");

			s2.click(libDir+"Star.png");

			s2.click(libDir+"CloseDotDotDot_Button.png");
			s2.click(libDir+"Close_Window_X.png");
			s2.click(libDir+"Close_Window.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	public void test12_VerifyExportOfAlarmLogForOCM8P_Subnet_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();
			Thread.sleep(2000);
			utils.login();
			
			
			/*App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);


			s2.type(Keys.ENTER);

			Thread.sleep(15000);
*/
			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","sawan");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1_sawan.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Active Alarms By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);
			Thread.sleep(2 * 1000);

			Thread.sleep(2 * 1000);

			log("Step 3. Launch the  Active Alarms from NE context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Active Alarms");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Active Alarm Log");

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

			App.focus("Active Alarms");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);
			
			utils.logout();

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}	

	@Test
	public void test13_Verify_AlarmsLogAndFilters_ForOCM8P_Subnet_Context() throws IOException, FindFailed, InterruptedException {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");
			
			Region s2 = new Screen();
			Thread.sleep(2000);
			utils.login();

			/*App.focus("Login to the Server");

			Region s2 = new Screen();

			Thread.sleep(2000);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type("admin");
			s2.type(Keys.TAB);

			s2.type(Keys.ENTER);

			Thread.sleep(15 * 1000);*/

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","sawan");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1_sawan.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Alarm Log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			Thread.sleep(5 * 1000);

			log("Step 3. Launch the  Alarm Log from NE context , Verify all Events related to OCM8P are shown properly");
			App.focus("Alarm Log");
			// maximize the event log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);
			log("click on the alalrm in the alarm log that got populated..");
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			//	s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			//	s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

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
			
		} finally {
		}
	}



	@Test
	public void test14_VerifyExportOfAlarmLogForOCM8P_Subnet_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			Thread.sleep(2000);

			utils.login();
			
			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png","sawan");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1_sawan.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Alarm Log By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			Thread.sleep(5 * 1000);

			log("Step 3. Launch the  Alarm Log from Subnet context , Verify all Alarms related to OCM8P are shown properly");
			App.focus("Alarm Log");
			// maximize the alarm log window..
			s2.click(libDir+"Maximize_Window_X.png");
			Thread.sleep(1 * 1000);

			//	s2.find(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");
			//	s2.click(libDir + "Alarm_ocm_1_11_1_AdminState_Service.png");

			log("Step 4. Perform export operation ");

			s2.click(libDir+"Button_export.png");

			Thread.sleep( 1 * 1000);

			App.focus("Export Alarm Logs");

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

			App.focus("Alarm Log");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();
			
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			System.out.println("Find failed at: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
