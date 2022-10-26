package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().driverVersion("106.0.5249.61").setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		driver.get("https://google.com");
		
		driver.navigate().to("https://trytestingthis.netlify.app/");
		List <WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
		
		for (WebElement element: options) {
			System.out.println(element.getText());
		}
		
		WebElement lastname = driver.findElement(By.id("lname"));
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(lastname)).sendKeys("ABCD");
		
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}
