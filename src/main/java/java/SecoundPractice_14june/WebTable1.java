package SecoundPractice_14june;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		int i; 
		List<WebElement> eleRow=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		int row_count=eleRow.size();
		
		List<WebElement> eleCol=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td"));
		int col_count=eleCol.size();
		
		for(int j=2;j<=row_count;j++) 
		{
			System.out.println();
			for(i=1;i<=col_count;i++) 
			{
				String name=driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+j+"]/td["+i+"]")).getText()+"  ";
				System.out.print(name+" ");
			}
		}
		
	}

}
