package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// find elements

		driver.get("https://google.com/");

		WebElement searchBox1 = driver.findElement(By.name("q"));
		searchBox1.sendKeys("Selenium"+ Keys.ENTER);
		driver.findElement(By.name("btnk")).click();

		//find elements
		driver.get("https://trytestingthis.netlify.app/");

		List <WebElement> elements = driver.findElements(By.tagName("select"));

		for (WebElement element: elements) {
			System.out.println(element.getText());
		}

		//find element within element
		driver.get("https://google.com");
		WebElement searchForm = driver.findElement(By.tagName("form"));
		WebElement searchBox2 = searchForm.findElement(By.name("q"));
		searchBox2.sendKeys("Selenium"+ Keys.ENTER);

		//get active element
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		String title = driver.switchTo().activeElement().getAttribute("title");

		System.out.println(title);

		//get element tagname, text, css:
		driver.get("http://www.google.com");
		WebElement searchBox3 = driver.findElement(By.name("q"));
		String tagName = searchBox3.getTagName();
		String text = searchBox3.getText();
		String cssFont = searchBox3.getCssValue("font");

		System.out.println("Tag Name: "+tagName+" Text: "+text+" Font: "+ cssFont);

		//check element is Enabled | is Selected
		driver.get("https://the-internet.herokuapp.com/checkboxes");

		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());
		Thread.sleep(1000);

		driver.quit();




	}

}
