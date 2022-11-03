package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTestNG2 {
	
	static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();	
	}
	
	@Test
	public  void googleSearch2() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com");	
		GoogleSearchPage.textBoxSearch(driver).sendKeys("Selenium");
		GoogleSearchPage.buttonSearch(driver).sendKeys(Keys.RETURN);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		driver.close();
		driver.quit();
		System.out.println("Test completed");
		
	}

}
