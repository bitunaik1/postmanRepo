package com.autodesk.testyantra1.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.testyantra1.genericlibrary.BaseClass;

public class FetchDataInExceltest extends BaseClass{
	@Test(retryAnalyzer = com.autodesk.testyantra1.genericlibrary.ImplementRetryAnalyzer.class,groups = {"Regression"})
public void excel() throws EncryptedDocumentException, IOException {
	HashSet<String> hs=new HashSet<String>();
	hs.add("boom");
	hs.add("BB");
	hs.add("ja");
	FileInputStream fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Sheet1");
	int rowNum=0;
	for(String i:hs) {
		Row row=sh.createRow(rowNum++);
		Cell cell=row.createCell(0);
		cell.setCellValue(i);
	}
	FileOutputStream fos = new FileOutputStream("./src/test/resources/vtiger.xlsx");
	book.write(fos);
	book.close();
	System.out.println("success");
}
	@Test
	public void m2() {
	System.out.println("Just Do It");
	}
}
