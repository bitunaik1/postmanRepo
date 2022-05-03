package com.autodesk.testyantra1.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.autodesk.testyantra1.genericlibrary.BaseClass;
import com.autodesk.testyantra1.pomrepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownOptionsWithoutGetOptionstest extends BaseClass {
	@Test(groups = {"Smoke"})
public void m1() throws IOException {
	HomePage homePage=new HomePage(driver);
	homePage.quickCreateList();
}
}
