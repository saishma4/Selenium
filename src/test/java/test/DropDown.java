package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://trytestingthis.netlify.app/");
		
		WebElement dropdown = driver.findElement(By.id("owc"));
		Select selectObject = new Select(dropdown);
		
		List <WebElement> allAvailableOptions = selectObject.getOptions();
		
		for(WebElement option : allAvailableOptions) {
			   System.out.println(option.getText());
			   if(option.getText().equalsIgnoreCase("option 2"))
				   option.click();
			   Thread.sleep(1000);
			   
		}
		
		selectObject.selectByIndex(1);
		Thread.sleep(1000);
		selectObject.selectByValue("option 2");
		Thread.sleep(1000);
		selectObject.selectByVisibleText("Option 3");
		Thread.sleep(1000);
		selectObject.deselectByVisibleText("Option 3");
		selectObject.deselectByValue("option 2");

		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Done");
		
		
		

	}

}
