package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		driver.get("https://google.com");
		String originalWindow = driver.getWindowHandle();
		
		driver.navigate().to("https://selenium.dev");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.navigate().forward();
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().window(originalWindow);
		
		Dimension size = driver.manage().window().getSize();
	
		int width = size.getWidth();
		int height = size.getHeight();
		System.out.println("Width: "+width+" Height: "+height);
		driver.manage().window().setSize(new Dimension(800,600));	
		
		Point position = driver.manage().window().getPosition();
		
		int x = position.getX();
		int y = position.getY();
		
		System.out.println("X : "+x+" Y: "+y);
		
		driver.manage().window().setPosition(new Point(500,100));	
	
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./image.png"));
		
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File scrFile1 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./image1.png"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		WebElement button =driver.findElement(By.name("btnI"));
		String text = (String) js.executeScript("return arguments[0].innerText", button);

		js.executeScript("arguments[0].click();", button);

		js.executeScript("console.log('hello world')");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
