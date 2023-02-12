package chapter23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com");
		
		WebElement desktopsMenu=driver.findElement(By.xpath("//a[text()=\"Desktops\"]"));
		WebElement MacMenuItem=driver.findElement(By.xpath("//a[text()=\"Mac (1)\"]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(desktopsMenu).moveToElement(MacMenuItem).click().perform();
		
		
		

	}

}
