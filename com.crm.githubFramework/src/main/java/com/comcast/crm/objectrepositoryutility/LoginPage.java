

package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * 
 * @author Lakshmi N
 * 
 * Contains Login page elements & business lib like login()
 */
public class LoginPage  extends WebDriverUtility{ //Rule-1 create a separate java class
	                     // Rule-2 Object Creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
  private	WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	                       //Rule 3: Object Intialization
	
	//Run :4:Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//run 5:provide Action
	
	/*
	 * public void loginToapp(String username, String password) {
	 * driver.manage().window().maximize(); usernameEdt.sendKeys("admin");
	 * passwordEdt.sendKeys("admin"); loginBtn.click(); }
	 */
	
/**
 * login to application based username ,password arguments
 * @param username
 * @param password
 */
	public void loginToapp(String username, String password) {
          driver.manage().window().maximize();
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}
}
