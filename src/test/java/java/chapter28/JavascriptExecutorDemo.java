package chapter28;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com");
		
		//Syntax: -
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript(script, args);
		
		//flash
		WebElement logo=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		JavaScriptUtil.flash(logo, driver);
		
		//Drawing border & take screenshot
			//WebElement logo=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
			JavaScriptUtil.drawBorder(logo, driver);
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg=new File(".\\screenshot\\logo.png");
			FileUtils.copyFile(src, trg);
			
		
		//Getting title of the page
			String title=JavaScriptUtil.getTitleByJS(driver);
			System.out.println(title);
			
		//Click action
			//WebElement reglink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
			//JavaScriptUtil.clickElementByJS(reglink, driver);
		
		//Generate alert
		//JavaScriptUtil.generateAlert(driver, "This is my Alert...");
		
		//Refreshing the page
		JavaScriptUtil.refreshBorderByJS(driver);
		
		//Scrolling down page
			JavaScriptUtil.scrollPageDown(driver);
		    
			Thread.sleep(2000);
		//Scroll up page
			JavaScriptUtil.scrollPageUp(driver);
			
		//zoom page
			JavaScriptUtil.zoomPageByJS(driver);
	}

}
