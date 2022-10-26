package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) {
		
		//webdriver.chrome.driver(for chrome browser)
		//location of chrome driver(./driver/chromedriver.exe)
		
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		WebDriverManager.chromedriver().driverVersion("106.0.5249.61").setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		driver.get("https://google.com");
		driver.close();
	}
}
