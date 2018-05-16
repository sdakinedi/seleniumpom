package test.java.com.infinera.dnam.gui.inventory;

import static org.testng.Assert.assertNull;
import static org.testng.Reporter.*;

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


@Listeners({ com.infinera.dnam.gui.reports.CustomListener.class})
@Test(groups= {"Inventory"})

public class InventoryTests {
	
	
	CommonUtils utils = new CommonUtils();
	
	@Test
	public void test01_VerifyInventoryManagerAndFiltersForOCM8P_NE_Context() throws IOException, FindFailed, InterruptedException {

		log("Name of the method executing is:" + 
				Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println("Name of the method executing is:" + 
						Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Screen s = new Screen();

		try {


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			String libDir = dir + "\\lib\\";

			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			log("Step 2. Verify if the node is found....");

			App.focus("Infinera DNA-M Client");
	
			s2.find(libDir+"Find_String.png");	
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"10.210.130.171");
			Thread.sleep(1000);
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.find(libDir+"nodeIp_10_210_130_171_Name.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Inventory
			s2.type(Keys.ENTER);

			Thread.sleep(2 * 1000);

			App.focus("Node Inventory");
		

			log(" Step 3. Validate if the OCM8P board is present in the inventory list...");

			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");


			// 	get the text of the Region

			Region s3 = s2.getLastMatch();

			System.out.println("new text is: " + s2.text());

			//assertTrue(s2.text().contains("Optical Channer Monitor"));

			// Verify upon disabling the board checkbox, the ocm8P goes missing from table

			log(" Step 4. Disable the Boards Checkbox to see OCM8P is missing ...");
			s2.find(libDir+"Boards_checkbox_Node_Inventory.png");

			s2.click(); // this will uncheck the Boards button

			// verify if the OCMP8P is gone missing..

			try {
				s2.find(libDir + "OCM8P_description.png");
				assertNull(s2.find(s2.find(libDir + "OCM8P_description.png")));
			} catch(FindFailed ff) {
				log("Board OCM8P Successfully went missing from the table...");
			}

			// enable again
			log(" Step 5. Enable the Boards Checkbox to see OCM8P is visible again ...");
			s2.click(libDir+"Boards_checkbox_Node_Inventory.png");

			Thread.sleep(1 * 1000);

			log(" Step 5.a. Enable the Show details Checkbox to see OCM8P is visible again ...");
			s2.click(libDir+"Show_Details_checkbox.png");

		
			// disable again
			s2.click(libDir+"Show_Details_checkbox.png");


			log(" Step 6. Verify the buttons hide, find, previous and next are available...");
			s2.find(libDir+"Buttons_hide_find_previous_next.png");

			log(" Step 6.1. Verify the buttons export, close, refresh are available...");
			s2.find(libDir+"Buttons_refresh_export_close_find.png");

			// find columns
			log(" Step 7. Verify all the columns are present in the inventory table...");
			s2.find(libDir+"Columns_All_Node_Inventory_table.png");

			// Sort the columns using description column and check if they are sorted...

			log(" Step 8. Sort the columns based on one column name.. description..");
			s2.click(libDir+"Columns_Description.png");

			log(" Step 8.1. Verify OCM8P is still seen after sorting...");
			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");

			App.focus("Node Inventory");

			s2.type(libDir+"Find_Inventory.png", "OCM8P");
			s2.type(Keys.ENTER);


			s2.find(libDir+"RefreshButton.png");
			s2.click();
			

			log(" Step 9. Verify OCM8P entry is intact after Refresh...");

			s2.find(libDir + "OCM8P_description.png");
			s2.click(libDir + "OCM8P_description.png");

			log("Close the window..");
			s2.click(libDir+"Close_Window.png");

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

	
	@Test
	public void test02_VerifyInventoryManagerExportForOCM8P_NE_Context() throws IOException, FindFailed, InterruptedException {

		
		Screen s = new Screen();

		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Name of the method executing is:" + 
							Thread.currentThread().getStackTrace()[1].getMethodName());

			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


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
			s2.find(libDir+"nodeIp_10_210_130_171_Name.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			// click on Inventory
			s2.type(Keys.ENTER);

			Thread.sleep(2 * 1000);

			App.focus("Node Inventory");

		

			log(" Step 3. Validate if the OCM8P board is present in the inventory list...");

			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");

			log(" Step 4. Perform export operation...");

			s2.find(libDir+"Button_export.png");
			s2.click();

			Thread.sleep(2 * 1000);
			App.focus("Export Inventory");
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

			//s2.click(libDir+"Button_ok_InfoDialog.png");

			Thread.sleep(1 * 1000);

			s2.click(libDir+"Util_Search_OCM8P_In_TSV.png");
			
			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);
			
			utils.logout();

		} catch(Exception e) {
			throw new AssertionError(e);
		}

	}
	
	
	
	
	@Test
	public void test17_VerifyInventoryManagerAndFiltersForOCM8P_Network_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Name of the method executing is:" + 
							Thread.currentThread().getStackTrace()[1].getMethodName());
			
			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			//	s2.find(libDir+"nodeIp_10_210_130_170.png");
		
			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Network");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"NetworkDomain.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			App.focus("Network Inventory");

			

			log(" Step 3. Validate if the OCM8P board is present in the inventory list...");

			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");


			// 	get the text of the Region

			Region s3 = s2.getLastMatch();

			System.out.println("new text is: " + s2.text());

			//assertTrue(s2.text().contains("Optical Channer Monitor"));

			// Verify upon disabling the board checkbox, the ocm8P goes missing from table

			log(" Step 4. Disable the Boards Checkbox to see OCM8P is missing ...");
			s2.find(libDir+"Boards_checkbox_Node_Inventory.png");

			s2.click(); // this will uncheck the Boards button

			// verify if the OCMP8P is gone missing..

			try {
				s2.find(libDir + "OCM8P_description.png");
				assertNull(s2.find(s2.find(libDir + "OCM8P_description.png")));
			} catch(FindFailed ff) {
				log("Board OCM8P Successfully went missing from the table...");
			}

			// enable again
			log(" Step 5. Enable the Boards Checkbox to see OCM8P is visible again ...");
			s2.click(libDir+"Boards_checkbox_Node_Inventory.png");

			Thread.sleep(1 * 1000);

			log(" Step 5.a. Enable the Show details Checkbox to see OCM8P is visible again ...");
			s2.click(libDir+"Show_Details_checkbox.png");

			

			// disable again
			s2.click(libDir+"Show_Details_checkbox.png");


			log(" Step 6. Verify the buttons hide, find, previous and next are available...");
			s2.find(libDir+"Buttons_hide_find_previous_next.png");

			log(" Step 6.1. Verify the buttons export, close, refresh are available...");
			s2.find(libDir+"Buttons_refresh_export_close_find.png");

			// find columns
			log(" Step 7. Verify all the columns are present in the inventory table...");
			s2.find(libDir+"Columns_All_Node_Inventory_table.png");

			// Sort the columns using description column and check if they are sorted...

			log(" Step 8. Sort the columns based on one column name.. description..");
			s2.click(libDir+"Columns_Description.png");

			log(" Step 8.1. Verify OCM8P is still seen after sorting...");

			App.focus("Network Inventory");

			s2.type(libDir+"Find_Inventory.png", "OCM8P");
			s2.type(Keys.ENTER);

			s2.find(libDir+"RefreshButton.png");
			s2.click();


			log(" Step 9. Verify OCM8P entry is intact after Refresh...");

			s2.find(libDir + "OCM8P_description.png");
			s2.click(libDir + "OCM8P_description.png");

			log("Close the window..");
			s2.click(libDir+"Close_Window.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);
			
			utils.logout();

		}  catch(Exception e) {
			throw new AssertionError(e);
		}


	}
	
	
	@Test
	public void test18_VerifyInventoryManagerExportForOCM8P_Network_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {
			
			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Name of the method executing is:" + 
							Thread.currentThread().getStackTrace()[1].getMethodName());


			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			//	s2.find(libDir+"nodeIp_10_210_130_170.png");
		
			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Network");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"NetworkDomain.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			App.focus("Network Inventory");

			

			log(" Step 3. Validate if the OCM8P board is present in the inventory list...");

			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");


			log("Step 4. Launch the  Network Inventory from Network context , Verify all Events related to OCM8P are shown properly");
			App.focus("Network Inventory");
			
			Thread.sleep(1 * 1000);
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			//		s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			//		s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

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
			App.focus("Network Inventory");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();
			
			
		} catch(Exception e) {
			throw new AssertionError(e);
		}


	}
	
	
	@Test
	public void test09_VerifyInventoryManagerAndFiltersForOCM8P_Subnet_Context() throws IOException, FindFailed {

		Screen s = new Screen();

		try {


			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Name of the method executing is:" + 
							Thread.currentThread().getStackTrace()[1].getMethodName());
			
			
			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();

			Pattern p = new Pattern(libDir + "HomePageTItle.png");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			log("Step 2. Verify is the node is found....");

			App.focus("Infinera DNA-M Client");

			//	s2.find(libDir+"nodeIp_10_210_130_170.png");
		
			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Subnet1");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			App.focus("Network Inventory");

		

			log(" Step 3. Validate if the OCM8P board is present in the inventory list...");

			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");

			// 	get the text of the Region

			Region s3 = s2.getLastMatch();

			System.out.println("new text is: " + s2.text());

			//assertTrue(s2.text().contains("Optical Channer Monitor"));

			// Verify upon disabling the board checkbox, the ocm8P goes missing from table

			log(" Step 4. Disable the Boards Checkbox to see OCM8P is missing ...");
			s2.find(libDir+"Boards_checkbox_Node_Inventory.png");

			s2.click(); // this will uncheck the Boards button

			// verify if the OCMP8P is gone missing..

			try {
				s2.find(libDir + "OCM8P_description.png");
				assertNull(s2.find(s2.find(libDir + "OCM8P_description.png")));
			} catch(FindFailed ff) {
				log("Board OCM8P Successfully went missing from the table...");
			}

			// enable again
			log(" Step 5. Enable the Boards Checkbox to see OCM8P is visible again ...");
			s2.click(libDir+"Boards_checkbox_Node_Inventory.png");

			Thread.sleep(1 * 1000);

			log(" Step 5.a. Enable the Show details Checkbox to see OCM8P is visible again ...");
			s2.click(libDir+"Show_Details_checkbox.png");

			

			// disable again
			s2.click(libDir+"Show_Details_checkbox.png");


			log(" Step 6. Verify the buttons hide, find, previous and next are available...");
			s2.find(libDir+"Buttons_hide_find_previous_next.png");

			log(" Step 6.1. Verify the buttons export, close, refresh are available...");
			s2.find(libDir+"Buttons_refresh_export_close_find.png");

			// find columns
			log(" Step 7. Verify all the columns are present in the inventory table...");
			s2.find(libDir+"Columns_All_Node_Inventory_table.png");

			// Sort the columns using description column and check if they are sorted...

			log(" Step 8. Sort the columns based on one column name.. description..");
			s2.click(libDir+"Columns_Description.png");

			log(" Step 8.1. Verify OCM8P is still seen after sorting...");

			App.focus("Network Inventory");

			s2.type(libDir+"Find_Inventory.png", "OCM8P");
			s2.type(Keys.ENTER);

			s2.find(libDir+"RefreshButton.png");
			s2.click();


			log(" Step 9. Verify OCM8P entry is intact after Refresh...");

			s2.find(libDir + "OCM8P_description.png");
			s2.click(libDir + "OCM8P_description.png");

			log("Close the window..");
			s2.click(libDir+"Close_Window.png");
			
			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();

		}  catch(Exception e) {
			throw new AssertionError(e);
		}


	}
	
	
	@Test
	public void test10_VerifyInventoryManagerExportForOCM8P_Subnet_Context() throws IOException, FindFailed, InterruptedException {

		Screen s = new Screen();

		try {

			log("Name of the method executing is:" + 
					Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println("Name of the method executing is:" + 
							Thread.currentThread().getStackTrace()[1].getMethodName());

			Settings.OcrTextSearch = true;
			Settings.OcrTextRead = true;


			String dir = System.getProperty("user.dir");

			System.out.println(dir);

			//	App.open("javaws C:\\Users\\sdakinedi\\Downloads\\jnlp_7.jnlp");


			String libDir = dir + "\\lib\\";


			log("Step 1. Login to the DNAM Client..");

			Region s2 = new Screen();

			utils.login();
			log("Step 2. Verify if the node is found....");

			App.focus("Infinera DNA-M Client");

			//	s2.find(libDir+"nodeIp_10_210_130_170.png");
		
			s2.type(libDir+"Find_String.png");
			s2.type(libDir+"Find_DropDown.png",Keys.ENTER+"Subnet1");
			s2.type(Keys.ENTER);
			Thread.sleep(1 * 1000);
			s2.click(libDir+"Subnet1.png");
			s2.rightClick();
			s2.hover();
			log(" Go to the Node Inventory By Right Clicking on the node...");
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.DOWN);
			s2.type(Keys.RIGHT);
			Thread.sleep(1 * 1000);
			s2.type(Keys.ENTER);

			App.focus("Network Inventory");

			

			log(" Step 3. Validate if the OCM8P board is present in the inventory list...");

			s2.find(libDir + "OCM8P_description.png");

			s2.click(libDir + "OCM8P_description.png");


			log("Step 4. Launch the  Network Inventory from Network context , Verify all Events related to OCM8P are shown properly");
			App.focus("Network Inventory");
			
			Thread.sleep(1 * 1000);
			log("Step 4. Verify Node name , Unit , Domain , Event,  Category, User , Time coulmns are updated properly");
			//		s2.click(libDir+"Event_ocm_1_11_1_AdminState_Up.png");
			Thread.sleep(2 * 1000);
			//		s2.click(libDir+"Event_ocm_1_11_2_AdminState_Service.png");

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
			App.focus("Network Inventory");

			Thread.sleep(2 * 1000);
			s2.click(libDir+"Button_close.png");

			App.focus("Infinera DNA-M Client");
			Thread.sleep(1 * 1000);
			s2.type(libDir+"Find_DropDown.png", Keys.BACKSPACE);

			utils.logout();
			
		} catch(Exception e) {
			throw new AssertionError(e);
		}


	}
	
	
	
	
}
