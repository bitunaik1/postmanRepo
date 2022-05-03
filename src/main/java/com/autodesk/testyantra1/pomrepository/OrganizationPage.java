package com.autodesk.testyantra1.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
public OrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Organizations']")
private WebElement createOrgLink;

public WebElement getCreateOrgLink() {
	return createOrgLink;
}
public void clickOnCreateOrg() {
	getCreateOrgLink().click();
}
}
