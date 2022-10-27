package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//sendKeys
		driver.get("https://google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		
		//keyDown
		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		
		//key Up
		
		WebElement search = driver.findElement(By.name("q"));
		actionProvider.keyDown(Keys.SHIFT).sendKeys(search,"selenium")
		.keyUp(Keys.SHIFT).sendKeys(" selenium").perform();

		Thread.sleep(1000);
		
		//clear
		
		search.clear();
		
		Thread.sleep(1000);
		driver.quit();

	}

}
