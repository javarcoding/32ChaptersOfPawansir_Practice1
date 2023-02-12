package chapter20;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//1) How many rows in table
		
		int rows=driver.findElements(By.xpath("table[@id=\"customers\"]//tbody/tr")).size();
		System.out.println("Total number of rows::"+rows);
		/*
		//1) How many columns in table
		
		int cols=driver.findElements(By.xpath("table[@id=\"customers\"]/tbody/tr/th")).size();
		System.out.println("Total number of columns::"+cols);
				
		//3) Retrive the specific row/column data
		
		String value=driver.findElement(By.xpath("table[@id=\"customers\"]//tbody/tr[2]/th[1]")).getText();
		System.out.println("The value is:"+value);
		
		//4) Retrieve all the data from the table
		
		System.out.println("Data from table::");
		
		for (int r=2; r<=rows; r++) 
		{
			for (int c=1;c<=rows;c++) 
			{
				String data=driver.findElement(By.xpath("table[@id=\"customers\"]//tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.println(data+" ");
			}
			System.out.println();
		}
		
		//5) Print release
		
		for (int r=2;r<=rows;r++) 
		{
			String Company=driver.findElement(By.xpath("table[@id=\"customers\"]//tbody/tr["+r+"]/td[1]")).getText();
			if (Company.equals("Ernst Handle")) 
			{
				String Contact=driver.findElement(By.xpath("table[@id=\"customers\"]//tbody/tr["+r+"]/td[2]")).getText();
				String Country=driver.findElement(By.xpath("table[@id=\"customers\"]//tbody/tr["+r+"]/td[2]")).getText();
				
				System.out.println(Company+" "+Contact+" "+Country );
				
			}
		}
		*/
		driver.close();
	}
		
}
