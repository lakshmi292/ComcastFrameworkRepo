package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadInfoPage {
	WebDriver driver;
	public leadInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(className="dvHeaderText")
		private WebElement headermsg;
		
		public WebElement getHeadermsg() {
			return headermsg;
		}

		public WebElement getActLastName() {
			return actLastName;
		}

		public WebElement getActCompanyName() {
			return actCompanyName;
		}

		@FindBy(id="dtlview_Last Name")
		private WebElement actLastName;
		
		@FindBy(id="dtlview_Company")
		private WebElement actCompanyName;
	}

