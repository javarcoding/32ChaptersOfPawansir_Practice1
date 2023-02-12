package chapter31;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.monsterindia.com");
		
		driver.findElement(By.xpath("//span[@class=\"uprcse semi-bold\"]")).click();
		
		//using SendKey()
		driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys("C:\\seniumPractice\\sample.pdf");
		
		//using Robot class method
		WebElement button=driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", button); //click action on button
		
		/*
		1)Copy the Path
		2)CTRL + V
		3)Enter
		*/
		
		Robot rb=new Robot();
		rb.delay(2000);
		
		//put the path in clipboard
		StringSelection ss=new StringSelection("C:\\seniumPractice\\sample.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents( ss, null);
		
		//CTRL + V
		rb.keyPress(KeyEvent.VK_CONTROL); //press on CTRL 
		rb.keyPress(KeyEvent.VK_V); //press on v
		
		rb.keyRelease(KeyEvent.VK_CONTROL); //Release CTRL 
		rb.keyRelease(KeyEvent.VK_V); //Release  v
		
		//Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
