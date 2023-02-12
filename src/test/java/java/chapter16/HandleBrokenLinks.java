package chapter16;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		int brokenlinks=0;
		for (WebElement element:links)
		{ 
			String url=element.getAttribute("Href");
			
			if (url==null||url.isEmpty())
			{
				System.out.println("URL is empty");
				continue;
			}
			URL link=new URL(url);
			try
			{
				HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				httpconn.connect();
				if (httpconn.getResponseCode()>=400) 
				{
					System.out.println(httpconn.getResponseCode()+url+" is"+" Broken link" );
					brokenlinks++;
				}
				else
				{
					System.out.println(httpconn.getResponseCode()+url+" is"+" valid link" );
					
				}
			} 
			catch (Exception e)
			{
				
			}
		}
		System.out.println("Number of broken links:" +brokenlinks);
		driver.quit();
	}

}
