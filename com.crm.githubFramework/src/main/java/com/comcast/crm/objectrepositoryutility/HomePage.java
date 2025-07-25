package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Rule-1 create a separate java class
	// Rule-2 Object Creation
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Calendar")
	private WebElement calLnk;

	@FindBy(linkText = "Organizations")
	private WebElement OrgLnk;

	@FindBy(linkText = "Contacts")
	private WebElement ConLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement OppLnk;

	@FindBy(linkText = "Products")
	private WebElement ProLnk;

	@FindBy(linkText = "Documents")
	private WebElement DocLnk;

	@FindBy(linkText = "Email")
	private WebElement EmaLnk;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement TtiLnk;

	@FindBy(linkText = "Dashboard")
	private WebElement DasLnk;

	@FindBy(linkText = "Leads")
	private WebElement LeaLnk;

	@FindBy(linkText = "More")
	private WebElement MoreLnk;

	@FindBy(linkText = "Campaigns")
	private WebElement CampLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutBtn;
	// Rule 3: Object Intialization

//Run :4:Object Encapsulation
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}

	public WebElement getCalLnk() {
		return calLnk;
	}

	public WebElement getOrgLnk() {
		return OrgLnk;
	}

	public WebElement getConLnk() {
		return ConLnk;
	}

	public WebElement getOppLnk() {
		return OppLnk;
	}

	public WebElement getProLnk() {
		return ProLnk;
	}

	public WebElement getDocLnk() {
		return DocLnk;
	}

	public WebElement getEmaLnk() {
		return EmaLnk;
	}

	public WebElement getTtiLnk() {
		return TtiLnk;
	}

	public WebElement getDasLnk() {
		return DasLnk;
	}

	public WebElement getLeaLnk() {
		return LeaLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getCampLnk() {
		return CampLnk;
	}

//run 5:provide Action
	public void navigateToCamoaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(MoreLnk).perform();
		CampLnk.click();
	}

	public void logout() throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		SignOutBtn.click();
	}
}