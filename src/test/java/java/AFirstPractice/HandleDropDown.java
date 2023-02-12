package AFirstPractice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		WebElement drpcountryEle=driver.findElement(By.id("input-country"));
		Select drpcountry=new Select(drpcountryEle);
		
		//selectByVisibleText
		drpcountry.selectByVisibleText("Armenia");
		
		//selectByValue
		drpcountry.selectByValue("1");
		
		//selectByValue
		drpcountry.selectByValue("15");
		
		//without Select class
		List<WebElement> allOption=drpcountry.getOptions();
		
		for (WebElement option:allOption) 
		{
			if (option.getText().equals("Cuba")) 
			{
				option.click();
				break;
			}
			
		}
		
		

	}

}
