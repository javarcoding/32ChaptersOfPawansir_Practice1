package chapter8;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		WebElement drpcountryEle=driver.findElement(By.id("input-country"));
		Select drpcountry=new Select(drpcountryEle);
		
		//selectByVisibleText
		drpcountry.selectByVisibleText("Denmark");
		Thread.sleep(3000);
		
		//SelectByValue
		drpcountry.selectByValue("10");
		
		//selectByIndex
		drpcountry.selectByIndex(13);
		
		//Select option from dropdown without using select method
		List<WebElement> alloption=drpcountry.getOptions();
		
		for (WebElement option:alloption) 
		{
			if (option.getText().equals("Cuba"))
			{
				option.click();
				break;
			}
		}
		driver.close();
	}

}
