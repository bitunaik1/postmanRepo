package com.autodesk.testyantra1.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//select[@id='qccombo']/option")
private List<WebElement> quickCreateDropDown;

public List<WebElement> getQuickCreateDropDown(){
	return quickCreateDropDown;
}

public void quickCreateList() {
	for(WebElement i:getQuickCreateDropDown()) {
		System.out.println(i.getText());
	}
}
@FindBy(xpath="//*")
private List<WebElement> allElement;

public List<WebElement> getallElement() {
	return allElement;
}

public void getNumberOfLink_Box_Dropdown() {
	int links=0;
	int dropDown=0;
	int box=0;
	for(WebElement i:allElement) {
		if(i.getTagName().equals("a")) {
			links++;
		}
		if(i.getTagName().equals("select")) {
			dropDown++;
		}
		if(i.getTagName().equals("input")) {
			box++;
		}
	}
	System.out.println("Links---->"+links+" box---->"+box+" drop---->"+dropDown);
}
@FindBy(xpath="//td[@class='tabUnSelected']/child::a[text()='Organizations']")
private WebElement organizationLink;

public WebElement getOrganizationLink() {
	return organizationLink;
}

public void clickOnOrganizationLink() {
	getOrganizationLink().click();
}






}
