package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentpage {
	WebDriver driver;
	public CreatingNewDocumentpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ImgBtn;
	
	@FindBy(name="notes_title")
	private WebElement TitleTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	public WebElement getImgBtn() {
		return ImgBtn;
	}

	public WebElement getTitleTxt() {
		return TitleTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
}
