package com.autodesk.testyantra1.pomrepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChildOrganizationPage 
{
	public ChildOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
public void handleWindow(WebDriver driver) {
	
	Set<String> win=driver.getWindowHandles();
	Iterator<String> it=win.iterator();
	while(it.hasNext()) {
		String wid=it.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains("ccounts&action")) {
			break;
		}
	}
	driver.close();
}
}
