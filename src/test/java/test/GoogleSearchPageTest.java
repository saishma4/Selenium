package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearchTest();
		
	}
	
	public static void googleSearchTest() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		searchPageObj.setTextInSearchBox("Selenium");
		
		searchPageObj.clickSearchButton();
		
		driver.close();
		
		System.out.println("Test completed");
	}

}
