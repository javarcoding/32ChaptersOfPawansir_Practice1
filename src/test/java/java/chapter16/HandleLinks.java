package chapter16;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//linkText() method and partialLinkText() method
		
		//driver.findElement(By.linkText("Today's Deals")).click();
		//driver.findElement(By.partialLinkText("Deals")).click();
		
		//how to capture all the links 
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number of links::"+links.size());
		
		//Normal for loop (To read link from links)
		
		/*
		for (int i=0; i<=links.size();i++) 
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}
		*/
		//for each loop
		
		for (WebElement link:links) 
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
	
		driver.close();
	}
	

}
