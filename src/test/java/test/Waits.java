package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		
//		//explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement myLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Selenium")));
//		myLink.click();
		
		//
		Wait <WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
          .withTimeout(Duration.ofSeconds(10)) 
          .pollingEvery(Duration.ofSeconds(1)) 
          .ignoring(NoSuchElementException.class);
		WebElement myLinkTwo  = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Selenium")));
		myLinkTwo.click();
		
		
		driver.close();
		driver.quit();

	}

}
