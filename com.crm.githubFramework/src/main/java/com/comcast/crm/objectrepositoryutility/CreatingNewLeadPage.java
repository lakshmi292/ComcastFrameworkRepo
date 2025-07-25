package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	WebDriver driver;
	public CreatingNewLeadPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement ImgsearchBtn;
	
	
	@FindBy(name="lastname")
	private WebElement LastName;
	
	@FindBy(name="company")
	private WebElement CompanyName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	public WebElement getImgsearchBtn() {
		return ImgsearchBtn;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getCompanyName() {
		return CompanyName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
}
