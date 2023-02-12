package chapter17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");
		/*
		//Alert window with OK button
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		*/
		
		//Alert window with OK and Cancel button
		driver.findElement(By.xpath("//button[@id=\"confirmButton\"]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();   //Close alert by using OK button
		
		//driver.switchTo().alert().dismiss();  //Close alert by using Cancel button
		
		//Alert window with input box, capture text from alert
		
		driver.findElement(By.xpath("//button[@id=\"promtButton\"]")).click();
		Alert alt=driver.switchTo().alert();
		System.out.println("The massage displayed on alert::"+alt.getText());
		alt.sendKeys("Welcome");
		Thread.sleep(3000);
		alt.accept();
		
		driver.close();
		
	}

}
