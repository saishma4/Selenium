package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {
	
	static WebDriver driver = null;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	
	
	@BeforeSuite
	public void setUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		htmlReporter = new ExtentSparkReporter("extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test
	public  void test1() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		ExtentTest test1 = extent.createTest("Google Search Test One","This test is to validate google search functionality");
		driver.get("https://google.com");
		test1.log(Status.INFO,"Starting Test Case");
		
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		test1.pass("Entered text in SearchBox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		//test1.info
		//test1.fail
	
	}

	@AfterSuite
	public void tearDown() {

		driver.close();
		driver.quit();
		
		extent.flush();
		System.out.println("Test completed");
		

	}


}
