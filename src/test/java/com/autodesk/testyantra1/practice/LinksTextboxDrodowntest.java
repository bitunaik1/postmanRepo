package com.autodesk.testyantra1.practice;


import org.testng.annotations.Test;

import com.autodesk.testyantra1.genericlibrary.BaseClass;
import com.autodesk.testyantra1.pomrepository.HomePage;


public class LinksTextboxDrodowntest extends BaseClass{
	@Test(groups = {"Regression"})
public void m1() throws InterruptedException {
		System.out.println(System.getProperty("browser"));
	Thread.sleep(8000);
	HomePage homePage=new HomePage(driver);
	homePage.getNumberOfLink_Box_Dropdown();
}
}
