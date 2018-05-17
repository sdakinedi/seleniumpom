package extentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.python.modules.synchronize;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports report;
	
	
	public synchronized static ExtentReports getReporter() {
		
		if(report == null) {
			String workingDir = System.getProperty("user.dir");
			
			String fileName = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())+"_extentResultReport.html";
			
			report = new ExtentReports(workingDir+"\\extentReports\\"+fileName, true);
		}
		
		
		return report;
		
	}
	
	
}
