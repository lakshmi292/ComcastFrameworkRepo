package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage{
	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getImgBtn() {
		return ImgBtn;
	}

	public WebElement getOppName() {
		return OppName;
	}

	public WebElement getChildImgBtn() {
		return childImgBtn;
	}
  public WebElement getSaveBtn() {
		return SaveBtn;
	}
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
  private WebElement ImgBtn;
  
  @FindBy(name="potentialname")
  private WebElement OppName;
  
  @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
  private WebElement childImgBtn;
  
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement SaveBtn;
  
}
