package chapter22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in");

		String year="2022";
		String month="May";
		String date="22";
		
		driver.findElement(By.id("onward_cal")).click();
		
		while (true) 
		{
			String monthyrs=driver.findElement(By.xpath("//*[@class=\"monthTitle\"]")).getText();
			String arr[]=monthyrs.split(" ");
			String mon=arr[0];
			String yr=arr[1];
			
			if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) 
			{
				break;
			}
			else 
			{
				driver.findElement(By.xpath("//*[@class=\"next\"]")).click();
			}
		}
		
		//Date Selection
		
		
		List<WebElement> alldate=driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]/tbody/tr/td"));
		
		for (WebElement ele:alldate) 
		{
			String dt=ele.getText();
			if (dt.equals(date)) 
			{
				ele.click();
				break;
			}
		}
		
		
		

	}

}
