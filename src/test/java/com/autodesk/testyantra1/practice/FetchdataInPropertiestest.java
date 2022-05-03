package com.autodesk.testyantra1.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;

import org.testng.annotations.Test;

import com.autodesk.testyantra1.genericlibrary.BaseClass;

public class FetchdataInPropertiestest extends BaseClass{
	@Test(enabled=false,groups = {"Smoke"})
public void property() throws IOException {
		FileOutputStream fis=new FileOutputStream("./src/test/resources/vtiger.properties");
		Properties pobj=new Properties();
		pobj.setProperty("browser","chrome");
		pobj.setProperty("Os", "windows11");
		pobj.store(fis, null);
		
}
}
