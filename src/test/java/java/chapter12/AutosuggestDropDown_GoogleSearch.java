package chapter12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestDropDown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("selenium");
		
		List<WebElement> list=driver.findElements(By.xpath("//li[@class=\"sbct\"]"));
		System.out.println("Size of autosuggesion::"+list.size());
		
		Thread.sleep(3000);
		for ( WebElement ListItem:list) 
		{
			if (ListItem.getText().contains("download")) 
			{
				ListItem.click();
				break;
				
			}
		}
		
	}
}
