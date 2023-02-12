package chapter27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/tooltip/");
		
		driver.switchTo().frame(0);
		
		WebElement inputbox=driver.findElement(By.xpath("//input[@id=\"age\"]"));
		
		String tooltiptext=inputbox.getAttribute("title");
		System.out.println(tooltiptext);
	}

}
