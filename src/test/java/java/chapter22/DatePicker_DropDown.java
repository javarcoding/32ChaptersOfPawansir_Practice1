package chapter22;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application");
		driver.findElement(By.id("dob")).click(); //open the date picker
		
		//Month and year select
		
		Select month_drp=new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]")));
		month_drp.selectByVisibleText("Oct");
		
		Select year_drp=new Select(driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")));
		year_drp.selectByVisibleText("1997");
		
		//Date Select
		String date="10";
		List<WebElement> alldate=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td"));
		
		for (WebElement ele:alldate ) 
		{
			String dt=ele.getText();
			if (dt.equals(date)) 
			{
				ele.click();
				break;
			}
		}
		
		
	}

}
