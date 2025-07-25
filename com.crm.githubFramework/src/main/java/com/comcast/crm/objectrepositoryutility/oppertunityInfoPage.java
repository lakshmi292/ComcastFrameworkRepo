package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oppertunityInfoPage {
	WebDriver driver;
	public oppertunityInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//extra
	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement OrganizationName;
	public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}
			
}
