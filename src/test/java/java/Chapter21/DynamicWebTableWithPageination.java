package Chapter21;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWithPageination 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/admin/index.php");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login 
		WebElement username=driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.id("input-username"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		//Sales-->order
		driver.findElement(By.xpath("//a[@href=\"#collapse26\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"collapse26\"]//li[1]/a")).click();
		
		//Table
		
		//1)Find Total Number of pages in table
		
		String text=driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-right\"]")).getText();
		System.out.println(text); //showing 1 to 20 of 11083(555 Pages)
		
		int Total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println("Total Number of pages::"+Total_pages);
		
		//2) Find how many rows exists in eachPage
		
		for (int p=1; p<=5;p++) 
		{
			WebElement active_pages=driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li/span"));
			System.out.println("Active Pages::"+active_pages.getText());
			active_pages.click();
			
			int rows=driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]/tbody/tr")).size();
			System.out.println("Number of rows::"+rows);
			
			for (int r=1;r<=rows; r++) 
			{
				String orderID=driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]/tbody/tr[+r+]/td[2]")).getText();
				String customerName=driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]/tbody/tr[+r+]/td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]/tbody/tr[+r+]/td[4]")).getText();
				
				if (status.equals("Pending")) 
				{
					System.out.println(orderID+" "+customerName+" "+status); 
					
				}
			}
			
			String pageno=Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li/a[text()='"+pageno+"']")).click();
			
		}
		
		
		driver.close();
		
	}

}
