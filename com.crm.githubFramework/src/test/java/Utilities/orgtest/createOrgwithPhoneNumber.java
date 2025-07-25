package Utilities.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class createOrgwithPhoneNumber {
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Lakshmi N\\Desktop\\Testscript\\Commond.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("Browser");
		String URL = pobj.getProperty("Url");
		String USERNAME = pobj.getProperty("Username");
		String PASSWORD = pobj.getProperty("Password");
		
		
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		System.out.println("randomInt");
		
		  //read testscript data from Excel properties file FileInputStream fis1=new
		FileInputStream fis1 = new  FileInputStream("C:\\Users\\Lakshmi N\\Desktop\\Testscript\\ExcelSheetData.xlsx");
		  Workbook wb = WorkbookFactory.create(fis1); 
		  Sheet sheet = wb.getSheet("org");
		  Row row = sheet.getRow(7); 
		  String orgName =row.getCell(2).toString()+randomInt;
		  String phoneNumber =row.getCell(3).toString();
		  wb.close();	
		
		
		
		  WebDriver driver=null;
			if(BROWSER.equals("chrome"))
			{driver=new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("edge")){
				driver=new EdgeDriver();}
			else {
				driver=new ChromeDriver();
			}
			
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  driver.findElement(By.linkText("Organizations")).click();
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	      driver.findElement(By.name("accountname")).sendKeys(orgName);
	      driver.findElement(By.id("phone")).sendKeys(phoneNumber);	     
	      // Alert popup = driver.switchTo().alert();
	     // popup.accept();
	      Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        
      //verify Header phone Number info Expected Result
	     String temPhoneNumber = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(temPhoneNumber.contains(orgName))
	       {
	    	   System.out.println(orgName+"is created==pass");
	       }else
	       {
	    	   System.out.println(orgName+"is not created==fail");
	       }   
			  
      String actphoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
       if(actphoneNumber.equals(phoneNumber))
       {
    	   System.out.println(phoneNumber+"is created==pass");
       }else
       {
    	   System.out.println(phoneNumber+"is not created==fail");
       }   
		  driver.quit();
	}
	}





