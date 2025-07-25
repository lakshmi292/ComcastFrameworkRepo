package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationsOpportunityPage {
	WebDriver driver;
	public organizationsOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement oppName;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchTxt;
	public WebElement getOppName() {
		return oppName;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}
	


	}

