package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateingNewOrganizationPage {

	WebDriver driver;
	public CreateingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getorgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;
	
	public WebElement getIndustryDD() {
		return industryDD;
	}
	@FindBy(name="industry")
	private WebElement industryDD;

	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	public WebElement getTypeDD() {
		return typeDD;
	}
	
	// Busniess Library
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		SaveBtn.click();
	}
	public void createOrg(String orgName ,String  industry) {
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDD);
		sel.selectByVisibleText(industry);
		SaveBtn.click();
	}	
		public void createOrg(String orgName ,String  industry , String type  ) {
			orgNameEdt.sendKeys(orgName);
			Select sel=new Select(industryDD);
			sel.selectByVisibleText(industry);
			Select sel1=new Select(typeDD);
			sel1.selectByVisibleText(type);
			SaveBtn.click();
}
		public void createOrgandphone(String orgName , String phoneNumber) {
			orgNameEdt.sendKeys(orgName);
			phoneEdt.sendKeys(phoneNumber);
			SaveBtn.click();
		}
}
