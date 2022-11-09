package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public static int getRowCount(){
		int rowCount =0;
		
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}
	public static int getColCount(){
		int colCount=0;
		
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
		
		
		
	}
	public static String getCellDataString(int rowNum, int colNum){
		String cellData = null;
		try {
			
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
//	public static int getCellDataNumeric(int rowNum, int colNum){
//		try {
//			
//			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//			System.out.println(cellData);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause());
//			e.printStackTrace();
//		}	
//	}

}
