package First_Practice_10April;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// 1] How many rows in table
		int rows = driver.findElements(By.xpath("//table[@id=\"customers\"]//tbody/tr")).size();
		System.out.println("Total number of rows::" + rows);

		// 2] How many rows in table
		int cols = driver.findElements(By.xpath("//table[@id=\"customers\"]//tbody/tr/th")).size();
		System.out.println("Total number of rows::" + cols);
		
		//3] Retrieve specific rows/columns value
		String value=driver.findElement(By.xpath("//table[@id=\"customers\"]//tbody/tr[2]/td[2]")).getText();
		System.out.println(value);
		
		//4]Retrieve all data from table
		
		System.out.println("data from table::");
		
		for (int r=2;r<=rows; r++) 
		{
			for (int c=1;c<=cols; c++) 
			{
				String data=driver.findElement(By.xpath("//table[@id=\"customers\"]//tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.println(data+" ");	
			}
			System.out.println();
		}
		
	  //Print all
		
		for (int r=2;r<=rows; r++) 
		{
			String company=driver.findElement(By.xpath("//table[@id=\"customers\"]//tbody/tr["+r+"]/td[1]")).getText();
			
			if (company.equals("Ernst Handel")) 
			{
				String contact=driver.findElement(By.xpath("//table[@id=\"customers\"]//tbody/tr["+r+"]/td[2]")).getText();
				String country=driver.findElement(By.xpath("//table[@id=\"customers\"]//tbody/tr["+r+"]/td[3]")).getText();
				
				System.out.println(company+" "+contact+" "+country);	
			}
			System.out.println();
		}
	}

}
