package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	public WebElement getHeadermsg() {
		return Headermsg;
	}

	public WebElement getActLastnaME() {
		return actLastnaME;
	}

	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement imgBtn1;
     
	
	@FindBy(className="dvHeaderText")
	private WebElement Headermsg;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement actLastnaME;
	
	@FindBy(name = "support_start_date")
	private WebElement startDate;

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	@FindBy(name = "support_end_date")
	private WebElement endDate;

	public WebElement getImgBtn1() {
		return imgBtn1;
	}

	public WebElement getBtton() {
		return btton;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLasTxt() {
		return LasTxt;
	}

	@FindBy(xpath = "//input[@type='button']")
	private WebElement btton;

	@FindBy(name = "lastname")
	private WebElement LasTxt;

	// Rule 3: Object Intialization

	// Run :4:Object Encapsulation

	public WebElement getimgBtn1() {
		return imgBtn1;
	}

	/*
	 * //run 5:provide Action public void ContactToapp() {
	 * driver.manage().window().maximize(); imgBtn1.click();
	 * LasTxt.sendKeys("whatsup");
	 */
}
