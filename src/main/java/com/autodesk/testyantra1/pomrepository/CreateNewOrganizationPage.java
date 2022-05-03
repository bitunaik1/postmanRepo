package com.autodesk.testyantra1.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
public CreateNewOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a/child::img[@title='Create Organization...']")
private WebElement plusIcon;

public WebElement getPlusIcon() {
	return plusIcon;
}
public void clickOnPlusIcon() {
	getPlusIcon().click();
}

}
