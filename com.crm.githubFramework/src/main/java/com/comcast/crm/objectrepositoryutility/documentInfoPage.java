package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class documentInfoPage {
	WebDriver driver;
	public documentInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="dvHeaderText")
	private WebElement headinfoMsg;
	
	public WebElement getHeadinfoMsg() {
		return headinfoMsg;
	}

	public WebElement getActTitle() {
		return actTitle;
	}
	@FindBy(id="dtlview_Title")
	private WebElement actTitle;
}
