package chapter26;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScrenshots {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com");
		
		//Full Page Screenshot
		/*
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshot\\homepage.png");
		FileUtils.copyFile(src, trg);
		
		
		//Screenshot of section/portion of the page
		
		WebElement section=driver.findElement(By.xpath("//div[@class='product-grid home-page-prduct-grid']"));
		File src=section.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshot\\featureproduct.png");
		FileUtils.copyFile(src, trg);
		*/
		
		//Screenshot of section/portion of the page
		
		WebElement ele=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		File src=ele.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshot\\featureproduct.png");
		FileUtils.copyFile(src, trg);
		
		driver.close();
		
	}

}
