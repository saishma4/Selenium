package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
				
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username+" | "+password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		
		}
	
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\chanda.saishma\\eclipse-workspace\\SeleniumProject\\excel\\data.xlsx";
		Object data[][] = testData(excelPath,"Sheet1");
		return data;
		
		
		
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i =1;i<rowCount;i++){
			for(int j=0;j<colCount;j++) {
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j]  = cellData;
				
			}
			System.out.println();
		
	}
		return data;

}
}
