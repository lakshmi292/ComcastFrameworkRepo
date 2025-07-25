package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
		WebDriver driver;
		public ContactInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public WebElement getHeaderMsg() {
			return headerMsg;
		}

		public WebElement getActOrgName() {
			return actOrgName;
		}
		public WebElement getActLastName() {
			return actLastName;
		}
		@FindBy(className="dvHeaderText")
		private WebElement headerMsg;
		
		@FindBy(id="mouseArea_Organization Name")
	     private WebElement actOrgName;
		
		@FindBy(id="dtlview_Last Name")
		private WebElement actLastName;
		
		public WebElement getActstartDate() {
			return actstartDate;
		}
		public WebElement getActendDate() {
			return actendDate;
		}


		@FindBy(id="dtlview_Support Start Date")
		private WebElement actstartDate;
		
		@FindBy(id="dtlview_Support End Date")
		private WebElement actendDate;
		
		
}
