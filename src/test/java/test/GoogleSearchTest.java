package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		
		GoogleSearchPage.textBoxSearch(driver).sendKeys("Selenium");
		GoogleSearchPage.buttonSearch(driver).sendKeys(Keys.RETURN);
		
		driver.close();
		
		System.out.println("Test completed");
	}

}
