package com.infinera.dnam.gui.reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener implements ISuiteListener, ITestListener, IInvokedMethod {


	static ExtentReports reports;
	static ExtentTest test;
	String methodStartTime;
	String methodEndTime;
	String methodName;



	@Override
	public boolean isTestMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConfigurationMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ITestNGMethod getTestMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestResult getTestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		reports.startTest(result.getMethod().getMethodName());
		
		test.log(LogStatus.INFO, result.getMethod().getMethodName()+" Test Started....");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, "WHOA!!! Test PASSED....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.FAIL, "ALERT!!! Test FAILED....");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, "ALERT!!! Test SKIPPED....");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {

		test=reports.startTest(context.getName());
		
		test.log(LogStatus.INFO, "Test has started....");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
	//	test.log(LogStatus.INFO, "Test finished....");
		reports.endTest(test);
		reports.flush();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
		String suiteName  = suite.getName();
		Iterator<ITestNGMethod> iter = suite.getAllMethods().iterator();
		

		String reportFileName = suiteName+"_"+
				new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())+"_"+"reports.html";

		reports = new ExtentReports(reportFileName);
		
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		//test.log(LogStatus.INFO, suite.getName()+" has Finished....");
	}
}