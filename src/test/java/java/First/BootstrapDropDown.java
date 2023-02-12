package First;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://hdfcbank.com");
		
		driver.findElement(By.xpath("//*[@version=\"1.0\"]")).click();
		
		driver.findElement(By.xpath("//div[@class=\"drp1\"]//div[@class=\"dropdown open\"]"));
		
		
		List<WebElement> producttype= driver.findElements(By.xpath("//ul[@class=\"dropdown1 dropdown-menu\"]/li"));
		System.out.println(producttype);
		
		for (WebElement ptype:producttype) 
		{
			if (ptype.getText().equals("Accounts"))
			{
				ptype.click();
				break;
			}
		}
	}

}
