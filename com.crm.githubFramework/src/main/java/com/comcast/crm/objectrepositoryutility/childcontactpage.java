package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class childcontactpage {
	WebDriver driver;
	public childcontactpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement imgChild;;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTxt;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchNow;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement orgsearchlink;
	
	@FindBy(name="search_field")
	private WebElement OrgDD;
	
	public WebElement getImgChild() {
		return imgChild;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}
     
	public WebElement getOrgsearchlink() {
		return orgsearchlink;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgDD() {
		return OrgDD;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}
	
	public void handlechildwindow(String orgName)
	{
		imgChild.click();
		searchTxt.sendKeys(orgName);
		Select s=new Select(OrgDD);
		s.selectByVisibleText("Organization Name");
		searchNow.click();
	}
}

	