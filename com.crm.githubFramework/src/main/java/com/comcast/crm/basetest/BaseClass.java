package com.comcast.crm.basetest;

import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public  WebDriverUtility driver = null;
	public static WebDriver sdriver=null;
	public  DataBaseUtility dblib = new DataBaseUtility();
	public  FileUtility fiu = new FileUtility();
	public  ExcelUtility exu = new ExcelUtility();
	public  JavaUtility jlib = new JavaUtility();
	public  WebDriverUtility wlib;
	 public 	static ExtentReports report;
		public ExtentSparkReporter spark;
		public static ExtentTest test;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void confiBS() throws SQLException {
		System.out.println("==connect to DB,Report confi==");
		dblib.getDbConnection();
		
	}
	
   // @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void confiBC() throws Throwable {
		System.out.println("==Lunch the Browser==");
		String BROWSER =fiu.getDataFromPropertiesFile("browser");
		String URL = fiu.getDataFromPropertiesFile("url");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		driver.get(URL);
		wlib=new WebDriverUtility();
		wlib.waitForPageToLoad(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void confiBM() throws Throwable {
		System.out.println("==login==");	
		String USERNAME = fiu.getDataFromPropertiesFile("username");
		String PASSWORD = fiu.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp( USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void confiAM() throws Exception {
		System.out.println("==logout==");
		HomePage hp = new HomePage(driver);
		//hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void confiAC() {
		System.out.println("==Close the Browser==");
		driver.quit();
		
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void confiAS() throws SQLException {
		System.out.println("==close Db, Report Backup==");
		dblib.closeDbconnection();
		report.flush();
	}
}
