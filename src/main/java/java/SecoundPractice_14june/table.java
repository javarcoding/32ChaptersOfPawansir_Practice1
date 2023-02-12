package SecoundPractice_14june;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class table {

	public static void main(String[] args) 
	{
		FileInputStream fin=null;
		WebDriver driver=null;
		Properties p=null;
		try
		{
			fin=new FileInputStream(System.getProperty("user.dir")+"\\demo.properties");
			p=new Properties();
			p.load(fin);
			/*
			String Dpath=p.getProperty("driverPath"),wpath=p.getProperty("driverName");
			System.setProperty(wpath, Dpath);
			driver=new ChromeDriver();
			*/
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			
			List<WebElement> eleRow=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
			int row_count=eleRow.size();
			
			List<WebElement> eleCol=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td"));
			int col_count=eleCol.size();
			int i;
			
			//Printing Header
			for(i=1;i<=col_count;i++) {
				String name=driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th["+i+"]")).getText()+"  ";
				System.out.print(name+" \t\t\t ");
			}
			
			for(int j=2;j<=row_count;j++) 
			{
				System.out.println();
				for(i=1;i<=col_count;i++) 
				{
					String name=driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+j+"]/td["+i+"]")).getText()+"  ";
					System.out.print(name+" \t\t\t ");
				}
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error "+e);
		}
	}

}
