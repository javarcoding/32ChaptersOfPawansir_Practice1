package chapter23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropImages {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame lazyloaded\"]")));
		WebElement Item1=driver.findElement(By.xpath("//ul[@id=\"gallery\"]/li[1]"));
		WebElement Item2=driver.findElement(By.xpath("//ul[@id=\"gallery\"]/li[2]"));
		
		WebElement trash=driver.findElement(By.xpath("//div[@id=\"trash\"]"));
		
		//Moved both items into trash
		Actions act=new Actions(driver);
		
		act.dragAndDrop(Item1, trash).perform();
		act.dragAndDrop(Item2, trash).perform();
		
		
	}

}
