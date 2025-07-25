package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

		WebDriver driver;
		public OrganizationInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	public WebElement getHeaderMsg() {
			return headerMsg;
		}

	public WebElement getActindustry() {
		return actindustry;
	}

	public WebElement getActtype() {
		return acttype;
	}

	public WebElement getActphonenumber() {
		return actphonenumber;
	}

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement actindustry;
	
	@FindBy(id="dtlview_Type")
	private WebElement acttype;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actphonenumber;
	

}
