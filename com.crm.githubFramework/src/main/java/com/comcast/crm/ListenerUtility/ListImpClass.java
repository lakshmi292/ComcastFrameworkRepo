package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Configration");

		// Spark report confi
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backUp");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======" + result.getMethod().getMethodName() + "===START===");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "==>Started<==");

		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==>STARTED<==");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======" + result.getMethod().getMethodName() + "===END===");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==>COMPLETED<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testNAME = result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot) BaseClass.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(":", " ").replace(" ", "_");
		System.out.println("d:" + new Date().toString());
		test.addScreenCaptureFromBase64String(filepath, time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==>Failed<==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
