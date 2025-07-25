package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement ImgsearchBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getImgsearchBtn() {
		return ImgsearchBtn;
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateNewBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateNewBtn() {
		return CreateNewBtn;
	}
	
	                       //Rule 3: Object Intialization
	
	//Run :4:Object Encapsulation
	

	public WebElement CreateNewBtn() {
		return CreateNewBtn;
	}
	
	//run 5:provide Action
	
}

