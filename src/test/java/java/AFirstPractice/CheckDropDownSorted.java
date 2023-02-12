package AFirstPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.TwoPlugs.com");
		
		driver.findElement(By.xpath("//a[text()=\"Live Posting\"]")).click();
		WebElement drpElement=driver.findElement(By.name("category_id"));
		
	
	}

}
