package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Actions actions = new Actions(driver);
		
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		
		WebElement boxA  = driver.findElement(By.xpath("//li[text()='A']"));
		WebElement boxD  = driver.findElement(By.xpath("//li[text()='D']"));		
		
		
		actions.moveToElement(boxA);
		actions.clickAndHold();
		actions.moveToElement(boxD);
		actions.contextClick(boxD);
		actions.doubleClick(boxD);

		actions.build().perform();
		
		Thread.sleep(3000);
		
		driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		
		WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement element2 = driver.findElement(By.id("droppable"));
		
		actions.dragAndDrop(element1, element2);
		actions.build().perform();
		
		driver.quit();
		System.out.println("Done");
		
	}

}
