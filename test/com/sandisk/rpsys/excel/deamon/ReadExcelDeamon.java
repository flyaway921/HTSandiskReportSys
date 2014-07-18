package com.sandisk.rpsys.excel.deamon;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
public class ReadExcelDeamon {
	
	@Test
	public void read() throws IOException{
		FileInputStream ips = new FileInputStream("/home/wcao/Documents/workbook.xls");
		POIFSFileSystem fs = new org.apache.poi.poifs.filesystem.POIFSFileSystem(ips);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		wb.setSheetName(0, "mysheet");
		Sheet sheet = wb.getSheet("mysheet");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		System.out.println(cell.getNumericCellValue());
		ips.close();
//		return wb;
	}
}
