package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productInfoPage {
	WebDriver driver;
	public productInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getActstartDate() {
		return actstartDate;
	}

	public WebElement getActendDate() {
		return actendDate;
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id="dtlview_Sales Start Date")
	private WebElement actstartDate;
	
	@FindBy(id="dtlview_Sales End Date")
	private WebElement actendDate;
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getStartDate() {
		return actstartDate;
	}

	public WebElement getEndDate() {
		return actendDate;
	}
	
}
