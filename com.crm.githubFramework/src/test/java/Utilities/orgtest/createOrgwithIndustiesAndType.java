package Utilities.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.Select;

public class createOrgwithIndustiesAndType {
	public static void main(String[] args) throws Throwable {

		boolean flag = false;
		FileInputStream fis=new FileInputStream("C:\\Users\\Lakshmi N\\Desktop\\Testscript\\Commond.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("Browser");
		String URL = pobj.getProperty("Url");
		String USERNAME = pobj.getProperty("Username");
		String PASSWORD = pobj.getProperty("Password");
		
		Random random=new Random();
		int randon = random.nextInt(1000);
		//System.out.println("randomInt");
		
		  //read testscript data from Excel properties file FileInputStream fis1=new
		FileInputStream fis1 = new  FileInputStream("C:\\Users\\Lakshmi N\\Desktop\\Testscript\\ExcelSheetData.xlsx");
		  Workbook wb = WorkbookFactory.create(fis1); 
		  Sheet sheet = wb.getSheet("org");
		  Row row = sheet.getRow(4); 
		  String org =row.getCell(2).toString()+randon;
		  String Industries =row.getCell(3).getStringCellValue();
		  String Type =row.getCell(4).getStringCellValue();
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
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  driver.findElement(By.linkText("Organizations")).click();
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	      driver.findElement(By.name("accountname")).sendKeys(org);
	      WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
	      dropdown.click();
	       Select s=new Select(dropdown);
	       s.selectByVisibleText(Industries);
	       
	       Thread.sleep(2000);
	       WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='accounttype']"));
	       dropdown1.click();
	       Select s1=new Select(dropdown1);
	       s1.selectByVisibleText(Type);
	      
	      
	     
	      Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	     
	     String partialIndustries = driver.findElement(By.className("dvHeaderText")).getText();
	       if(partialIndustries.contains(Industries))
	       {
	    	   System.out.println(Industries+"information is verified==pass");
	       }else
	       {
	    	   System.out.println(Industries+"information is not verified==fail");
	       }
	       
	     
	     String partialType = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	     if(partialType.contains(Type))
	       {
	    	   System.out.println(Type+"information is verified==pass");
	       }else
	       {
	    	   System.out.println(Type+"information is not verified==fail");
	       }
			 
	     String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
	       if(actIndustries.equals(Industries))
	       {
	    	   System.out.println(Industries+"information is verified==pass");
	       }else
	       {
	    	   System.out.println(Industries+"information is not verified==fail");
	       }
	       
	     
	     String actType = driver.findElement(By.id("dtlview_Type")).getText();
	     if(actType.equals(Type))
	       {
	    	   System.out.println(Type+"information is verified==pass");
	       }else
	       {
	    	   System.out.println(Type+"information is not verified==fail");
	       }
			 
	     driver.quit();
		 
	}
	


	}


