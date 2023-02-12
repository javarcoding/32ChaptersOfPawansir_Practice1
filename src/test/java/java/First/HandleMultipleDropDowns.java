package First;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		
		driver.findElement(By.xpath("//input[@name=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();
		
		//Approach-1
		Select EmploymentStatusdrp=new Select(driver.findElement(By.id("empsearch_employee_status")));
		EmploymentStatusdrp.selectByVisibleText("Freelance");
		
		Select SubUnitdrp=new Select(driver.findElement(By.id("empsearch_sub_unit")));
		SubUnitdrp.selectByVisibleText("Engineering");
		
		Select Jobcludebrp=new Select(driver.findElement(By.id("empsearch_job_title")));
		Jobcludebrp.selectByVisibleText("Engineer");
		
		Select Includebrp=new Select(driver.findElement(By.id("empsearch_termination")));
		Includebrp.selectByVisibleText("Current Employees Only");
		
		//Approach-2
		WebElement EmploymentStatusEle=driver.findElement(By.id("empsearch_employee_status"));
		selectOptionFromDropDown(EmploymentStatusEle, "Freelance");
		
		WebElement SubUnitEle=driver.findElement(By.id("empsearch_sub_unit"));
		selectOptionFromDropDown(SubUnitEle, "Engineering");
		
		WebElement JobTitleEle=driver.findElement(By.id("empsearch_job_title"));
		selectOptionFromDropDown(JobTitleEle, "Engineer");
		
		WebElement IncludeEle=driver.findElement(By.id("empsearch_termination"));
		selectOptionFromDropDown(IncludeEle, "Current Employees Only");
		

	}

	private static void selectOptionFromDropDown(WebElement ele, String value) 
	{
		Select drp=new Select(ele);
		List<WebElement> allOption=drp.getOptions();
		
		for (WebElement option:allOption) 
		{
				if (option.getText().equals(value)) 
				{
				option.click();
				break;
				}
			
		}
	}

}
