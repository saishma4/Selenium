package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	
    static WebDriver driver = null;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		ExtentReports extent = new ExtentReports();
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentreport.html");
		
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google Search Test One","This test is to validate google search functionality");
		
		driver.get("https://google.com");
		test1.log(Status.INFO,"Starting Test Case");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		test1.pass("Entered text in SearchBox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		
		test1.pass("Closed the browser");
		test1.info("Test Completed");
		
		extent.flush();
		
		
		

	}

}
