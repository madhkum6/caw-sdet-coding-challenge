package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	
	Workbook wb;
	
	public ExcelFileUtil(String ExcelPath) throws Throwable {
		
		FileInputStream fi = new FileInputStream(ExcelPath);
		wb = WorkbookFactory.create(fi);
		
	}
	
	public int rowCount(String sheetname) {
		
		return wb.getSheet(sheetname).getLastRowNum();
		
	}
	
	public String getCellData(String sheetname, int row, int column) {
		
		String data = "";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType() ==CellType.NUMERIC) {
			
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data = String.valueOf(celldata);
		}
		else {
			
			data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		
		return data;
		
	}
	
	public void setCelldata(String sheetname, int row, int column, String writeExcel, String status) throws Throwable {
		
				
		//get sheet from wb
		Sheet ws =wb.getSheet(sheetname);
		//get row from sheet
		Row rowNum =ws.getRow(row);
		//create cell
		Cell cell =rowNum.createCell(column);
		cell.setCellValue(status);
		
		if(status.equalsIgnoreCase("Pass")) {
			
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
			
		}
		else if (status.equalsIgnoreCase("fail")) {
				
				CellStyle style = wb.createCellStyle();
				Font font = wb.createFont();
				font.setColor(IndexedColors.RED.getIndex());
				font.setBold(true);
				style.setFont(font);
				rowNum.getCell(column).setCellStyle(style);
				
			}
		else if(status.equalsIgnoreCase("blocked")) {
			
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
			
		}
		
		FileOutputStream fo = new FileOutputStream(writeExcel);
		wb.write(fo);
		
	}
		
}
	
