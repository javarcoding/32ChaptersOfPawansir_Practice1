package First_Practice_10April;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application");

		driver.findElement(By.id("dob")).click();

		// Month selection

		WebElement month = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		Select mon = new Select(month);
		mon.selectByVisibleText("Sep");

		// Year selection

		WebElement year = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		Select yr = new Select(year);
		yr.selectByVisibleText("2022");
		
		//Date selection
		String date="15";
		List<WebElement> alldate=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr/td"));
		
		for (WebElement ele:alldate) 
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
