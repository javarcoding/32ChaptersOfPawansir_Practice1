package chapter15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		/*
		//1) getWindowHandle()
		String WindowID=driver.getWindowHandle(); //return ID of single browser window
		System.out.println(WindowID); //CDwindow-F0E7C5DD24F4EFEE0AB51ED6CA899A8A
		*/
		driver.findElement(By.xpath("//a[text()=\"OrangeHRM, Inc\"]")).click(); //open another browser window = child window
		
		//2) getWindowHandles()
		Set<String> WindowIDs=driver.getWindowHandles(); //return ID's of multiple browser windows
		/*
		//First Method - Iterator()  //This method is used to retrive the ID from windowIDs
		
		Iterator<String> it=WindowIDs.iterator();
		String parentWindowID=it.next();
		String childWindowID=it.next();
		
		System.out.println("Parent Window ID::"+parentWindowID);
		System.out.println("Child Window ID::"+childWindowID);
		*/
		
		//Second Method - Using list/ArrayList
		
		List<String> WindowIDsList=new ArrayList(WindowIDs);
		
		String parentWindowID=WindowIDsList.get(0);  //parent Window ID
		String childWindowID=WindowIDsList.get(1);   //Child Window ID
		
		System.out.println("Parent Window ID::"+parentWindowID);
		System.out.println("Child Window ID::"+childWindowID);
		
		//how to use window IDs for switching
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window title ::"+driver.getTitle());
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child window title ::"+driver.getTitle());
		
		//for each Loop
		
		for (String winid:WindowIDsList) 
		{
			System.out.println(winid);
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}
		//driver.close();  //close single browser driver which pining 
		//driver.quit(); //close all the browser windows
		
		for (String winid:WindowIDsList) 
		{
			String title=driver.switchTo().window(winid).getTitle();
			if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS\r\n")) 
			{
				driver.close();
			}
			System.out.println(title);
		}
		
	

	}

}
