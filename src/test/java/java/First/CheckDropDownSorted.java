package First;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted {

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.TwoPlugs.com");
		
		driver.findElement(By.xpath("//a[text()=\"Live Posting\"]")).click();
		WebElement drpElement=driver.findElement(By.name("category_id"));
		Select drpSelect=new Select(drpElement);
		List<WebElement> options=drpSelect.getOptions();
		
		ArrayList originalList=new ArrayList();
		ArrayList tempList=new ArrayList();
		
		for ( WebElement option:options) 
		{
			originalList.add(option.getText());
			tempList.add(option.getText());
			
		}
		System.out.println("Original List ::"+originalList); 
		System.out.println("Temp List After Sorting::"+tempList);
		
		Collections.sort(tempList); //sorting
		
		System.out.println("Original List ::"+originalList); 
		System.out.println("Temp List After Sorting::"+tempList);
		
		if (originalList.equals(tempList)) 
		{
			System.out.println("DropDown sorted..");
		}
		else
		{
			System.out.println("DropDown unsorted..");
			
		}
		
	}

}
