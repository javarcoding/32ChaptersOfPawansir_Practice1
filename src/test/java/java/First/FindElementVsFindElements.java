package First;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		
		//FindElement --> Return the single webelement
		//1]
		WebElement searchBox=driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]"));
		searchBox.sendKeys("xyz");
		
		//2]When element is not present on webpage then it throw NoSuchElementException
		//driver.findElement(By.xpath("//button[@type=\"login\"]"));
		
		//FindElements --> Return the multiple webelements
		
		List<WebElement> links=driver.findElements(By.xpath("//div[@class=\"footer\"]//a"));
		System.out.println("number of webelement  captured"+links.size());
		
		//for action 
		for (WebElement ele:links ) 
		{
		     System.out.println(ele.getText());
			
		}
		
		//2 Single webelement 
		List<WebElement> logo=driver.findElements(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		System.out.println("Number of webelements captured::"+logo.size());
		
		//3 When element is not present on webpage then it returns '0'
		List<WebElement> element=driver.findElements(By.xpath("//img[contains(title, 'Electronics')]"));
		System.out.println("Number of webelements captured::"+element.size());
		
	}

}
