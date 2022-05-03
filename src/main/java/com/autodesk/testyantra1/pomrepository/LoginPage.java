package com.autodesk.testyantra1.pomrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebDriver driver;
@FindBy(name="user_name")
private WebElement userNameTB;
public WebElement getUserNameTB() {
	return userNameTB;
}
public void login() {
	getUserNameTB().sendKeys("admin",Keys.TAB,"root",Keys.ENTER);
}
}
