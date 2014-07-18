package com.sandisk.rpsys.excel.deamon;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

public class FormatCellDeamon {
	
	 @Test
	 public void openExcelFile() throws IOException{
			// create a new file
			FileOutputStream out = new FileOutputStream("/home/wcao/Documents/workbook2.xls");

			// create a new workbook
			Workbook wb = new HSSFWorkbook();
			// create a new sheet
			Sheet s = wb.createSheet();
			//set sheet name
			wb.setSheetName(0, "mysheet");
			s.setColumnWidth(0, 254);
			//参数1：行号 参数2：起始列号 参数3：行号 参数4：终止列号
			s.addMergedRegion(new CellRangeAddress(2, 5, 2, 5));
			//insert the first row
			Row row;
			Cell cell;
			CellStyle cs = wb.createCellStyle();
//			cs.setFillBackgroundColor(new HSSFColor.YELLOW().getIndex());
			cs.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());
//			cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND );
			Font font = wb.createFont();
			font.setColor(Font.COLOR_RED);
			cs.setFont(font);
			row = s.createRow(0);
			cell = row.createCell(0);
			cell.setCellStyle(cs);
			cell.setCellValue("Group");
			cell = row.createCell(1);
			cell.setCellValue("HCaaaaaaaaaaaaabcsdfdsa");
			cell = row.createCell(2);
			cell.setCellValue(new Date().toString());
			
			
			
			wb.write(out);
			out.close();
		}

}
