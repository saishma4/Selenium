package utils;

public class ExcelUtilsDemo {
	static String projectPath;

	public static void main(String[] args) {
		
		projectPath = System.getProperty("user.dir");
	
		ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx","Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
	}

}
