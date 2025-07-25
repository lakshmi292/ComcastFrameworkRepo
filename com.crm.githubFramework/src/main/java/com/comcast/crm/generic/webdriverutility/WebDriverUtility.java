package com.comcast.crm.generic.webdriverutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
 public void waitForElementPresent(WebDriver driver , WebElement element) {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.visibilityOf(element));
 }
  public void switchToTabOnURL(WebDriver driver ,String partialURl) {
	 Set<String> set = driver.getWindowHandles();
     Iterator<String> it = set.iterator();
	while(it.hasNext()) {
    	 String windowID = it.next();
    	 
	driver.switchTo().window(windowID);

	String acturl = driver.getCurrentUrl();
	if(acturl.contains(partialURl)) {
		break;}
	}
 }
  
	public void switchToTabOnTitle(WebDriver driver ,String partialTitle)
	 {
		 Set<String> set = driver.getWindowHandles();
	     Iterator<String> it = set.iterator();
		while(it.hasNext()) {
	    	 String windowID = it.next();
		driver.switchTo().window(windowID);

		String acturl = driver.getTitle();
		if(acturl.contains(partialTitle)) {
			break;}
 }
	 }
	public void switchtoFrame(WebDriver driver,int index){
		driver.switchTo().frame(index);
	}
	public void switchtoFrame(WebDriver driver, String nameID){
		driver.switchTo().frame(nameID);
	}
	public void switchtoFrame(WebDriver driver, WebElement element){
		driver.switchTo().frame(element);
	}
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void notificationpopup(WebDriver driver) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
	}
	public void select(WebElement element , String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element , int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
    }
	public void deselect(WebElement element , String value) {
		Select sel=new Select(element);
		sel.deselectByValue(value);
    }
	public void deselectall(WebElement element) {
		Select sel=new Select(element);
		sel.deselectAll();
    }
	public void deselect(WebElement element , int index) {
		Select sel=new Select(element);
		sel.deselectByIndex(index);
    }
	public void deselectvisible(WebElement element ,String text) {
		Select sel=new Select(element);
		sel.deselectByVisibleText(text);
    }
	public void getselect(WebElement element) {
		Select sel=new Select(element);
		sel.getAllSelectedOptions();
    }
	public void getfirstselect(WebElement element) {
		Select sel=new Select(element);
		sel.getFirstSelectedOption();
    }
	public void getselectoption(WebElement element) {
		Select sel=new Select(element);
		sel.getOptions();
    }
	public void getwrappedelement(WebElement element) {
		Select sel=new Select(element);
		sel.getWrappedElement();
    }
	public void ismultiple(WebElement element) {
		Select sel=new Select(element);
		sel.isMultiple();
    }
	public void mousemoveOnElement(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleclick(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void draganddrop(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}
	public void clickandhold(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	}
	public void clickandholdslider(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.clickAndHold().perform();
	}
	public void rightclick(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	public void rightclick(WebDriver driver) {
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	public void scrollByAmount(WebDriver driver , int X, int Y) {
		Actions act= new Actions(driver);
		act.scrollByAmount(X, Y).perform();
	}
	public void scrollByElement(WebDriver driver ,WebElement element) {
		Actions act= new Actions(driver);
		act.scrollToElement(element).perform();
}
	public void takeScreenShot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		ts.getScreenshotAs(OutputType.FILE);
			}
	public void javascriptexecutor(WebDriver driver , String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("ar"
				+ "guments[0];", value);
	}
	
	}
