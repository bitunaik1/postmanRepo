package com.autodesk.testyantra1.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.autodesk.testyantra1.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to satisfy pre and post condition of Test scripts
 * @author Omprakash
 *
 */
public class BaseClass {
	public WebDriver driver;
	public static WebDriver listenerDriver;
	@BeforeSuite(alwaysRun = true)
public void beforeSuite() {
	System.out.println("Connect to DataBase");
}
	@BeforeTest(alwaysRun = true)
public void beforeTest() {
	System.out.println("Start Parallel execution");
}
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
public void beforeClass(/*String browser*/) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/vtiger.properties");
		Properties pobj =new Properties();
		pobj.load(fis);
		String browser=pobj.getProperty("browser");
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	listenerDriver=driver;
	driver.get("http://localhost:8888");
	
}
	@BeforeMethod(alwaysRun = true)
public void beforeMethod() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login();
	System.out.println("Login hai gala");
}
	@AfterMethod(alwaysRun = true)
public void afterMethod() {
	System.out.println("logout hai gala");
}
	@AfterClass(alwaysRun = true)
public void afterClass() {
	driver.quit();
}
	@AfterTest(alwaysRun = true)
public void afterTest() {
	System.out.println("End parallel execution");
}
	@AfterSuite(alwaysRun = true)
public void afterSuite() {
		System.out.println("close database connection");
}
}
