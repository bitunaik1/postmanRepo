package com.autodesk.testyantra1.genericlibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ImplementRetryAnalyzer implements IRetryAnalyzer {
	int count=0;
	int limitCount=4;
	public boolean retry(ITestResult result) {
		while(count<=limitCount) {
			count++;
			return true;
		}
		return false;
	}

}
