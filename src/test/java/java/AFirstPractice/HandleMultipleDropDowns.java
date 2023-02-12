package AFirstPractice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		
		driver.findElement(By.xpath("//input[@name=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();
		
		//Approach-1
		Select employeeStatusdrp=new Select(driver.findElement(By.id("empsearch_employee_status")));
		employeeStatusdrp.selectByVisibleText("Freelance");
		
		Select subUnitdrp=new Select(driver.findElement(By.id("empsearch_sub_unit")));
		subUnitdrp.selectByVisibleText("Engineering");
		
		Select jobTitledrp=new Select(driver.findElement(By.id("empsearch_job_title")));
		jobTitledrp.selectByVisibleText("Engineer");
		
		Select includeEle=new Select(driver.findElement(By.xpath("//*[@name=\"empsearch[termination]\"]")));
		includeEle.selectByVisibleText("Current Employees Only");
		
		//Approach-2
		WebElement employeestatusEle=driver.findElement(By.id("empsearch_employee_status"));
		selectOptionFromDropDown(employeestatusEle, "Freelance");
		
		WebElement subUnitEle=driver.findElement(By.id("empsearch_sub_unit"));
		selectOptionFromDropDown(subUnitEle, "Engineering");
		
		WebElement jobTitleEle=driver.findElement(By.id("empsearch_job_title"));
		selectOptionFromDropDown(jobTitleEle, "Engineer");
		
		WebElement includeaEle=driver.findElement(By.xpath("//*[@name=\"empsearch[termination]\"]"));
		selectOptionFromDropDown(includeaEle, "Freelance");
		
	}

	private static void selectOptionFromDropDown(WebElement ele, String value) 
	{
		Select drp=new Select(ele);
		List<WebElement> allOptions=drp.getOptions();
		
		for (WebElement option:allOptions) 
		{
			if (option.getText().equals(value)) 
			{
				option.click();
				break;
			}
		}
	}

}
