package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChrome {
	
	public static void main(String[] args) {
		
		test();
		
	}
	
	public static void test() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriverManager.chromedriver().setup();
	
		
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
		System.out.println("Completed");
		
		
		
		
	}

}
