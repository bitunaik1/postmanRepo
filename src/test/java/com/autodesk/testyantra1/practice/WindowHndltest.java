package com.autodesk.testyantra1.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autodesk.testyantra1.genericlibrary.BaseClass;
import com.autodesk.testyantra1.pomrepository.ChildOrganizationPage;
import com.autodesk.testyantra1.pomrepository.CreateNewOrganizationPage;
import com.autodesk.testyantra1.pomrepository.HomePage;
import com.autodesk.testyantra1.pomrepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHndltest extends BaseClass{
	//@Parameters({"boom"})
	@Test(groups = {"Smoke","Regression"})
	public void mm(/* String boom */) {
	//	System.out.println(boom);
		HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganizationLink();
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.clickOnCreateOrg();
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.clickOnPlusIcon();
		ChildOrganizationPage childOrganizationPage=new ChildOrganizationPage(driver);
		childOrganizationPage.handleWindow(driver);
		String mainId=driver.getWindowHandle();
		driver.switchTo().window(mainId);
		
		
}
}
