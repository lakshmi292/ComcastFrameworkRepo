package Utilities.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrgTest {
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
		  String orgName =row.getCell(2).toString()+randomInt;
		  String contactLastName=row.getCell(3).getStringCellValue();
		  
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
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	     //verify expected result
	     String headerInf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(headerInf.contains(orgName))
	       {
	    	   System.out.println(orgName+"is created==pass");
	       }else
	       {
	    	   System.out.println(orgName+"is not created==fail");
	       }
	       
	       driver.findElement(By.linkText("Contacts")).click();
			  driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		      driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactLastName);
	     //driver.findElement(By.xpath("//input[@name='account_name']/following-sibiling::img")).click();
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	     //switch to child window
	    Set<String> set = driver.getWindowHandles();
	     Iterator<String> it = set.iterator();
		while(it.hasNext()) {
	    	 String windowID = it.next();
		driver.switchTo().window(windowID);
	
		String acturl = driver.getCurrentUrl();
		if(acturl.contains("module=Accounts")) {
			break;
		}
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
	     driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	     //switch to parent window
	     
		Set<String> set1= driver.getWindowHandles();
	     Iterator<String> it1 = set1.iterator();
	     
		while(it1.hasNext()) {
			 String windowID= it1.next();
	driver.switchTo().window(windowID);
	
		String acturl1 = driver.getCurrentUrl();
		if(acturl1.contains("Contacts&action")) {
			break;
		}
		}
		   
	    // driver.findElement(By.xpath("//input[@type='button']")).click();
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
       //verify Header OrgName info Expected Result
	     headerInf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(headerInf.contains(contactLastName))
	       {
	    	   System.out.println(contactLastName+"is created==pass");
	       }else
	       {
	    	   System.out.println(contactLastName+"is not created==fail");
	       }
	     String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();    
	       if(actOrgName.contains(orgName))
	       {
	    	   System.out.println(orgName+"is created==pass");
	       }else
	       {
	    	   System.out.println(orgName+"is not created==fail");
	       }   
	       driver.quit();
    }
		 
	}
	



