package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getImgBtn() {
		return ImgBtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
       private WebElement ImgBtn;
	
	@FindBy(name="sales_start_date")
	private WebElement startDate;
	
	@FindBy(name="sales_end_date")
	private WebElement endDate;
	
	
	@FindBy(name="productname")
	private WebElement ProductName;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement SaveBtn;
}
