package com.autodesk.testyantra1.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
	ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport.html");
	ExtentReports report=new ExtentReports();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		System.out.println(result.getThrowable());
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
	}

	public void onTestFailure(ITestResult result) {
		String dateTime=Calendar.getInstance().getTime().toString().replace(":", "_").replace(" ", "_");
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName);
		System.out.println(result.getThrowable());
		TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerDriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshot"+methodName+dateTime+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName);
		System.out.println(result.getThrowable());
	}

	public void onStart(ITestContext context) {
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Your Report");
		reporter.config().setReportName("Name of Reporter");
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("Build", "B020");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
