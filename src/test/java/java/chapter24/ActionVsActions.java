package chapter24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVsActions {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		
		WebElement feature=driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		
		Actions act=new Actions(driver);
		//act.moveToElement(feature).perform();
		
		Action action=act.moveToElement(feature).build();
		action.perform();
		
	}

}
