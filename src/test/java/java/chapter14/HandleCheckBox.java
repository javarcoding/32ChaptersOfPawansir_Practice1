package chapter14;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) 
	{


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//1)Select specific checkbox
		//driver.findElement(By.xpath("//input[@id=\"monday\"]")).click();
		
		//2) Select all the check boxes
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type=\"checkbox\"and contains(@id, \"day\")]"));
		
		System.out.println("Total no. of checkboxes::"+ checkboxes.size());
		
		//using for loop
		/*
		for ( int i=0; i<=checkboxes.size(); i++) 
		{
			checkboxes.get(i).click();
		}
		
		 
		 
		//using for..each loop
		for (WebElement chbox:checkboxes) 
		{
			chbox.click();
		}
		 
		//3)Select Multiple checkboxes by chice
		//Monday and Sunday
		
		for (WebElement chboxs:checkboxes) 
		{
			String checkboxname=chboxs.getAttribute("id");
			if (checkboxname.equals("monday")|checkboxname.equals("sunday"))
			{
				chboxs.click();
			}
		}
	
		*/
		//4)Select Last 2 check boxes
		
		//first count how many checkboxes are there
		//formula=total checkboxes how many check boxes u want to select or (last number of elements)
		//5=7-2
		int totalCheckboxes =checkboxes.size()-1;
		System.out.println(totalCheckboxes);
		/*
		for (int i = totalCheckboxes-2; i<=totalCheckboxes;i++) 
		{
			checkboxes.get(i).click();
		} 
		 */
		//5) Select fast 3 check boxes
		
		for ( int i=0; i<=totalCheckboxes;i++) 
		{
			if (i<3) 
			{
				checkboxes.get(i).click();
			}
		}
		
		
	}
    
}
