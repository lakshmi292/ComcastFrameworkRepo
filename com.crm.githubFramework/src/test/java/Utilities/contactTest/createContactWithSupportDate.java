package Utilities.contactTest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createContactWithSupportDate {
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
		//System.out.println("randomInt");
		
		  //read testscript data from Excel properties file FileInputStream fis1=new
		FileInputStream fis1 = new  FileInputStream("C:\\Users\\Lakshmi N\\Desktop\\Testscript\\ExcelSheetData.xlsx");
		  Workbook wb = WorkbookFactory.create(fis1); 
		  Sheet sheet = wb.getSheet("contact");
		  Row row = sheet.getRow(7); 
		  String lastName =row.getCell(3).toString();
		  
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


		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  driver.findElement(By.linkText("Contacts")).click();
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		  
		  Date dateobj=new Date();
			
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			String startDate= sim.format(dateobj);
		
				  Calendar cal = sim.getCalendar(); 
				  cal.add(Calendar.DAY_OF_MONTH, 30); 
				  String endDate = sim.format(cal.getTime()); 
				  
	      driver.findElement(By.name("lastname")).sendKeys(lastName);
	      driver.findElement(By.name("support_start_date")).clear();
	      driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	      
	      
	      driver.findElement(By.name("support_end_date")).clear();
	      driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	     // Alert popup = driver.switchTo().alert();
	     // popup.accept();
	      Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	     //verify Header msg Expected Result
	     String headerInf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(headerInf.contains(lastName))
	       {
	    	   System.out.println(lastName+"is created==pass");
	       }else
	       {
	    	   System.out.println(lastName+"is not created==fail");
	       }
	       
	  
	   //verify Header msg actual Result
       String actstartdate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
       if(actstartdate.equals(startDate))
       {
    	   System.out.println(startDate+"is created==pass");
       }else
       {
    	   System.out.println(startDate+"is not created==fail");
       }
       
       String actEndDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
       if(actEndDate.equals(endDate))
       {
    	   System.out.println(endDate+"is created==pass");
       }else
       {
    	   System.out.println(endDate+"is not created==fail");
       }
       driver.quit();
}
 
}
